package br.com.epiControl.domain.dto;

public record AtualizarDadosCasosDTO(
        Integer numeroDeCasos,
        Integer numeroDeObitos,
        Integer numeroDeRecuperados,
        Boolean status
) {
}
