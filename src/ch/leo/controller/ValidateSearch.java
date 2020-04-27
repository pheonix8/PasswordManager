package ch.leo.controller;

import ch.leo.model.*;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (applicationModel.getElementAt(i).getApplication().equalsIgnoreCase(searchField.getText())) {
                validated = true;
                break;
            } else {
                validated = false;
            }
        }
        return validated;
    }

    public int getValidatedIndex(String title, DefaultListModel<Application> applicationModel) {
        int index = 50;
        for (int i = 0; i < applicationModel.getSize(); i++) {
            if (applicationModel.getElementAt(i).getApplication().equalsIgnoreCase(title)) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * Login
     */
    public boolean validateEmail(JTextField emailField) {
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(emailField.getText());
        System.out.println(m.matches());
        boolean b = m.matches();

        return b;
    }

    public boolean validateUser(JTextField userField, AllUsers allUsers) {
        boolean validated = false;
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (allUsers.getElementAt(i).getUsername().equalsIgnoreCase(userField.getText())) {
                validated = true;
                break;
            } else {
                validated = false;
            }

        }
        return validated;
    }

    public boolean validatePassword(JTextField passwordField, AllUsers allUsers) {
        boolean validated = false;
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (allUsers.getCode().equalsIgnoreCase(passwordField.getText())) {
                validated = true;
                break;
            } else {
                validated = false;
            }
        }
        return validated;
    }

    public int getLoginIndex(JTextField userField, AllUsers allUsers) {
        int index = 50;
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (allUsers.getElementAt(i).getUsername().equalsIgnoreCase(userField.getText())) {
                index = i;
                break;
            }
        }
        return index;
    }


}
