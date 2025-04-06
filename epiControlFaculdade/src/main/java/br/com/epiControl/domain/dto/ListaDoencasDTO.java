package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.AgenteCausador;
import br.com.epiControl.domain.model.Doenca;

import java.util.List;

public record ListaDoencasDTO(Long id, String nome, List<AgenteCausador> agenteCausador, List<String> formasDeTransmissao) {
    public ListaDoencasDTO(Doenca d){
        this(d.getId(), d.getNome(), d.getAgenteCausador(), d.getFormasDeTransmissao());
    }
}
