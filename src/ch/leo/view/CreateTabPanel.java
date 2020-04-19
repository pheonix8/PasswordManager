package ch.leo.view;

import ch.leo.model.*;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.swing.*;
import java.awt.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 17.04.2020
 */
public class CreateTabPanel extends JPanel {

    private DefaultComboBoxModel<Type> typeModel;
    private JComboBox<Type> programmType;

    private JLabel applicationLabel;
    private JTextField applicationField;

    private JLabel usernameLabel;
    private JTextField usernameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JTextField passwordField;

    private JButton createButton;

    public CreateTabPanel(DefaultComboBoxModel<Type> typeModel) {
        this.setLayout(new BorderLayout(10,10));

        this.typeModel = typeModel;

        programmType = new JComboBox<Type>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));

        applicationLabel = new JLabel("Application:");
        applicationField = new JTextField();

        usernameLabel = new JLabel("Benutzername:");
        usernameField = new JTextField();

        emailLabel = new JLabel("E-Mail:");
        emailField = new JTextField();

        passwordLabel = new JLabel("Passwort:");
        passwordField = new JTextField();

        createButton = new JButton("Erstellen");

        add(createUpperPanel(), BorderLayout.CENTER);
        add(createLowerPanel(), BorderLayout.SOUTH);

        setVisible(true);

    }

    private  JPanel createUpperPanel(){
        JPanel upperPanel = new JPanel(new BorderLayout(5,5));
        JPanel dataPanel = new JPanel(new GridLayout(1,2));
        JPanel createDataPanel = new JPanel(new GridLayout(4,2));
        JPanel comboboxPanel = new JPanel(new BorderLayout(5,5));

        createDataPanel.add(applicationLabel);
        createDataPanel.add(applicationField);
        createDataPanel.add(usernameLabel);
        createDataPanel.add(usernameField);
        createDataPanel.add(emailLabel);
        createDataPanel.add(emailField);
        createDataPanel.add(passwordLabel);
        createDataPanel.add(passwordField);

        comboboxPanel.add(programmType, BorderLayout.CENTER);

        dataPanel.add(createDataPanel);
        dataPanel.add(comboboxPanel);

        upperPanel.add(dataPanel, BorderLayout.CENTER);
        upperPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);

        return upperPanel;
    }

    private JPanel createLowerPanel(){
        JPanel lowerPanel = new JPanel(new BorderLayout(5,5));

        lowerPanel.add(createButton, BorderLayout.CENTER);

        return lowerPanel;
    }

}
