package service;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import service.impl.ReportProductImpl;

public class ReportProductTest extends TestCase {
    private static ReportProduct reportProduct;
    private static ProductService productService;

    @BeforeClass
    public static void beforeClass() {
        reportProduct = new ReportProductImpl();
    }

    @Test
    public void productReport_getReport_OK() {

    }

}