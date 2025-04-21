package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.domain.dto.AtualizarDadosCidadeDTO;
import br.com.epiControl.domain.dto.DetalhesCidadeDTO;
import br.com.epiControl.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MenuAtualizarInformacoesCidade extends JFrame {

    @Autowired
    private CidadeService service;

    public MenuAtualizarInformacoesCidade(){
        setTitle("Menu Atualizar Informações Cidade");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeCidadeField = createFieldWithLabel(mainPanel, "Id ou Nome Cidade:");
        JTextField populacaoField = createFieldWithLabel(mainPanel, "População");
        JTextField hospitaisField = createFieldWithLabel(mainPanel, "Quantidade de Hospitais:");
        JTextField postosField = createFieldWithLabel(mainPanel, "Quantidade de Postos de Saúde");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 235, 215));
        buttonPanel.setLayout(new FlowLayout());

        JButton atualizarButton = new JButton("Atualizar Informações");
        JButton limparButton = new JButton("Limpar");
        JButton voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> {
            String idOuNomeCidade = idOuNomeCidadeField.getText();
            Double populacao = Double.parseDouble(populacaoField.getText());
            Integer quantidadeHospitais = Integer.parseInt(hospitaisField.getText());
            Integer quantidadePostos = Integer.parseInt(postosField.getText());

            var informacoes = new AtualizarDadosCidadeDTO(idOuNomeCidade, populacao, quantidadeHospitais, quantidadePostos);

            var cidade = service.atualizarInfo(informacoes);

            JOptionPane.showMessageDialog(this, new DetalhesCidadeDTO(cidade));
        });

        limparButton.addActionListener(e -> {
            idOuNomeCidadeField.setText("");
            populacaoField.setText("");
            hospitaisField.setText("");
            postosField.setText("");
        });

        voltarButton.addActionListener(e -> SwingUtilities.invokeLater(MenuPrincipalCidade::new));

        buttonPanel.add(atualizarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(voltarButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);

    }

    private JTextField createFieldWithLabel(JPanel panel, String labelText) {
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.setBackground(new Color(255, 235, 215));

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
        SwingUtilities.invokeLater(MenuAtualizarInformacoesCidade::new);
    }
}
