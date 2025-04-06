package br.com.epiControl.domain.dto;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.model.Doenca;

import java.time.LocalDate;

public record DetalhesCasosDTO(Cidade cidade, Doenca doenca, LocalDate dataDeRegistro, LocalDate ultimaAtualizacao, Integer numeroDeCasos, Integer numeroDeObitos, Integer numeroDeRecuperados, Boolean status) {
    public DetalhesCasosDTO(CasosEpidemiologicos cE){
        this(cE.getCidade(), cE.getDoenca(), cE.getDataDeRegistro(), cE.getUltimaAtualizacao(), cE.getNumeroDeCasos(), cE.getNumeroDeObitos(), cE.getNumeroDeRecuperados(), cE.getStatus());
    }
}
