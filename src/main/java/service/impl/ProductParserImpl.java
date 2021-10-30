package service.impl;

import dto.response.ProductResponseDto;
import org.springframework.stereotype.Service;
import service.ProductParser;

@Service
public class ProductParserImpl implements ProductParser {
    private static final String COMMA = ",";
    private static final int ID_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int ID_BEGIN_INDEX = 16;
    private static final int ID_END_INDEX = 50;
    private static final int NAME_BEGIN_INDEX = 13;
    private static final int AMOUNT_BEGIN_INDEX = 6;

    @Override
    public ProductResponseDto parseData(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");

        return new ProductResponseDto(getProductId(data),
                getProductName(data),
                getAmount(data));
    }

    private String getProductId(String data) {
        return data.split(COMMA)[ID_INDEX]
                .substring(ID_BEGIN_INDEX, ID_END_INDEX);
    }

    private String getProductName(String data) {
        return data.split(COMMA)[NAME_INDEX].substring(NAME_BEGIN_INDEX)
                .substring(0, data.split(COMMA)[NAME_INDEX]
                        .substring(NAME_BEGIN_INDEX).length() - 1);
    }

    private int getAmount(String data) {
        return Integer.parseInt(data.split(COMMA)[AMOUNT_INDEX]
                .replaceAll("}", "")
                .replaceAll("\"", "")
                .replaceAll(":", "")
                .substring(AMOUNT_BEGIN_INDEX));
    }
}
