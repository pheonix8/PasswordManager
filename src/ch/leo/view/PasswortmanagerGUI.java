package ch.leo.view;

import ch.leo.model.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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

    /**
     * Instantiates a new Passwortmanager gui.
     *
     * @param applicationModel the application model
     * @param typeModel        the type model
     */
    public PasswortmanagerGUI(DefaultListModel<Application> applicationModel, DefaultComboBoxModel<String> typeModel) {

        super("Passwordmanager");

        this.applicationModel = applicationModel;
        this.typeModel = typeModel;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabs = new JTabbedPane();
        initSearchTab(this.typeModel, this.applicationModel);
        initCreateTab(this.typeModel, this.applicationModel);
        initEditDeleteTab(this.typeModel, this.applicationModel);
        this.add(tabs, BorderLayout.CENTER);

        setMinimumSize(new Dimension(500, 400));

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }


    private void initEditDeleteTab(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        editDeleteTab = new EditDeleteTabPanel(typeModel, applicationModel);
        tabs.add("Edit/Delete", editDeleteTab);
    }

    private void initSearchTab(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        searchTab = new SearchTabPanel(typeModel, applicationModel);
        tabs.add("Passwords", searchTab);
    }

    private void initCreateTab(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        createTab = new CreateTabPanel(typeModel, applicationModel);
        tabs.add("Create", createTab);
    }


}
