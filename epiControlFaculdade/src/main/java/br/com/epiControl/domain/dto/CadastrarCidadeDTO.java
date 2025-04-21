package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarCidadeDTO(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 2, max = 2)
        String siglaEstado,

        @NotNull
        Double populacao,

        @NotNull
        Integer quantidadeHospitais,

        @NotNull
        Integer quantidadePostosDeSaude
){}
