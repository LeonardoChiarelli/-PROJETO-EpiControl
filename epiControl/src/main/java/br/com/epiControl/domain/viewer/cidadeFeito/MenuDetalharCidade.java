package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.domain.helper.CidadeFormatter;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuDetalharCidade extends JFrame {

    public MenuDetalharCidade(ServiceRegistry registry){
        setTitle("Menu Detalhar Cidade");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeField = createFieldWithLabel(mainPanel, "Id ou Nome da Cidade:");

        JPanel buttonPanel = getJPanel(registry, idOuNomeField);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel getJPanel(ServiceRegistry registry, JTextField idOuNomeField) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 235, 215));
        buttonPanel.setLayout(new FlowLayout());

        JButton detalharButton = new JButton("Detalhar");
        JButton voltarButton = new JButton("Voltar");

        detalharButton.addActionListener(e ->{
            String idOuNomeCidade = idOuNomeField.getText();

            var cidade = HelperMethod.carregarCidade(idOuNomeCidade);

            JOptionPane.showMessageDialog(this, CidadeFormatter.formatarDetalhes(cidade));
        });

        voltarButton.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuPrincipalCidade(registry));
            dispose();
        });

        buttonPanel.add(detalharButton);
        buttonPanel.add(voltarButton);
        return buttonPanel;
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
