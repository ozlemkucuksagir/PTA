package com.smartIct.PublicTransport.Config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringToListConverter implements AttributeConverter<List<Integer>, String> {
    @Override
    //List<Integer> to String
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    //String to List<Integer>
    public List<Integer> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
