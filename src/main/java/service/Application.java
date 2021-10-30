package service;

import config.AppConfig;
import dto.response.ProductResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.impl.FileReader;
import service.impl.WebSourceReader;
import service.mapper.ProductDtoMapper;
import util.ConsoleReaderUtil;
import util.DataSourceGetterUtil;

public class Application {
    private static final AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);
    private static ProductService productService = context.getBean(ProductService.class);
    private static DataReader fileReader = context.getBean(FileReader.class);
    private static DataReader webSourceReader = context.getBean(WebSourceReader.class);
    private static ProductParser parser = context.getBean(ProductParser.class);
    private static ReportProduct reportProduct = context.getBean(ReportProduct.class);
    private static Validator validator = context.getBean(Validator.class);
    private static ProductDtoMapper mapper = new ProductDtoMapper();
    private static ConsoleReaderUtil consoleReaderUtil = new ConsoleReaderUtil();

    private static List<String> filePaths = new ArrayList<>();
    private static List<String> urls = new ArrayList<>();

    public Application() {
    }

    public static void build() {
        consoleReaderUtil.readFromConsole();

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception in interruption", e);
        }

        filePaths = DataSourceGetterUtil.getFilePaths();
        urls = DataSourceGetterUtil.getUrls();

        filePaths.forEach(Application::workOutFilesInput);
        urls.forEach(Application::workOutUrlInput);

        System.out.println(reportProduct.getReport().trim());
    }

    public static void workOutFilesInput(String filePath) {
        List<String> dataFromFile = fileReader.readFromDataSource(filePath);
        for (String line : dataFromFile) {
            validator.checkInputData(line.split(","));
            ProductResponseDto productResponseDto = parser.parseData(line);
            Product newProduct = mapper.mapToModel(productResponseDto);
            if (productService.exists(newProduct)) {
                productService.update(newProduct);
            } else {
                productService.add(newProduct);
            }
        }
    }

    public static void workOutUrlInput(String url) {
        List<String> dataFromFile = webSourceReader.readFromDataSource(url);
        for (String line : dataFromFile) {
            validator.checkInputData(line.split(","));
            ProductResponseDto productResponseDto = parser.parseData(line);
            Product newProduct = mapper.mapToModel(productResponseDto);
            if (productService.exists(newProduct)) {
                productService.update(newProduct);
            } else {
                productService.add(newProduct);
            }
        }
    }

    public static void addUrl(String url) {
        urls.add(url);
    }

    public static void addFilePath(String path) {
        filePaths.add(path);
    }
}
