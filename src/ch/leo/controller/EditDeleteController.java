package ch.leo.controller;

import ch.leo.model.Application;
import ch.leo.model.Compilation;
import ch.leo.view.DeleteDialog;
import ch.leo.view.EditDialog;

import javax.swing.*;
import java.util.Objects;

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
        ((Compilation) applicationModel).setSelectedType(Objects.requireNonNull(programmType.getSelectedItem()).toString());
    }

    /**
     * On click delete window.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     */
    public static void onClickDeleteWindow(JTextField searchField, DefaultListModel<Application> applicationModel) {
        new DeleteDialog(searchField.getText(), applicationModel);
    }

    /**
     * On click edit window.
     *
     * @param searchField      the search field
     * @param typeModel        the type model
     * @param applicationModel the application model
     */
    public static void onClickEditWindow(JTextField searchField, DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        new EditDialog(typeModel, searchField.getText(), applicationModel);
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
        Validate validate = new Validate();

        if (validate.validateSearch(searchField, applicationModel)) {
            deleteButton.setEnabled(true);
            editButton.setEnabled(true);
        } else {
            deleteButton.setEnabled(false);
            editButton.setEnabled(false);
        }
    }


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
        Validate validate = new Validate();

        applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)).setPassword(passField.getText());
        applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)).setUsername(userField.getText());
        applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)).setApplication(appField.getText());
        applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)).setEmail(emField.getText());
        applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)).setType(Objects.requireNonNull(programmType.getSelectedItem()).toString());
    }

    /**
     * On application deleted.
     *
     * @param applicationModel the application model
     * @param title            the title
     */
    public static void onApplicationDeleted(DefaultListModel<Application> applicationModel, String title) {
        Validate validate = new Validate();

        applicationModel.removeElement(applicationModel.getElementAt(validate.getValidatedIndex(title, applicationModel)));
        ((Compilation) applicationModel).savefile();
    }


}
