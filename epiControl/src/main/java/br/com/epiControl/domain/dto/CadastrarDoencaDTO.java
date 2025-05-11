package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarDoencaDTO(

        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String agenteCausador,

        @NotBlank
        String sintomas,

        @NotBlank
        String formasDeTransmissao,

        @NotBlank
        String medidasDePrevencao,

        @NotNull
        Double taxaMortalidade,

        @NotNull
        Double taxaDeTransmissao

) {
}
