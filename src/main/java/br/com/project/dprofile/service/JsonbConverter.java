package br.com.project.dprofile.service;

import br.com.project.dprofile.entity.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JsonbConverter implements AttributeConverter<UserData, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(UserData attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Erro ao converter para JSON", e);
        }
    }

    @Override
    public UserData convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, UserData.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter JSON para UserData", e);
        }
    }
}
