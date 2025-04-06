package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AnexarCasosDTO(
        Long id,

        @NotNull
        Long idCidade,

        @NotNull
        Long idDoenca,

        @NotNull
        Integer numeroDeCasos,

        @NotNull
        Integer numeroDeObitos,

        @NotNull
        Integer numeroDeRecuperados
) {
}
