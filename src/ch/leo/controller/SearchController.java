package ch.leo.controller;

import ch.leo.model.Application;
import ch.leo.model.Compilation;
import ch.leo.view.ShowPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class SearchController {

    public static void onTypeSelection(JComboBox<String> programmType, DefaultListModel<Application> applicationModel){
        ((Compilation)applicationModel).setSelectedType(programmType.getSelectedItem().toString());
    }

    public static void onClickShowOpen(JTextField searchField, DefaultListModel<Application> applicationModel) {
        String getValue;
        ShowPassword showPassword = new ShowPassword( getValue = searchField.getText(), applicationModel);
    }

    public static void onDataEntered(JTextField searchField, DefaultListModel<Application> applicationModel, JButton searchButton){
        ValidateSearch validateSearch = new ValidateSearch();
        if (validateSearch.validateSearch(searchField, applicationModel) == true){
                searchButton.setEnabled(true);
        }
        else {
            searchButton.setEnabled(false);
        }
    }

}
