package br.com.alura.fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter dados: " + e.getMessage());
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T[]> classe) {
        try {
            T[] array = mapper.readValue(json, classe);
            return Arrays.asList(array);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter lista: " + e.getMessage());
        }
    }
}