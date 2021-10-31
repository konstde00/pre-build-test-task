package dao;

import model.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductDaoImplTest extends AbstractTest {
    private ProductDao productDao = new dao.ProductDaoImpl(getSessionFactory());

    @Override
    protected Class<?>[] entities() {
        return new Class[]{Product.class};
    }

    @Test
    public void save_Ok() {
        Product box = new Product();
        box.setProductUuid("9b3e9312-b5f8-4d15-a291-4db1803cddac");
        box.setProductName("Box");
        box.setAmount(100);

        Product actual = productDao.save(box);
        Assertions.assertNotNull(actual);

        String expectedId = "9b3e9312-b5f8-4d15-a291-4db1803cddac";
        String actualId = actual.getProductUuid();
        Assertions.assertEquals(expectedId, actualId);
    }
}