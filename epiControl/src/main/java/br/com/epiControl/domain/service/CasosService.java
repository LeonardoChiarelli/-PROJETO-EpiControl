package br.com.epiControl.domain.service;

import br.com.epiControl.domain.dto.*;
import br.com.epiControl.domain.helper.CasosFormatter;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.repository.ICasosRepository;
import br.com.epiControl.general.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CasosService {

    @Autowired
    private ICasosRepository repository;

    public CasosEpidemiologicos anexar(@Valid AnexarCasosDTO dto) {

        var cidade = HelperMethod.carregarCidade(dto.idOuNomeCidade());
        var doenca = HelperMethod.carregarDoenca(dto.idOuNomeDoenca());

        var doencaJaAnexada = repository.existsByCidadeIdAndDoencaId(cidade.getId(), doenca.getId());
        if (doencaJaAnexada) { throw new ValidacaoException("Doença já anexada à cidade, considere apenas atualizar os dados"); }

        var caso = new CasosEpidemiologicos(dto, cidade, doenca);

        repository.save(caso);

        return caso;
    }

    public Page<ListarCasosPorDoencaDTO> listarCasosPorDoenca(String idOuNome, Pageable pageable) {
        var doenca = HelperMethod.carregarDoenca(idOuNome);
        return repository.findAllByDoencaId(doenca.getId(), pageable).map(ListarCasosPorDoencaDTO::new);
    }

    public Page<ListarCasosPorCidadeDTO> listarCasosPorCidade(String idOuNome, Pageable pageable) {
        var cidade = HelperMethod.carregarCidade(idOuNome);
        return repository.findAllByCidadeId(cidade.getId(), pageable).map(ListarCasosPorCidadeDTO::new);
    }

    public Page<ListarCasosPorCidadeEDocencaDTO> listarCasosPorCidadeEDoenca(String idOuNomeCidade, String idOuNomeDoenca, Pageable pageable) {
        var doenca = HelperMethod.carregarDoenca(idOuNomeDoenca);
        var cidade = HelperMethod.carregarCidade(idOuNomeCidade);
        return repository.findAllByCidadeIdAndDoencaId(cidade.getId(), doenca.getId(), pageable).map(ListarCasosPorCidadeEDocencaDTO::new);
    }

    public DetalhesCasosDTO detalharCaso(Long id) {
        return new DetalhesCasosDTO(repository.findById(id).orElseThrow(() -> new ValidacaoException("Id do caso não econtrado")));
    }

    public DetalhesCasosDTO atualizarDados(String idOuNomeCidade, String idOuNomeDoenca, @Valid AtualizarDadosCasosDTO dto) {
        var cidade = HelperMethod.carregarCidade(idOuNomeCidade);
        var doenca = HelperMethod.carregarDoenca(idOuNomeDoenca);

        var dataDeRegistro = repository.getReferenceByCidadeIdAndDoencaId(cidade.getId(), doenca.getId()).getDataDeRegistro();

        var caso = new CasosEpidemiologicos(cidade, doenca, dataDeRegistro, dto);

        repository.save(caso);

        return new DetalhesCasosDTO(caso);
    }

    public String listarCasosPorCidadeJOption() {
        return repository.findAll()
                .stream()
                .map(CasosFormatter::formatar)
                .collect(Collectors.joining("\n\n"));
    }
}
