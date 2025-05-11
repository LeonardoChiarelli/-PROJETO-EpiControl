package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AnexarCasosDTO(
        Long id,

        @NotBlank
        String idOuNomeCidade,

        @NotBlank
        String idOuNomeDoenca,

        @NotNull
        LocalDate dataDeRegistro,

        @NotNull
        Double numeroDeCasos,

        @NotNull
        Integer numeroDeObitos,

        @NotNull
        Double numeroDeRecuperados
) {
}
