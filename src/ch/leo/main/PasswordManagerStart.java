package ch.leo.main;

import ch.leo.model.*;
import ch.leo.view.*;

import javax.swing.*;
import java.util.Vector;


/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 14.04.2020
 */
public class PasswordManagerStart {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        AllUsers au = new AllUsers();
        AllCompilations ac = new AllCompilations();

        new LoginInitialization(au, ac);

        PasswordManagerLoginGUI passwordManagerLoginGUI = new PasswordManagerLoginGUI(au, ac);

    }
}
