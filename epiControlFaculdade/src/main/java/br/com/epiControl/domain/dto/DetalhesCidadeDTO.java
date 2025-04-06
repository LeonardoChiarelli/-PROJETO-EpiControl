package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.Cidade;

public record DetalhesCidadeDTO(Long id, String nome, String estado, Double populacao, Integer quantidadeHospitais, Integer quantidadePostosDeSaude) {
    public DetalhesCidadeDTO(Cidade c){
        this(c.getId(), c.getNome(), c.getEstado(), c.getPopulacao(), c.getQuantidadeHospitais(), c.getQuantidadePostosDeSaude());
    }
}
