package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.model.Cidade;
import br.com.epiControl.domain.model.Doenca;
import br.com.epiControl.domain.repository.ICidadeRepository;
import br.com.epiControl.domain.repository.IDoencaRepository;
import br.com.epiControl.general.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;

public class HelperMethod {

    @Autowired
    private static IDoencaRepository doencaRepository;

    @Autowired
    private static ICidadeRepository cidaderepository;

    public static Doenca carregarDoenca(String idOuNome) {
        try {
            var id = Long.parseLong(idOuNome);
            return doencaRepository.findById(id).orElseThrow(() -> new ValidacaoException("ID não encontrado ou não faz referência à nenhuma doença"));
        } catch (NumberFormatException e) {
            return doencaRepository.findByNome(idOuNome).orElseThrow(() -> new ValidacaoException("Doença não encontrada"));
        }
    }

    public static Cidade carregarCidade(String idOuNome){
        try {
            var id = Long.parseLong(idOuNome);
            return cidaderepository.findById(id).orElseThrow(() -> new ValidacaoException("ID não encontrado ou não faz referência à nenhuma cidade"));
        } catch (NumberFormatException e) {
            return cidaderepository.findByNome(idOuNome).orElseThrow(() -> new ValidacaoException("Cidade não encontrada"));
        }
    }
}
