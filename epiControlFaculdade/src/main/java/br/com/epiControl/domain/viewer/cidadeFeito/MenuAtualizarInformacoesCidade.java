package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.EpiControlApplication;
import br.com.epiControl.domain.dto.AtualizarDadosCidadeDTO;
import br.com.epiControl.domain.dto.DetalhesCidadeDTO;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.general.config.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

public class MenuAtualizarInformacoesCidade extends JFrame {

    private final CidadeService service;

    public MenuAtualizarInformacoesCidade(CidadeService service){
        this.service = service;
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

        voltarButton.addActionListener(e -> {
            ApplicationContext context = SpringApplication.run(EpiControlApplication.class);

            ServiceRegistry registry = new ServiceRegistry(
                    context.getBean(CidadeService.class),
                    context.getBean(DoencaService.class),
                    context.getBean(CasosService.class)
            );

            SwingUtilities.invokeLater(() -> new MenuPrincipalCidade(registry));
        });

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
}
