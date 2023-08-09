package com.smartIct.PublicTransport.Const;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

    private static final String SEPARATOR = ",";

    @Override//IntegertoString
    public String convertToDatabaseColumn(List<Integer> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        return attribute.stream()
                .map(Object::toString)
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override//StringToInteger
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return Arrays.stream(dbData.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
