package br.com.epiControl.domain.viewer.casos;

import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuDetalharCasos extends JFrame {

    public MenuDetalharCasos(ServiceRegistry registry){
        setTitle("Menu Detalhar Casos");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idCasoField = createFieldWithLabel(mainPanel, "Id do Caso");
        
        JPanel buttonPanel = getPanel(registry, idCasoField);
    }

    private JPanel getPanel(ServiceRegistry registry, JTextField idCasoField) {
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
