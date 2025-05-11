package br.com.epiControl.domain.viewer.casos;

import br.com.epiControl.domain.dto.AtualizarDadosCasosDTO;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuAtualizarDadosCasos extends JFrame {

    private final CasosService service;

    public MenuAtualizarDadosCasos(ServiceRegistry registry){
        this.service = registry.getCasosService();
        setTitle("Menu Atualizar Informações Casos");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeCidadeField = createFieldWithLabel(mainPanel, "Id ou Nome da Cidade: ");
        JTextField idOuNomeDoencaField = createFieldWithLabel(mainPanel, "Id ou Nome da Doença: ");
        JTextField numeroDeCasosField = createFieldWithLabel(mainPanel, "Número de Casos: ");
        JTextField numeroDeObitosField = createFieldWithLabel(mainPanel, "Número de Óbitos: ");
        JTextField numeroDeRecuperadosField = createFieldWithLabel(mainPanel, "Número de Recuperados: ");
        JComboBox<String> StatusBox = new JComboBox<>(new String[]{
                "Ativo", "Inativo"
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 235, 215));
        buttonPanel.setLayout(new FlowLayout());

        JButton atualizarButton = new JButton("Atualizar Informações");
        JButton limparButton = new JButton("Limpar");
        JButton voltarButton = new JButton("Voltar");

        atualizarButton.addActionListener(e -> {
            String idOuNomeCidade = idOuNomeCidadeField.getText();
            String idOuNomeDoenca = idOuNomeDoencaField.getText();
            Double numeroDeCasos = Double.parseDouble(numeroDeCasosField.getText());
            Integer numeroDeObitos = Integer.parseInt(numeroDeObitosField.getText());
            Double numeroDeRecuperados = Double.parseDouble(numeroDeRecuperadosField.getText());

            String escolha = (String) StatusBox.getSelectedItem();
            Boolean status = null;

            switch (escolha){
                case "Ativo":
                    status = true;
                    break;
                case "Inativo":
                    status = false;
                case null:
                    break;
                default:
                    throw new IllegalStateException(STR."Unexpected value: \{escolha}");
            }

            var informacoes = new AtualizarDadosCasosDTO(numeroDeCasos, numeroDeObitos, numeroDeRecuperados, status);

            var casos = service.atualizarDados(idOuNomeCidade, idOuNomeDoenca,informacoes);

            JOptionPane.showMessageDialog(this, casos);
        });

        limparButton.addActionListener(e -> {
            idOuNomeCidadeField.setText("");
            idOuNomeDoencaField.setText("");
            numeroDeCasosField.setText("");
            numeroDeObitosField.setText("");
            numeroDeRecuperadosField.setText("");
        });

        voltarButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuAnexarCasos(registry));
            dispose();
        });

        buttonPanel.add(atualizarButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(voltarButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JTextField createFieldWithLabel(JPanel mainPanel, String labelText) {
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.setBackground(new Color(255, 235, 215));

        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 30));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));

        fieldPanel.add(label);
        fieldPanel.add(textField);

        mainPanel.add(fieldPanel);

        return textField;
    }
}
