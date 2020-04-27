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

        Compilation c = new Compilation();
        Types t = new Types();
        AllUsers au = new AllUsers();

        new DataInitialization(c, t, au);
        System.out.println(c);
        System.out.println(t);

        PasswordManagerLoginGUI passwordManagerLoginGUI = new PasswordManagerLoginGUI(c, t, au);

    }
}
