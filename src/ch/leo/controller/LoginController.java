package ch.leo.controller;

import ch.leo.main.DataInitialization;
import ch.leo.main.LoginInitialization;
import ch.leo.model.AllCompilations;
import ch.leo.model.AllUsers;
import ch.leo.model.Types;
import ch.leo.model.User;
import ch.leo.view.CreateAccountDialog;

import javax.swing.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class LoginController {


    /**
     * on User Entered
     *
     * @param userField the user field
     * @param allUsers  the all users
     * @param requestpw the requestpw
     */
    public static void onUserEntered(JTextField userField, AllUsers allUsers, JButton requestpw) {
        Validate validate = new Validate();

        requestpw.setEnabled(validate.validateUser(userField, allUsers));
    }

    /**
     * On click request pw.
     *
     * @param allUsers      the all users
     * @param passwordField the password field
     */
    public static void onClickRequestPW(AllUsers allUsers, JTextField passwordField) {
        new Validate();

        //Versuch Email zu senden Fehlgeschlagen
        //allUsers.sendEmail(validateSearch.getLoginIndex(userField,allUsers));

        System.out.println(allUsers.getCode());
        passwordField.setEditable(true);



    }

    /**
     * On password entered.
     *
     * @param passwodField the passwod field
     * @param allUsers     the all users
     * @param login        the login
     */
    public static void onPasswordEntered(JTextField passwodField, AllUsers allUsers, JButton login) {
        Validate validate = new Validate();

        login.setEnabled(validate.validatePassword(passwodField, allUsers));

    }

    /**
     * On click start.
     *
     * @param allCompilations the all compilations
     * @param userField       the user field
     */
    public static void onClickStart(AllCompilations allCompilations, JTextField userField) {
        String name = userField.getText();
        Types types = new Types();

        new DataInitialization(allCompilations, types, name);

    }

    /**
     * On click create account window.
     *
     * @param allUsers        the all users
     * @param allCompilations the all compilations
     */
    public static void onClickCreateAccountWindow(AllUsers allUsers, AllCompilations allCompilations) {
        new CreateAccountDialog(allUsers, allCompilations);
    }


    /**
     * on Data Entered
     *
     * @param emailField   the email field
     * @param createButton the create button
     */
    public static void onDataEntered(JTextField emailField, JButton createButton) {
        Validate validate = new Validate();

        if (validate.validateEmail(emailField)) {
            createButton.setEnabled(true);
        } else {
            createButton.setEnabled(false);
        }
    }

    /**
     * On user add.
     *
     * @param userField       the user field
     * @param emailField      the email field
     * @param createButton    the create button
     * @param allUsers        the all users
     * @param allCompilations the all compilations
     */
    public static void onUserAdd(JTextField userField, JTextField emailField, JButton createButton, AllUsers allUsers, AllCompilations allCompilations) {
        User newUser = new User(
                userField.getText(),
                emailField.getText()
        );

        allUsers.addUser(newUser);
        allUsers.createfile();

        new LoginInitialization(allUsers, allCompilations);

        userField.setText("");
        emailField.setText("");
        createButton.setEnabled(false);

    }
}
