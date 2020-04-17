package ch.leo.main;

import ch.leo.model.*;
import ch.leo.view.*;


/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 14.04.2020
 */
public class PasswordManagerStart {

    public static void main(String[] args) {

        PasswortmanagerGUI passwortmanagerGUI = new PasswortmanagerGUI();

        Types types = new Types();

        Compilation compilation = new Compilation();
        
        types.readfile();

        compilation.readfile();

        compilation.createfile();

        types.createfile();

    }
}
