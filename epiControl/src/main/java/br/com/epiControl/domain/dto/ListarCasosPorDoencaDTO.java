package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.model.Doenca;

public record ListarCasosPorDoencaDTO(Long idCaso, Doenca doenca, Cidade cidade, Boolean status) {
    public ListarCasosPorDoencaDTO(CasosEpidemiologicos cE){
        this(cE.getId(), cE.getDoenca(), cE.getCidade(), cE.getStatus());
    }
}
