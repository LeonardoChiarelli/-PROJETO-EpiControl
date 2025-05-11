package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.dto.DetalhesCasosDTO;
import br.com.epiControl.domain.model.CasosEpidemiologicos;

public class CasosFormatter {

    private static String status;

    public static String formatar(CasosEpidemiologicos casos){

        if (casos.getStatus()) {
            status = "Ativo";
        } else {
            status = "Inativa";
        }

        return String.format("""
                Id do caso: %d
                Cidade: %s
                Doença: %s
                Status: %s
                """,
                casos.getId(),
                casos.getCidade().getNome(),
                casos.getDoenca().getNome(),
                status);
    }

    public static String formatarDetalhes(DetalhesCasosDTO dto){

        if (dto.status()) {
            status = "Ativo";
        } else {
            status = "Inativa";
        }

        return String.format("""
                Cidade: %s
                Doença: %s
                Data de Registro: %s
                Ultima Atualização: %s
                Número de casos: %.2f mil casos
                Número de Óbitos: %d óbitos
                Número de Recuperados: %.2f mil recuperados
                Status: %s
                """,
                dto.cidade().getNome(),
                dto.doenca().getNome(),
                dto.dataDeRegistro(),
                dto.ultimaAtualizacao(),
                dto.numeroDeCasos(),
                dto.numeroDeObitos(),
                dto.numeroDeRecuperados(),
                status);
    }
}
