package ch.leo.controller;

import ch.leo.model.Application;
import ch.leo.model.Compilation;
import ch.leo.main.*;

import javax.swing.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class CreateController {


    public static void onDataEntered(JComboBox<String> programmType) {
        programmType.setEnabled(true);
    }


    public static void onTypeSelection(JButton createButton) {
        createButton.setEnabled(true);
    }

    public static void onApplicationAdded(JTextField passField, JTextField userField, JTextField appField, JTextField emField, JComboBox<String> programmType, JButton createButton, DefaultListModel<Application> applicationModel) {
        Application newApplication = new Application(
                appField.getText(),
                userField.getText(),
                passField.getText(),
                emField.getText(),
                programmType.getSelectedItem().toString());

        applicationModel.addElement(newApplication);
        ((Compilation) applicationModel).createfile();

        passField.setText("");
        userField.setText("");
        appField.setText("");
        emField.setText("");
        programmType.setEnabled(false);
        createButton.setEnabled(false);

    }


}
