package service;

import java.util.List;
import model.Product;

public interface ProductService {
    Product add(Product product);

    List<Product> getAll();

    Product get(String uuid);

    boolean exists(Product product);

    boolean existsWithSameId(String productUuId);

    Product update(Product product);
}
