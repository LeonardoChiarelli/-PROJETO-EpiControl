package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnexarCasosDTO(
        Long id,

        @NotBlank
        String idOuNomeCidade,

        @NotBlank
        String idOuNomeDoenca,

        @NotNull
        Integer numeroDeCasos,

        @NotNull
        Integer numeroDeObitos,

        @NotNull
        Integer numeroDeRecuperados
) {
}
