package ch.leo.main;

import ch.leo.model.*;
import ch.leo.view.*;

import javax.swing.*;


/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 14.04.2020
 */
public class PasswordManagerStart {

    public static void main(String[] args) {

        Compilation c = new Compilation();
        Types t = new Types();

        new DataInitialization(c,t);
        System.out.println(c);
        System.out.println(t);

        PasswortmanagerGUI passwortmanagerGUI = new PasswortmanagerGUI(c,t);

    }
}
