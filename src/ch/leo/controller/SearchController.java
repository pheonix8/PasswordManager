package ch.leo.controller;

import ch.leo.model.Application;
import ch.leo.model.Compilation;
import ch.leo.view.ShowPassword;

import javax.swing.*;
import java.util.Objects;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class SearchController {

    /**
     * On type selection.
     *
     * @param programmType     the programm type
     * @param applicationModel the application model
     */
    public static void onTypeSelection(JComboBox<String> programmType, DefaultListModel<Application> applicationModel) {
        ((Compilation) applicationModel).setSelectedType(Objects.requireNonNull(programmType.getSelectedItem()).toString());
    }

    /**
     * On click show open.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     */
    public static void onClickShowOpen(JTextField searchField, DefaultListModel<Application> applicationModel) {
        new ShowPassword(searchField.getText(), applicationModel);
    }

    /**
     * On data entered.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     * @param searchButton     the search button
     */
    public static void onDataEntered(JTextField searchField, DefaultListModel<Application> applicationModel, JButton searchButton) {
        Validate validate = new Validate();
        if (validate.validateSearch(searchField, applicationModel)) {
            searchButton.setEnabled(true);
        } else {
            searchButton.setEnabled(false);
        }
    }

}
