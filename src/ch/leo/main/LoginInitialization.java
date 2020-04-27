package ch.leo.main;

import ch.leo.model.AllCompilations;
import ch.leo.model.AllUsers;
import ch.leo.model.Compilation;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class LoginInitialization {

    private AllUsers allUsers;
    private AllCompilations allCompilations;

    /**
     * Instantiates a new Login initialization.
     *
     * @param allUsers        the all users
     * @param allCompilations the all compilations
     */
    public LoginInitialization(AllUsers allUsers, AllCompilations allCompilations) {
        this.allUsers = allUsers;
        this.allCompilations = allCompilations;

        allUsers.readfile();

        for (int i = 0; i < allUsers.getSize(); i++) {

            Compilation compilation = new Compilation(
                    allUsers.getElementAt(i).getUsername()
            );

            allCompilations.addCompilation(compilation);

        }

        for (int i = 0; i < allCompilations.getSize(); i++) {

            allCompilations.getElementAt(i).createfile();
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AllUsers au = new AllUsers();
        AllCompilations ac = new AllCompilations();
        LoginInitialization li = new LoginInitialization(au, ac);
    }
}
