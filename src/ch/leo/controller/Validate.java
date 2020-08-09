package ch.leo.controller;

import ch.leo.model.*;

import javax.swing.*;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 22.04.2020
 */
public class Validate {

    /**
     * Validate search boolean.
     *
     * @param searchField      the search field
     * @param applicationModel the application model
     * @return the boolean
     */
    public boolean validateSearch(JTextField searchField, DefaultListModel<Application> applicationModel) {
        boolean validated = false;
        for (int i = 0; i < applicationModel.getSize(); i++) {
            if (applicationModel.getElementAt(i).getApplication().equalsIgnoreCase(searchField.getText())) {
                validated = true;
                break;
            }
        }
        return validated;
    }

    /**
     * Gets validated index.
     *
     * @param title            the title
     * @param applicationModel the application model
     * @return the validated index
     */
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
     * Validate email boolean
     *
     * @param emailField the email field
     * @return the boolean
     */
    public boolean validateEmail(JTextField emailField) {
        Pattern p = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
        Matcher m = p.matcher(emailField.getText());
        System.out.println(m.matches());

        return m.matches();
    }

    /**
     * Validate user boolean.
     *
     * @param userField the user field
     * @param allUsers  the all users
     * @return the boolean
     */
    public boolean validateUser(JTextField userField, AllUsers allUsers) {
        boolean validated = false;
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (allUsers.getElementAt(i).getUsername().equalsIgnoreCase(userField.getText())) {
                validated = true;
                break;
            }

        }
        return validated;
    }

    /**
     * Validate password boolean.
     *
     * @param passwordField the password field
     * @param allUsers      the all users
     * @return the boolean
     */
    public boolean validatePassword(JTextField passwordField, AllUsers allUsers) {
        boolean validated = false;
        for (int i = 0; i < allUsers.getSize(); i++) {
            if (allUsers.getCode().equalsIgnoreCase(passwordField.getText())) {
                validated = true;
                break;
            }
        }
        return validated;
    }

    /**
     * Gets login index.
     *
     * @param userField the user field
     * @param allUsers  the all users
     * @return the login index
     */
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

    public static boolean validateNew(JTextField passField, JTextField userField, JTextField appField, JTextField emField) {

        boolean valitdated = true;
        Pattern p = Pattern.compile("[,;]");
        Vector<String> checks = new Vector<>();

        checks.add(passField.getText());
        checks.add(userField.getText());
        checks.add(appField.getText());
        checks.add(emField.getText());

        for (int i = 0; i < checks.size(); i++) {

            Matcher m = p.matcher(checks.elementAt(i));

            if (m.matches()) {
                valitdated = true;
            } else {
                valitdated = false;
                break;
            }
        }

        return valitdated;
    }


}
