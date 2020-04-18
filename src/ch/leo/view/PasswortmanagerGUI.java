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

    private DefaultListModel<Application> applicationModel;
    private DefaultComboBoxModel<ch.leo.model.Type> typeModel;

    private JTabbedPane tabs;
    private SearchTabPanel searchTab;
    private CreateTabPanel createTab;
    private EditDeleteTabPanel editDeleteTab;

    public PasswortmanagerGUI(DefaultListModel<Application> applicationModel, DefaultComboBoxModel<ch.leo.model.Type> typeModel){

        super("Passwordmanager");

        this.applicationModel = applicationModel;
        this.typeModel = typeModel;

        tabs = new JTabbedPane();
        searchTab = new SearchTabPanel();
        createTab = new CreateTabPanel();
        editDeleteTab = new EditDeleteTabPanel(typeModel, applicationModel);

        setMinimumSize(new Dimension(640,480));
        setSize(640, 480);
        setResizable(false);

        init();
        pack();

        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void init(){

        getContentPane().add(tabs);
        tabs.add("Passwörter", searchTab);
        tabs.add("Erstellen", createTab);
        tabs.add("Bearbeiten/Löschen", editDeleteTab);

    }


}
