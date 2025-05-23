package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.model.Doenca;
import br.com.epiControl.domain.repository.ICasosRepository;
import br.com.epiControl.domain.repository.ICidadeRepository;
import br.com.epiControl.domain.repository.IDoencaRepository;
import br.com.epiControl.general.exception.ValidacaoException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelperMethod {

    @Autowired
    private IDoencaRepository doencaRepo;

    @Autowired
    private ICidadeRepository cidadeRepo;

    @Autowired
    private ICasosRepository casosRepo;

    private static ICidadeRepository cidadeRepository;
    private static IDoencaRepository doencaRepository;
    private static ICasosRepository casosRepository;

    public static Doenca carregarDoenca(String idOuNome) {
        try {
            Long id = Long.parseLong(idOuNome);
            return doencaRepository.findById(id).orElseThrow(() -> new ValidacaoException("ID não encontrado ou não faz referência à nenhuma doença"));
        } catch (NumberFormatException e) {
            return doencaRepository.findByNome(idOuNome).orElseThrow(() -> new ValidacaoException("Doença não encontrada"));
        }
    }

    public static Cidade carregarCidade(String idOuNome){
        try {
            Long id = Long.parseLong(idOuNome);
            return cidadeRepository.findById(id).orElseThrow(() -> new ValidacaoException("ID não encontrado ou não faz referência à nenhuma cidade"));
        } catch (NumberFormatException | NullPointerException e) {
            return cidadeRepository.findByNome(idOuNome).orElseThrow(() -> new ValidacaoException("Cidade não encontrada"));
        }
    }

    public static CasosEpidemiologicos carregarCaso(Long idCaso){
        return casosRepository.findById(idCaso).orElseThrow(() -> new ValidacaoException("ID não encontrado ou não faz referência à nenhum caso"));
    }

    @PostConstruct
    public void init(){
        HelperMethod.cidadeRepository = cidadeRepo;
        HelperMethod.doencaRepository = doencaRepo;
        HelperMethod.casosRepository = casosRepo;
    }
}
