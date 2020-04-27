package ch.leo.controller;

import ch.leo.model.AllUsers;
import ch.leo.model.Application;
import ch.leo.model.User;
import ch.leo.view.CreateAccountDialog;
import ch.leo.view.PasswordManagerLoginGUI;
import ch.leo.view.PasswortmanagerGUI;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.Vector;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class LoginController {

    /**
     * Login
     */

    public static void onUserEntered(JTextField userField, AllUsers allUsers, JButton requestpw) {
        ValidateSearch validateSearch = new ValidateSearch();

        if (validateSearch.validateUser(userField, allUsers) == true) {
            requestpw.setEnabled(true);
        } else {
            requestpw.setEnabled(false);
        }
    }

    public static void onClickRequestPW(JTextField userField, AllUsers allUsers, JTextField passwordField) {
        ValidateSearch validateSearch = new ValidateSearch();

        //Versuch Email zu senden Fehlgeschlagen
        //allUsers.sendEmail(validateSearch.getLoginIndex(userField,allUsers));
        System.out.println(allUsers.getCode());
        passwordField.setEditable(true);

    }

    public static void onPasswordEntered(JTextField passwodField, AllUsers allUsers, JButton login) {
        ValidateSearch validateSearch = new ValidateSearch();

        if (validateSearch.validatePassword(passwodField, allUsers) == true) {
            login.setEnabled(true);
        } else {
            login.setEnabled(false);
        }

    }


    public static void onClickCreateAccountWindow(AllUsers allUsers) {
        CreateAccountDialog createAccountDialog = new CreateAccountDialog(allUsers);
    }

    public static void onClickStart(DefaultListModel<Application> applicationModel, DefaultComboBoxModel<String> typeModel) {
        PasswortmanagerGUI passwortmanagerGUI = new PasswortmanagerGUI(applicationModel, typeModel);
    }


    /**
     * Create Account
     */

    public static void onDataEntered(JTextField emailField, JButton createButton) {
        ValidateSearch validateSearch = new ValidateSearch();

        if (validateSearch.validateEmail(emailField) == true) {
            createButton.setEnabled(true);
        } else {
            createButton.setEnabled(false);
        }
    }

    public static void onUserAdd(JTextField userField, JTextField emailField, JButton createButton, AllUsers allUsers) {
        User newUser = new User(
                userField.getText(),
                emailField.getText()
        );

        allUsers.addUser(newUser);
        allUsers.createfile();

        userField.setText("");
        emailField.setText("");
        createButton.setEnabled(false);

    }
}
