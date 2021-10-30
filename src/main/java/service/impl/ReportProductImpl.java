package service.impl;

import config.AppConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import service.ProductService;
import service.ReportProduct;

@Service
public class ReportProductImpl implements ReportProduct {
    private static final AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);
    private static ProductService productService = context.getBean(ProductService.class);

    public ReportProductImpl() {
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Product product : productService.getAll()) {
            if (productService != null) {
                stringBuilder.append("{")
                        .append("\"productUuid\":")
                        .append(product.getProductUuid())
                        .append("\",")
                        .append("\"productName\":")
                        .append(product.getProductName())
                        .append("\",")
                        .append("\"amount\":")
                        .append(product.getAmount())
                        .append("}")
                        .append(",");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).append("]");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
