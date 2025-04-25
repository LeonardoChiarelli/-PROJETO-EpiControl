package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.Doenca;

import java.util.List;

public record DetalhesDoencaDTO(Long id, String nome, String agenteCausador, String sintomas, String formasDeTransmissao, String medidasDePrevencao, Double taxaDeMortalidade, Double taxaDeTransmissao) {
    public DetalhesDoencaDTO(Doenca d){
        this(d.getId(), d.getNome(), d.getAgenteCausador(), d.getSintomas(), d.getFormasDeTransmissao(), d.getMedidasDePrevencao(), d.getTaxaDeMortalidade(), d.getTaxaDeTransmissao());
    }
}
