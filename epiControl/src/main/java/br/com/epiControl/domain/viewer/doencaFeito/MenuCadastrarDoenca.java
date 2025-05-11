package br.com.epiControl.domain.viewer.doencaFeito;

import br.com.epiControl.domain.dto.CadastrarDoencaDTO;
import br.com.epiControl.domain.dto.DetalhesDoencaDTO;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MenuCadastrarDoenca extends JFrame{

    private final DoencaService service;

    public MenuCadastrarDoenca(ServiceRegistry registry){
        this.service = registry.getDoencaService();

        setTitle("Menu de Cadastro de Doenças");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Centraliza na tela

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215)); // antiquewhite
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento interno

        // Criação dos componentes
        JTextField nomeField = new JTextField(20);
        JComboBox<String> agenteCausadorBox = new JComboBox<>(new String[]{
                "VÍRUS", "BACTÉRIAS", "PROTOZOÁRIOS", "FUNGOS", "VERMES PARASITAS"
        });
        JTextField sintomasField = new JTextField(20);
        JTextField transmissaoField = new JTextField(20);
        JTextField prevencaoField = new JTextField(20);
        JSpinner taxaMortalidadeSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
        JSpinner taxaTransmissaoSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar");
        JButton voltarButton = new JButton("Voltar");

        // Adicionando os campos ao painel
        mainPanel.add(createLabeledField("Nome:", nomeField));
        mainPanel.add(createLabeledField("Agente Causador:", agenteCausadorBox));
        mainPanel.add(createLabeledField("Sintomas:", sintomasField));
        mainPanel.add(createLabeledField("Formas de Transmissão:", transmissaoField));
        mainPanel.add(createLabeledField("Medidas de Prevenção:", prevencaoField));
        mainPanel.add(createLabeledField("Taxa de Mortalidade (%):", taxaMortalidadeSpinner));
        mainPanel.add(createLabeledField("Taxa de Transmissão (%):", taxaTransmissaoSpinner));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(voltarButton);
        buttonPanel.setBackground(new Color(250, 235, 215));
        mainPanel.add(buttonPanel);

        // Ações dos botões (exemplo simples)
        limparButton.addActionListener(e -> {
            nomeField.setText("");
            agenteCausadorBox.setSelectedIndex(0);
            sintomasField.setText("");
            transmissaoField.setText("");
            prevencaoField.setText("");
            taxaTransmissaoSpinner.setValue(0.0);
        });

        cadastrarButton.addActionListener(e -> {

            String nome = nomeField.getText();
            String  agente = getAgenteCausador(Objects.requireNonNull(agenteCausadorBox.getSelectedItem()).toString());
            String sintomas = sintomasField.getText();
            String transmissao = transmissaoField.getText();
            String prevencao = prevencaoField.getText();
            double taxaMortalidade = (Double) taxaMortalidadeSpinner.getValue();
            double taxa = (Double) taxaTransmissaoSpinner.getValue();

            assert agente != null;
            assert nome != null;
            assert sintomas != null;
            assert transmissao != null;
            assert prevencao != null;
            assert taxaMortalidade != 0;
            assert taxa != 0;

            var infomacoes = new CadastrarDoencaDTO(null, nome, agente, sintomas, transmissao, prevencao, taxaMortalidade, taxa);

            var doenca = service.cadastrar(infomacoes);

            JOptionPane.showMessageDialog(this, new DetalhesDoencaDTO(doenca));
        });

        voltarButton.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuPrincipalDoenca(registry));
            dispose();
        });

        add(mainPanel);
        setVisible(true);
    }

    private String getAgenteCausador(String selectedItem) {
        String agenteCausador = selectedItem;

        switch (agenteCausador){
            case "VÍRUS" -> agenteCausador = "VIRUS";
            case "BACTÉRIAS" -> agenteCausador = "BACTERIAS";
            case "PROTOZOÁRIOS" -> agenteCausador = "PROTOZOARIOS";
            case "FUNGOS" -> agenteCausador = "FUNGOS";
            case "VERMES PARASITAS" -> agenteCausador = "VERMES_PARASITAS";
        }

        return agenteCausador;
    }

    private JPanel createLabeledField(String labelText, JComponent inputComponent) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(250, 235, 215));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 25));
        inputComponent.setPreferredSize(new Dimension(200, 25));
        panel.add(label);
        panel.add(inputComponent);
        return panel;
    }
}

