package ch.leo.view;

import ch.leo.controller.EditDeleteController;
import ch.leo.controller.ValidateSearch;
import ch.leo.model.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.04.2020
 */
public class EditDialog extends JDialog {

    private String title;

    private DefaultComboBoxModel<String> typeModel;
    private JComboBox<String> programmType;

    private JLabel applicationLabel;
    private JTextField applicationField;

    private JLabel usernameLabel;
    private JTextField usernameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JTextField passwordField;

    private JButton saveButton;
    private JButton cancelButton;

    public EditDialog(DefaultComboBoxModel<String> typeModel, String title, DefaultListModel<Application> applicationModel) {
        this.title = title;
        setTitle(title);

        setSize(400, 200);
        setLayout(new BorderLayout(10, 10));

        this.typeModel = typeModel;

        ValidateSearch validateSearch = new ValidateSearch();

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));
        programmType.setSelectedItem(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getType());

        applicationLabel = new JLabel("Application:");
        applicationField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getApplication());

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getUsername());

        emailLabel = new JLabel("E-Mail:");
        emailField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getEmail());

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).getPassword());

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditDeleteController.onApplicationEdited(
                        passwordField,
                        usernameField,
                        applicationField,
                        emailField, programmType,
                        applicationModel,
                        title);
                dispose();
            }
        });

        add(editUpperPanel(), BorderLayout.CENTER);
        add(editLowerPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel editUpperPanel() {
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

        comboboxPanel.add(programmType, BorderLayout.CENTER);

        dataPanel.add(createDataPanel);
        dataPanel.add(comboboxPanel);

        upperPanel.add(dataPanel, BorderLayout.CENTER);

        return upperPanel;
    }

    private JPanel editLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout(5, 5));

        lowerPanel.add(cancelButton, BorderLayout.WEST);
        lowerPanel.add(saveButton, BorderLayout.EAST);

        return lowerPanel;
    }
}
