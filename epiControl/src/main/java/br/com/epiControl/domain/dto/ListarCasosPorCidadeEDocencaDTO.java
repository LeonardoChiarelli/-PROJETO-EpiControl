package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.model.Doenca;

public record ListarCasosPorCidadeEDocencaDTO(Long idCaso, Cidade cidade, Doenca doenca, Boolean status) {
    public ListarCasosPorCidadeEDocencaDTO(CasosEpidemiologicos cE){
        this(cE.getId(), cE.getCidade(), cE.getDoenca(), cE.getStatus());
    }
}
