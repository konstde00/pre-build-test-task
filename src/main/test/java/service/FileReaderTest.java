package service;

import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.DataReader;
import service.impl.FileReader;

class FileReaderTest {
    private static DataReader fileReader;

    @BeforeClass
    public static void beforeClass() {
        fileReader = new FileReader();
    }

    @Test
    public void fileReader_correctData_OK() {
        List<String> expected = List.of("Correct data");
        List<String> actual = fileReader
                .readFromDataSource("src/test/resources/readerTest.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void fileReader_incorrectFilePath_not_ok() {
        fileReader.readFromDataSource("");
    }
}