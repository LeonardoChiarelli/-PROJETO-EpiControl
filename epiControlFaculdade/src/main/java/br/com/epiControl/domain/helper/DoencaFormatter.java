package br.com.epiControl.domain.helper;

import br.com.epiControl.domain.model.Doenca;

public class DoencaFormatter {

    public static String formatarDetalhes(Doenca doenca) {
        return String.format("""
                    🦠 Doença: %s
                    🧬 Agente(s) Causador(es): %s
                    🤒 Sintomas: %s
                    🔄 Formas de Transmissão: %s
                    🛡️ Medidas de Prevenção: %s
                    💀 Taxa de Mortalidade: %f
                    📈 Taxa de Transmissão: %f
                    🔢 ID: %d
                    """,
                doenca.getNome(),
                String.join(", ", doenca.getAgenteCausador().stream().map(Enum::name).toList()),
                String.join(", ", doenca.getSintomas()),
                String.join(", ", doenca.getFormasDeTransmissao()),
                String.join(", ", doenca.getMedidasDePrevencao()),
                doenca.getTaxaDeMortalidade(),
                doenca.getTaxaDeTransmissao(),
                doenca.getId()
                );
    }

    public static String formatarLista(Doenca doenca) {
        return String.format("""
                    🦠 Doença: %s
                    🧬 Agente(s) Causador(es): %s
                    🔄 Formas de Transmissão: %s
                    🔢 ID: %d
                    """,
                doenca.getNome(),
                String.join(", ", doenca.getAgenteCausador().stream().map(Enum::name).toList()),
                String.join(", ", doenca.getFormasDeTransmissao()),
                doenca.getId()
        );
    }
}
