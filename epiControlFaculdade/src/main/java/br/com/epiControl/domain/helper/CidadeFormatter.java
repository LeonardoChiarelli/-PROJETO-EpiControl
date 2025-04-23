package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.model.Cidade;

public class CidadeFormatter {

    public static String formatarDetalhes(Cidade cidade) {
        return String.format("""
                        📍 Cidade: %s
                        🏙️ Estado: %s
                        👥 População: %.2f milhões habitantes
                        🏥 Hospitais: %d
                        🩺 Postos de Saúde: %d
                        """,
                cidade.getNome(),
                cidade.getEstado(),
                cidade.getPopulacao(),
                cidade.getQuantidadeHospitais(),
                cidade.getQuantidadePostosDeSaude()
        );
    }

    public static String formatarLista(Cidade cidade){
        return String.format("""
                        📍 Cidade: %s
                        🏙️ Estado: %s
                        🆔 ID: %d
                        """,
                cidade.getNome(),
                cidade.getEstado(),
                cidade.getId()
        );
    }
}
