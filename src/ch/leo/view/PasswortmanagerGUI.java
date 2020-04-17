package ch.leo.view;

import ch.leo.model.*;
import javax.swing.*;
import java.awt.*;

/**
 * Project Password_Manager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 13.04.2020
 */
public class PasswortmanagerGUI extends JFrame {

    private JTabbedPane tabs;
    private SearchTabPanel searchTab;
    private CreateTabPanel createTab;
    private EditDeleteTabPanel editDeleteTab;

    public PasswortmanagerGUI(){

        super("Passwordmanager");

        tabs = new JTabbedPane();

        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void init(){

        getContentPane().add(tabs);
        tabs.addTab("Passwörter", searchTab);
        tabs.addTab("Erstellen", createTab);
        tabs.addTab("Bearbeiten/Löschen", editDeleteTab);

    }


}
