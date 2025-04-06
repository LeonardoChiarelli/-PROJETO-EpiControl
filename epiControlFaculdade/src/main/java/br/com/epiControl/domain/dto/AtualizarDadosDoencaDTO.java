package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.AgenteCausador;

import java.util.List;

public record AtualizarDadosDoencaDTO(
        List<AgenteCausador> agenteCausador,
        List<String> sintomas,
        List<String> formasDeTransmissao,
        List<String> medidasDePrevencao,
        Double taxaDeTransmissao
) {
}
