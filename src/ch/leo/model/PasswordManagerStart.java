package ch.leo.model;


/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 14.04.2020
 */
public class PasswordManagerStart {

    public static void main(String[] args) {

        Types types = new Types();

        types.readfile();
        
        types.createfile();


    }
}
