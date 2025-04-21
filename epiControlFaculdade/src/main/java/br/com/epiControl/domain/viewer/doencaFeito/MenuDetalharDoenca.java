package br.com.epiControl.domain.viewer.doencaFeito;

import br.com.epiControl.EpiControlApplication;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.cidadeFeito.MenuPrincipalCidade;
import br.com.epiControl.general.config.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class MenuDetalharDoenca extends JFrame {

    private final DoencaService service;

    public MenuDetalharDoenca(DoencaService service){
        this.service = service;
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

        detalharButton.addActionListener(e -> JOptionPane.showMessageDialog(this, service.detalhar(idOuNomeField.getText())));

        voltarButton.addActionListener(e -> {
            ApplicationContext context = SpringApplication.run(EpiControlApplication.class);

            ServiceRegistry registry = new ServiceRegistry(
                    context.getBean(CidadeService.class),
                    context.getBean(DoencaService.class),
                    context.getBean(CasosService.class)
            );

            SwingUtilities.invokeLater(() -> new MenuPrincipalDoenca(registry));
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
