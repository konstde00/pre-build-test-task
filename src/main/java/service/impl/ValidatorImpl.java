package service.impl;

import org.springframework.stereotype.Service;
import service.Validator;

@Service
public class ValidatorImpl implements Validator {
    private static final int ID = 0;
    private static final int PRODUCT_NAME = 1;
    private static final int PRODUCT_AMOUNT = 2;

    @Override
    public boolean checkInputData(String[] data) {
        if (!isCorrectProductUuId(data[ID])
                || !isCorrectProductName(data[PRODUCT_NAME])
                || !isCorrectProductAmount(data[PRODUCT_AMOUNT])) {
            throw new RuntimeException("Incorrect input data");
        }
        return true;
    }

    private boolean isCorrectProductUuId(String productId) {
        //there we could add some checks for product Id, if we need
        return true;
    }

    private boolean isCorrectProductName(String productName) {
        //there we could add some checks for product name, if we need
        return true;
    }

    private boolean isCorrectProductAmount(String productAmount) {
        //there we could add some checks for product name, if we need
        return true;
    }
}
