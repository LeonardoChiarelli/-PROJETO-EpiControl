package br.com.epiControl.domain.service;

import br.com.epiControl.domain.dto.AtualizarDadosCidadeDTO;
import br.com.epiControl.domain.dto.CadastrarCidadeDTO;
import br.com.epiControl.domain.dto.ListaCidadesDTO;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.general.exception.ValidacaoException;
import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.repository.ICidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private ICidadeRepository repository;

    public Cidade cadastrar(@Valid CadastrarCidadeDTO dto) {

        var cidadeCadastrada = repository.existsByNome(dto.nome());
        if (cidadeCadastrada) { throw new ValidacaoException("Essa cidade já esta cadastrada"); }

        var cidade = new Cidade(dto);
        repository.save(cidade);
        return cidade;
    }

    public Page<ListaCidadesDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(ListaCidadesDTO::new);
    }

    public Cidade detalhar(String idOuNome) {
        return HelperMethod.carregarCidade(idOuNome);
    }

    public List<Cidade> listarJOption() {
        return repository.findAll();
    }

    public Cidade atualizarInfo(AtualizarDadosCidadeDTO dto) {
        var cidade = HelperMethod.carregarCidade(dto.idOuNome());
        cidade.atualizarInfo(dto);
        repository.save(cidade);
        return cidade;
    }
}
