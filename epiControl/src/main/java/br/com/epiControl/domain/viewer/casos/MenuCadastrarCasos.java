package br.com.epiControl.domain.viewer.casos;

import br.com.epiControl.domain.dto.AnexarCasosDTO;
import br.com.epiControl.domain.dto.DetalhesCasosDTO;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MenuCadastrarCasos extends JFrame {

    private final CasosService service;

    public MenuCadastrarCasos(ServiceRegistry registry){
        this.service = registry.getCasosService();

        setTitle("Menu de Cadastro de Casos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));

        JTextField idOuNomeCidadeField = new JTextField(20);
        JTextField idOuNomeDoencaField = new JTextField(20);
        JTextField dataDeRegistroField = new JTextField(20);
        JTextField numeroDeCasosField = new JTextField(20);
        JTextField numeroDeObitosField = new JTextField(20);
        JTextField numeroDeRecuperadosField = new JTextField(20);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar");
        JButton voltarButton = new JButton("Voltar");

        mainPanel.add(createLabeledField("Id ou Nome da Cidade: ", idOuNomeCidadeField));
        mainPanel.add(createLabeledField("Id ou Nome da Doença", idOuNomeDoencaField));
        mainPanel.add(createLabeledField("Data de registro (yyyy-MM-dd)", dataDeRegistroField));
        mainPanel.add(createLabeledField("Número de casos (mil)", numeroDeCasosField));
        mainPanel.add(createLabeledField("Número de óbitos", numeroDeObitosField));
        mainPanel.add(createLabeledField("Número de recuperados (mil)", numeroDeRecuperadosField));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cadastrarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(voltarButton);
        buttonPanel.setBackground(new Color(255, 235, 215));
        mainPanel.add(buttonPanel);

        cadastrarButton.addActionListener(e -> {
            String idOuNomeCidade = idOuNomeCidadeField.getText();
            String idOuNomeDoenca = idOuNomeDoencaField.getText();
            LocalDate dataDeRegistro = LocalDate.parse(dataDeRegistroField.getText());
            Double numeroDeCasos = Double.parseDouble(numeroDeCasosField.getText());
            Integer numeroDeObitos = Integer.parseInt(numeroDeObitosField.getText());
            Double numeroDeRecuperados = Double.parseDouble(numeroDeRecuperadosField.getText());

            var informacoes = new AnexarCasosDTO(null, idOuNomeCidade, idOuNomeDoenca, dataDeRegistro, numeroDeCasos, numeroDeObitos, numeroDeRecuperados);

            var caso = service.anexar(informacoes);

            JOptionPane.showMessageDialog(this, new DetalhesCasosDTO(caso));
        });

        limparButton.addActionListener(e -> {
            idOuNomeCidadeField.setText("");
            idOuNomeDoencaField.setText("");
            dataDeRegistroField.setText("");
            numeroDeCasosField.setText("");
            numeroDeObitosField.setText("");
            numeroDeRecuperadosField.setText("");
        });

        voltarButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuAnexarCasos(registry));
            dispose();
        });

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createLabeledField(String labelText, JComponent inputComponent) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(255, 235, 215));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 25));
        inputComponent.setPreferredSize(new Dimension(200,25));
        panel.add(label);
        panel.add(inputComponent);
        return panel;
    }
}
