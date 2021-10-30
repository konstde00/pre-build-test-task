package controller;

import dto.response.ProductResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;
import service.mapper.ProductDtoMapper;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    public ProductController(ProductService productService,
                             ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @GetMapping("/")
   public List<ProductResponseDto> getAllProducts() {
        return productService
               .getAll()
               .stream()
               .map(productDtoMapper::parse)
               .collect(Collectors.toList());
    }
}
