package br.com.epiControl.domain.viewer.doenca;

import javax.swing.*;
import java.awt.*;

public class MenuCadastrarDoenca extends JFrame{
    public MenuCadastrarDoenca(){
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
        JSpinner taxaTransmissaoSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar");

        // Adicionando os campos ao painel
        mainPanel.add(createLabeledField("Nome:", nomeField));
        mainPanel.add(createLabeledField("Agente Causador:", agenteCausadorBox));
        mainPanel.add(createLabeledField("Sintomas:", sintomasField));
        mainPanel.add(createLabeledField("Formas de Transmissão:", transmissaoField));
        mainPanel.add(createLabeledField("Medidas de Prevenção:", prevencaoField));
        mainPanel.add(createLabeledField("Taxa de Transmissão (%):", taxaTransmissaoSpinner));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(limparButton);
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
            String agente = (String) agenteCausadorBox.getSelectedItem();
            String sintomas = sintomasField.getText();
            String transmissao = transmissaoField.getText();
            String prevencao = prevencaoField.getText();
            double taxa = (Double) taxaTransmissaoSpinner.getValue();

            JOptionPane.showMessageDialog(this, "Doença cadastrada com sucesso:\n" +
                    "Nome: " + nome + "\nAgente: " + agente + "\nSintomas: " + sintomas +
                    "\nTransmissão: " + transmissao + "\nPrevenção: " + prevencao +
                    "\nTaxa: " + taxa + "%");
        });

        add(mainPanel);
        setVisible(true);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuCadastrarDoenca::new);
    }
}

