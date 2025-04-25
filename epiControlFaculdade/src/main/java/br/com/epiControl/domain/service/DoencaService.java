package br.com.epiControl.domain.service;

import br.com.epiControl.domain.dto.CadastrarDoencaDTO;
import br.com.epiControl.domain.dto.DetalhesDoencaDTO;
import br.com.epiControl.domain.helper.DoencaFormatter;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.model.Doenca;
import br.com.epiControl.domain.repository.IDoencaRepository;
import br.com.epiControl.general.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DoencaService {

    @Autowired
    private IDoencaRepository repository;

    public Doenca cadastrar(@Valid CadastrarDoencaDTO dto) {
        var doencaCadastrada = repository.existsByNome(dto.nome());
        if (doencaCadastrada) { throw new ValidacaoException("Doença já cadastrada"); }

        var doenca = new Doenca(dto);
        repository.save(doenca);
        return doenca;
    }

    public Page<Doenca> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public DetalhesDoencaDTO detalhar(String idOuNome) {
        return new DetalhesDoencaDTO(HelperMethod.carregarDoenca(idOuNome));
    }

    public String listarJOption() {
        return repository.findAll()
                .stream()
                .map(DoencaFormatter::formatarLista)
                .collect(Collectors.joining("\n\n"));
    }
}
