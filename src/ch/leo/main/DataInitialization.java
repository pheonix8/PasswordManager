package ch.leo.main;

import ch.leo.model.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 18.04.2020
 */
public class DataInitialization {

    private Compilation compilation;
    private Types types;

    public DataInitialization(Compilation compilation, Types types) {
        this.compilation = compilation;
        this.types = types;

        types.addType("GameLauncher");
        types.addType("Mail");
        types.addType("Music");
        types.addType("Others");

        compilation.readfile();
    }

    public static void main(String[] args) {
        Compilation c = new Compilation();
        Types t = new Types();
        DataInitialization di = new DataInitialization(c,t);
    }
}
