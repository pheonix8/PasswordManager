package ch.leo.view;

import ch.leo.controller.CreateController;
import ch.leo.model.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 17.04.2020
 */
public class CreateTabPanel extends JPanel {

    private DefaultComboBoxModel<String> typeModel;
    private JComboBox<String> programmType;

    private DefaultListModel<Application> applicationModel;

    private JLabel applicationLabel;
    private JTextField applicationField;

    private JLabel usernameLabel;
    private JTextField usernameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JTextField passwordField;

    private JButton createButton;

    /**
     * Instantiates a new Create tab panel.
     *
     * @param typeModel        the type model
     * @param applicationModel the application model
     */
    public CreateTabPanel(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        this.setLayout(new BorderLayout(10, 10));

        this.typeModel = typeModel;
        this.applicationModel = applicationModel;

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));
        programmType.addActionListener(e -> CreateController.onTypeSelection(this.createButton));

        applicationLabel = new JLabel("Application:");
        applicationField = new JTextField();

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        emailLabel = new JLabel("E-Mail:");
        emailField = new JTextField();

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                CreateController.onDataEntered(programmType);
            }
        });

        createButton = new JButton("Create");
        createButton.addActionListener(e -> CreateController.onApplicationAdded(
                passwordField,
                usernameField,
                applicationField,
                emailField,
                programmType,
                createButton,
                applicationModel
        ));

        add(createUpperPanel(), BorderLayout.CENTER);
        add(createLowerPanel(), BorderLayout.SOUTH);

        setVisible(true);

        programmType.setEnabled(false);
        createButton.setEnabled(false);

    }

    private JPanel createUpperPanel() {
        Border upperborder = BorderFactory.createEmptyBorder(50, 0, 100, 0);

        JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        JPanel dataPanel = new JPanel(new GridLayout(1, 2));
        JPanel createDataPanel = new JPanel(new GridLayout(4, 2));
        JPanel comboboxPanel = new JPanel(new BorderLayout(5, 5));

        createDataPanel.add(applicationLabel);
        createDataPanel.add(applicationField);
        createDataPanel.add(usernameLabel);
        createDataPanel.add(usernameField);
        createDataPanel.add(emailLabel);
        createDataPanel.add(emailField);
        createDataPanel.add(passwordLabel);
        createDataPanel.add(passwordField);
        createDataPanel.setBorder(upperborder);

        comboboxPanel.add(programmType, BorderLayout.CENTER);
        comboboxPanel.setBorder(upperborder);

        dataPanel.add(createDataPanel);
        dataPanel.add(comboboxPanel);

        upperPanel.add(dataPanel, BorderLayout.CENTER);
        upperPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);

        return upperPanel;
    }

    private JPanel createLowerPanel() {
        Border lowerborder = BorderFactory.createEmptyBorder(13, 150, 23, 150);
        JPanel lowerPanel = new JPanel(new BorderLayout(5, 5));

        lowerPanel.add(createButton, BorderLayout.CENTER);
        lowerPanel.setBorder(lowerborder);

        return lowerPanel;
    }

}
