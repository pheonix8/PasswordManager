package ch.leo.view;

import ch.leo.controller.ValidateSearch;
import ch.leo.model.Application;

import javax.swing.*;
import java.awt.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.04.2020
 */
public class ShowPassword extends JDialog {

    private String title;

    private JLabel usernameLabel;
    private JTextField usernameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JTextField passwordField;

    public ShowPassword(String title, DefaultListModel<Application> applicationModel) {
        this.title = title;
        setTitle(title);

        setSize(250, 125);
        setLayout(new BorderLayout(10, 10));

        ValidateSearch validateSearch = new ValidateSearch();

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getUsername());

        emailLabel = new JLabel("E-Mail:");
        emailField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getEmail());

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getPassword());

        usernameField.setEditable(false);
        emailField.setEditable(false);
        passwordField.setEditable(false);

        init();

        setVisible(true);

    }


    protected void init() {
        JPanel dataPanel = new JPanel(new GridLayout(4, 2));

        dataPanel.add(usernameLabel);
        dataPanel.add(usernameField);
        dataPanel.add(emailLabel);
        dataPanel.add(emailField);
        dataPanel.add(passwordLabel);
        dataPanel.add(passwordField);

        add(dataPanel);
    }
}
