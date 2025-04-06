package br.com.epiControl.domain.service;

import br.com.epiControl.domain.dto.AnexarCasosDTO;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.repository.ICasosRepository;
import br.com.epiControl.general.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasosService {

    @Autowired
    private ICasosRepository repository;

    public CasosEpidemiologicos anexar(@Valid AnexarCasosDTO dto) {
        var doencaJaAnexada = repository.existsByCidadeIdAndDoencaId(dto.idCidade(), dto.idDoenca());
        if (doencaJaAnexada) { throw new ValidacaoException("Doença já anexada à cidade, considere apenas atualizar os dados"); }

        var cidade = 0;
        var doenca = 0;

        var caso = new CasosEpidemiologicos(dto);
    }
}
