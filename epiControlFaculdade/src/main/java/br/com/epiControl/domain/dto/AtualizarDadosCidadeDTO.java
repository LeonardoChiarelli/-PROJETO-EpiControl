package br.com.epiControl.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AtualizarDadosCidadeDTO(

        @NotBlank
        String idOuNome,

        Double populacao,
        Integer quantidadeHospitais,
        Integer quantidadePostosDeSaude
        ) {
}
