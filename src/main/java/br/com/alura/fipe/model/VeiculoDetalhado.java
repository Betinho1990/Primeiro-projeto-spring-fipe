package br.com.alura.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoDetalhado(
        @JsonProperty("Valor") String valor,
        @JsonProperty("Marca") String marca,
        @JsonProperty("Modelo") String modelo,
        @JsonProperty("AnoModelo") String anoModelo
) {
}
