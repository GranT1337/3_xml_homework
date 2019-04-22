package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CategoryType;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class Converter {
    private final static String baseFile = "products.json";

    public void toJSON(List<CategoryType> item) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), item);

        System.out.println("json created!");
    }

    public List<CategoryType> toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), new TypeReference<List<CategoryType>>(){});
    }
}
