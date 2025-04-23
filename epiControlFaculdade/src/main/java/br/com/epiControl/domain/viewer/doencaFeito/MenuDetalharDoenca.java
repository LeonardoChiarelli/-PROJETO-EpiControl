package br.com.epiControl.domain.viewer.doencaFeito;

import br.com.epiControl.domain.helper.DoencaFormatter;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuDetalharDoenca extends JFrame {

    private final DoencaService service;

    public MenuDetalharDoenca(ServiceRegistry registry){
        this.service = registry.getDoencaService();
        setTitle("Menu Detalhar Doença");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeField = new JTextField(20);

        JButton detalharButton = new JButton("Detalhar");
        JButton voltarButton = new JButton("Voltar");

        mainPanel.add(createLabeledField("Id ou Nome:", idOuNomeField));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(detalharButton);
        buttonPanel.add(voltarButton);
        buttonPanel.setBackground(new Color(255, 235, 215));
        mainPanel.add(buttonPanel);

        detalharButton.addActionListener(e -> {
            String idOuNomeDoenca = idOuNomeField.getText();

            var doenca = HelperMethod.carregarDoenca(idOuNomeDoenca);

            JOptionPane.showMessageDialog(this, DoencaFormatter.formatarDetalhes(doenca));
        });

        voltarButton.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuPrincipalDoenca(registry));
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
        inputComponent.setPreferredSize(new Dimension(200, 25));
        panel.add(label);
        panel.add(inputComponent);
        return panel;
    }
}
