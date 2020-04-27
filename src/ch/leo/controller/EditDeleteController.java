package ch.leo.controller;

import ch.leo.view.*;
import ch.leo.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class EditDeleteController {

    /**
     * On type selection.
     *
     * @param programmType     the programm type
     * @param applicationModel the application model
     */
    public static void onTypeSelection(JComboBox<String> programmType, DefaultListModel<Application> applicationModel) {
        ((Compilation) applicationModel).setSelectedType(programmType.getSelectedItem().toString());
    }

    /**
     * On click delete window.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     */
    public static void onClickDeleteWindow(JTextField searchField, DefaultListModel<Application> applicationModel) {
        String getValue;
        DeleteDialog deleteDialog = new DeleteDialog(getValue = searchField.getText(), applicationModel);
    }

    /**
     * On click edit window.
     *
     * @param searchField      the search field
     * @param typeModel        the type model
     * @param applicationModel the application model
     */
    public static void onClickEditWindow(JTextField searchField, DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        String getValue;
        EditDialog editDialog = new EditDialog(typeModel, getValue = searchField.getText(), applicationModel);
    }

    /**
     * On data entered.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     * @param deleteButton     the delete button
     * @param editButton       the edit button
     */
    public static void onDataEntered(JTextField searchField, DefaultListModel<Application> applicationModel, JButton deleteButton, JButton editButton) {
        ValidateSearch validateSearch = new ValidateSearch();

        if (validateSearch.validateSearch(searchField, applicationModel) == true) {
            deleteButton.setEnabled(true);
            editButton.setEnabled(true);
        } else {
            deleteButton.setEnabled(false);
            editButton.setEnabled(false);
        }
    }


    /**
     * Edit Delete Dialog
     */


    /**
     * On application edited.
     *
     * @param passField        the pass field
     * @param userField        the user field
     * @param appField         the app field
     * @param emField          the em field
     * @param programmType     the programm type
     * @param applicationModel the application model
     * @param title            the title
     */
    public static void onApplicationEdited(JTextField passField, JTextField userField, JTextField appField, JTextField emField, JComboBox<String> programmType, DefaultListModel<Application> applicationModel, String title) {
        ValidateSearch validateSearch = new ValidateSearch();

        applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).setPassword(passField.getText());
        applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).setUsername(userField.getText());
        applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).setApplication(appField.getText());
        applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).setEmail(emField.getText());
        applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)).setType(programmType.getSelectedItem().toString());
    }

    /**
     * On application deleted.
     *
     * @param applicationModel the application model
     * @param title            the title
     */
    public static void onApplicationDeleted(DefaultListModel<Application> applicationModel, String title) {
        ValidateSearch validateSearch = new ValidateSearch();

        applicationModel.removeElement(applicationModel.getElementAt(validateSearch.getValidatedIndex(title, applicationModel)));
        ((Compilation) applicationModel).savefile();
    }


}
