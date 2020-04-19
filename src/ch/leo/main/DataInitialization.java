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

        types.readfile();

        compilation.readfile();
    }

    public static void main(String[] args) {
        Compilation c = new Compilation();
        Types t = new Types();
        DataInitialization di = new DataInitialization(c,t);
        System.out.println(c);
        System.out.println(t);
    }
}
