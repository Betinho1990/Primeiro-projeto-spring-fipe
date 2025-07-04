package br.com.alura.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloResponse(List<Modelo> modelos) {

}
