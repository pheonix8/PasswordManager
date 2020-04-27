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
    private AllUsers allUsers;

    /**
     * Instantiates a new Data initialization.
     *
     * @param compilation the compilation
     * @param types       the types
     * @param allUsers    the all users
     */
    public DataInitialization(Compilation compilation, Types types, AllUsers allUsers) {
        this.compilation = compilation;
        this.types = types;
        this.allUsers = allUsers;

        types.addType("Gamelauncher");
        types.addType("Mail");
        types.addType("Music");
        types.addType("Others");

        allUsers.readfile();

        compilation.readfile();

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Compilation c = new Compilation();
        Types t = new Types();
        AllUsers au = new AllUsers();
        DataInitialization di = new DataInitialization(c, t, au);
    }
}
