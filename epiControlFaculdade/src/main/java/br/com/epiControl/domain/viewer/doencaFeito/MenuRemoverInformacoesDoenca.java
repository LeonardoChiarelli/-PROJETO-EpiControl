package br.com.epiControl.domain.viewer.doencaFeito;

import br.com.epiControl.domain.dto.AtualizarDadosDoencaDTO;
import br.com.epiControl.domain.dto.DetalhesDoencaDTO;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.model.AgenteCausador;
import br.com.epiControl.domain.repository.IDoencaRepository;
import br.com.epiControl.domain.service.DoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

public class MenuRemoverInformacoesDoenca extends JFrame {

    private final DoencaService service;

    public MenuRemoverInformacoesDoenca(DoencaService service){
        this.service = service;

        setTitle("Menu Remover Informações");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeField = new JTextField(20);
        JComboBox<String> agenteCausadorBox = new JComboBox<>(new String[]{
                "VÍRUS", "BACTÉRIAS", "PROTOZOÁRIOS", "FUNGOS", "VERMES PARASITAS"
        });
        JTextField sintomasField = new JTextField(20);
        JTextField formasDeTransmissaoField = new JTextField(20);
        JTextField medidasDePrevencaoField = new JTextField(20);
        JSpinner taxaDeTransmissaoSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));

        JButton registrarInformacoes = new JButton("Registrar Informações");
        JButton limparButton = new JButton("Limpar");

        mainPanel.add(createLabeledField("Id ou Nome:", idOuNomeField));
        mainPanel.add(createLabeledField("Agente Causador:", agenteCausadorBox));
        mainPanel.add(createLabeledField("Sintomas:", sintomasField));
        mainPanel.add(createLabeledField("Formas De Transmissão:", formasDeTransmissaoField));
        mainPanel.add(createLabeledField("Medidas De Prevenção:", medidasDePrevencaoField));
        mainPanel.add(createLabeledField("Taxa de Transmissão (%):", taxaDeTransmissaoSpinner));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registrarInformacoes);
        buttonPanel.add(limparButton);
        buttonPanel.setBackground(new Color(255, 235, 215));
        mainPanel.add(buttonPanel);

        limparButton.addActionListener(e -> {
            idOuNomeField.setText("");
            agenteCausadorBox.setSelectedIndex(0);
            sintomasField.setText("");
            formasDeTransmissaoField.setText("");
            medidasDePrevencaoField.setText("");
            taxaDeTransmissaoSpinner.setValue(0.0);
        });

        registrarInformacoes.addActionListener(e -> {

            AgenteCausador agenteCausador = getAgenteCausador(agenteCausadorBox.getSelectedItem());
            String sintomas = sintomasField.getText();
            String transmissao = formasDeTransmissaoField.getText();
            String prevencao = medidasDePrevencaoField.getText();
            double taxa = (Double) taxaDeTransmissaoSpinner.getValue();

            var informacoes = new AtualizarDadosDoencaDTO(agenteCausador, sintomas, transmissao, prevencao, taxa);

            var doenca = service.removerInfo(idOuNomeField.getText(), informacoes);

            JOptionPane.showMessageDialog(this, doenca);
        });

        add(mainPanel);
        setVisible(true);
    }

    private AgenteCausador getAgenteCausador(Object selectedItem) {
        String agenteCausador = (String) selectedItem;

        return switch (agenteCausador) {
            case "VÍRUS" -> AgenteCausador.VIRUS;
            case "BACTÉRIAS" -> AgenteCausador.BACTERIAS;
            case "PROTOZOÁRIOS" -> AgenteCausador.PROTOZOARIOS;
            case "FUNGOS" -> AgenteCausador.FUNGOS;
            case "VERMES PARASITAS" -> AgenteCausador.VERMES_PARASITAS;
            default -> null;
        };

    }

    private JPanel createLabeledField(String labelText, JComponent inputComponent) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(255, 235, 215));

        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 25));

        inputComponent.setPreferredSize(new Dimension(200, 25));

        panel.add(label);
        panel.add(inputComponent);
        return panel;
    }
}

