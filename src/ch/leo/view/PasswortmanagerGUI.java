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
    private DefaultComboBoxModel<String> typeModel;

    private JTabbedPane tabs;
    private SearchTabPanel searchTab;
    private CreateTabPanel createTab;
    private EditDeleteTabPanel editDeleteTab;

    public PasswortmanagerGUI(DefaultListModel<Application> applicationModel, DefaultComboBoxModel<String> typeModel){

        super("Passwordmanager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationModel = applicationModel;
        this.typeModel = typeModel;

        tabs = new JTabbedPane();
        initSearchTab(this.typeModel, this.applicationModel);
        initCreateTab(this.typeModel);
        initEditDeleteTab(this.typeModel, this.applicationModel);
        this.add(tabs, BorderLayout.CENTER);

        setMinimumSize(new Dimension(500, 400));

        pack();
        setVisible(true);

    }

    private void initEditDeleteTab(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel){
        editDeleteTab = new EditDeleteTabPanel(typeModel, applicationModel);
        tabs.add("Bearbeiten/Löschen", editDeleteTab);
    }

    private void initSearchTab(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel){
        searchTab = new SearchTabPanel(typeModel, applicationModel);
        tabs.add("Passwörter", searchTab);
    }

    private void initCreateTab(DefaultComboBoxModel<String> typeModel){
        createTab = new CreateTabPanel(typeModel);
        tabs.add("Erstellen", createTab);
    }



}
