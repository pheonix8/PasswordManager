package ch.leo.view;

import ch.leo.model.*;

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

    private JPanel createPanel;

    private JPanel createLeftPanel;
    private JPanel createLeftnorthPanel;

    private JPanel createRightPanel;

    private JLabel applicationArea;
    private JTextField applicationField;

    private JLabel usernameArea;
    private JTextField usernameField;

    private JLabel emailArea;
    private JTextField emailField;

    private JLabel passwordArea;
    private JTextField passwordField;

    private JComboBox<Type> getProgrammType;

    private JButton createButton;

    public CreateTabPanel() {

        createPanel = new JPanel();

        createLeftPanel = new JPanel();
        createLeftnorthPanel = new JPanel();

        createRightPanel = new JPanel();

        applicationArea = new JLabel("Application:");
        applicationField = new JTextField();

        usernameArea = new JLabel("Benutzername:");
        usernameField = new JTextField();

        emailArea = new JLabel("E-Mail:");
        emailField = new JTextField();

        passwordArea = new JLabel("Passwort:");
        passwordField = new JTextField();

        getProgrammType = new JComboBox<>();

        createButton = new JButton("Erstellen");

        init();

        setVisible(true);

    }

    private void init(){

        add(createPanel);

        createPanel.add(createLeftPanel, BorderLayout.WEST);

        createLeftPanel.add(createLeftnorthPanel, BorderLayout.NORTH);

        createLeftnorthPanel.setLayout(new GridLayout(4,2));

        createLeftnorthPanel.add(applicationArea);
        createLeftnorthPanel.add(applicationField);

        createLeftnorthPanel.add(usernameArea);
        createLeftnorthPanel.add(usernameField);

        createLeftnorthPanel.add(emailArea);
        createLeftnorthPanel.add(emailField);

        createLeftnorthPanel.add(passwordArea);
        createLeftnorthPanel.add(passwordField);

        createLeftPanel.add(getProgrammType, BorderLayout.CENTER);

        createPanel.add(createRightPanel, BorderLayout.EAST);

        createRightPanel.add(createButton,BorderLayout.SOUTH);

    }
}
