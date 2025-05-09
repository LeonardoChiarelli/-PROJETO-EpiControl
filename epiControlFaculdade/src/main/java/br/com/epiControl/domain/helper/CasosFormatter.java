package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.model.CasosEpidemiologicos;

public class CasosFormatter {

    private static String status;

    public static String formatarLista(CasosEpidemiologicos casos){


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
                casos.getCidade(),
                casos.getDoenca(),
                status);
    }
}
