package ch.leo.main;

import ch.leo.model.*;
import ch.leo.view.PasswortmanagerGUI;

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

    /**
     * Instantiates a new Data initialization.
     *
     * @param allCompilations all compilations
     * @param types           the types
     * @param name            the name
     */
    public DataInitialization(AllCompilations allCompilations, Types types, String name) {
        compilation = allCompilations.getElementbyname(name);
        this.types = types;

        types.addType("Gamelauncher");
        types.addType("Mail");
        types.addType("Music");
        types.addType("Others");


        compilation.readfile();

        PasswortmanagerGUI passwortmanagerGUI = new PasswortmanagerGUI(compilation,types);

    }

}
