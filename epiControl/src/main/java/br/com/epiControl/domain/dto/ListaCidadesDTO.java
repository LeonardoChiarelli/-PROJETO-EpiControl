package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.Cidade;

public record ListaCidadesDTO(Long id, String nome, String estado) {
    public ListaCidadesDTO(Cidade c){
        this(c.getId(), c.getNome(), c.getEstado());
    }
}
