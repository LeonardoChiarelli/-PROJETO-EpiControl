package br.com.epiControl.domain.dto;

public record AtualizarDadosCasosDTO(
        Double numeroDeCasos,
        Integer numeroDeObitos,
        Double numeroDeRecuperados,
        Boolean status
) {
}
