package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.AgenteCausador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;

public record CadastrarDoencaDTO(

        Long id,

        @NotBlank
        String nome,

        @NonNull
        List<AgenteCausador> agenteCausador,

        @NotNull
        List<String> sintomas,

        @NotNull
        List<String> formasDeTransmissao,

        @NotNull
        List<String> medidasDePrevencao,

        @NotNull
        Double taxaDeTransmissao

) {
}
