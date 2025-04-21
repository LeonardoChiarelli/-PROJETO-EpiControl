package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.EpiControlApplication;
import br.com.epiControl.domain.dto.DetalhesCidadeDTO;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class MenuDetalharCidade extends JFrame {

    public MenuDetalharCidade(){
        setTitle("Menu Detalhar Cidade");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idOuNomeField = createFieldWithLabel(mainPanel, "Id ou Nome da Cidade:");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 235, 215));
        buttonPanel.setLayout(new FlowLayout());

        JButton detalharButton = new JButton("Detalhar");
        JButton voltarButton = new JButton("Voltar");

        detalharButton.addActionListener(e ->{
            String idOuNomeCidade = idOuNomeField.getText();

            var cidade = HelperMethod.carregarCidade(idOuNomeCidade);

            JOptionPane.showMessageDialog(this, new DetalhesCidadeDTO(cidade));
        });

        voltarButton.addActionListener(e -> {
            ApplicationContext context = SpringApplication.run(EpiControlApplication.class);

            ServiceRegistry registry = new ServiceRegistry(
                    context.getBean(CidadeService.class),
                    context.getBean(DoencaService.class),
                    context.getBean(CasosService.class)
            );

            SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
        });

        buttonPanel.add(detalharButton);
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
        SwingUtilities.invokeLater(MenuDetalharCidade::new);
    }
}
