package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.domain.dto.CadastrarCidadeDTO;
import br.com.epiControl.domain.dto.DetalhesCidadeDTO;
import br.com.epiControl.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MenuCadastrarCidade extends JFrame {

    @Autowired
    private CidadeService service;

    public MenuCadastrarCidade() {
        setTitle("Menu de Cadastro de Cidades");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal com layout em coluna
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215)); // antiquewhite
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento interno

        // Campos e labels
        JTextField nomeField = createFieldWithLabel(mainPanel, "Nome:");
        JTextField estadoField = createFieldWithLabel(mainPanel, "Sigla do Estado:");
        JTextField populacaoField = createFieldWithLabel(mainPanel, "População Total:");
        JTextField hospitaisField = createFieldWithLabel(mainPanel, "Quantidade de Hospitais:");
        JTextField postosField = createFieldWithLabel(mainPanel, "Quantidade de Postos de Saúde:");

        // Botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(250, 235, 215));
        buttonPanel.setLayout(new FlowLayout());

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar");
        JButton voltarButton = new JButton("Voltar");

        cadastrarButton.addActionListener(e -> {
            String nomeCidade = nomeField.getText();
            String estadoCidade = estadoField.getText();
            Double populacaoCidade = Double.parseDouble(populacaoField.getText());
            Integer hospitaisCidade = Integer.parseInt(hospitaisField.getText());
            Integer postosCidade = Integer.parseInt(postosField.getText());

            var informacoes = new CadastrarCidadeDTO(null, nomeCidade, estadoCidade, populacaoCidade, hospitaisCidade, postosCidade);

            var cidade = service.cadastrar(informacoes);

            JOptionPane.showMessageDialog(this, new DetalhesCidadeDTO(cidade));
        });

        // Ação do botão Limpar
        limparButton.addActionListener(e -> {
            nomeField.setText("");
            estadoField.setText("");
            populacaoField.setText("");
            hospitaisField.setText("");
            postosField.setText("");
        });

        voltarButton.addActionListener(e -> SwingUtilities.invokeLater(MenuPrincipalCidade::new));

        buttonPanel.add(cadastrarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(voltarButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JTextField createFieldWithLabel(JPanel panel, String labelText) {
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.setBackground(new Color(250, 235, 215));

        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 30));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));

        fieldPanel.add(label);
        fieldPanel.add(textField);

        panel.add(fieldPanel);

        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuCadastrarCidade::new);
    }
}

