package ch.leo.controller;

import ch.leo.model.Application;

import javax.swing.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class ValidateSearch {

    public boolean validateSearch(JTextField searchField, DefaultListModel<Application> applicationModel) {
        boolean validated = false;
        for (int i = 0; i < applicationModel.getSize(); i++) {
            if (applicationModel.getElementAt(i).getApplication().compareToIgnoreCase(searchField.getText()) == 0)
                validated = true;
                break;
        }
        return validated;
    }

    public int getValidatedIndex(String title, DefaultListModel<Application> applicationModel) {
        int index = 0;
        for (int i = 0; i < applicationModel.getSize(); i++) {
            if (applicationModel.getElementAt(i).getApplication().compareToIgnoreCase(title) == 0)
                index = i;
                break;
        }
        return index;
    }



}
