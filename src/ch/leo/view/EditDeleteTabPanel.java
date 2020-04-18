package ch.leo.view;

import ch.leo.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 17.04.2020
 */
public class EditDeleteTabPanel extends JPanel {

    private JPanel edPanel;

    private JPanel edUpperPanel;

    private JPanel edLowerPanel;
    private JPanel edLowernorthPanel;
    private JPanel edLowersouthPanel;

    private DefaultComboBoxModel<Type> typeModel;
    private JComboBox<Type> getProgrammTypeED;

    private DefaultListModel<Application> applicationModel;
    private JList<Application> getApplicationsED;
    private JScrollPane listscrollpaneED;

    private JLabel searchAreaED;
    private JTextField searchFieldED;

    private JButton editButton;
    private JButton deleteButton;

    public EditDeleteTabPanel(DefaultComboBoxModel<Type> typeModel, DefaultListModel<Application> applicationModel) {
        this.typeModel = typeModel;
        this.applicationModel = applicationModel;


        edPanel = new JPanel();

        edUpperPanel = new JPanel();

        edLowerPanel = new JPanel();
        edLowernorthPanel = new JPanel();
        edLowersouthPanel = new JPanel();

        getProgrammTypeED = new JComboBox<Type>(this.typeModel);
        getProgrammTypeED.setEditable(false);
        getProgrammTypeED.setPreferredSize(new Dimension(150, getProgrammTypeED.getPreferredSize().height));

        getApplicationsED = new JList<Application>(this.applicationModel);
        listscrollpaneED = new JScrollPane();

        searchAreaED = new JLabel("Eintrag eingeben:");
        searchFieldED = new JTextField();

        editButton = new JButton("Bearbeiten");
        deleteButton = new JButton("Löschen");

        init();

        setVisible(true);

    }

    private void init(){

        add(edPanel);

        edPanel.add(edUpperPanel, BorderLayout.CENTER);

        edUpperPanel.add(getProgrammTypeED, BorderLayout.WEST);
        edUpperPanel.add(getApplicationsED, BorderLayout.CENTER);

        edPanel.add(edLowerPanel, BorderLayout.SOUTH);
        edLowerPanel.add(edLowernorthPanel, BorderLayout.CENTER);
        edLowerPanel.add(edLowersouthPanel, BorderLayout.SOUTH);

        edLowernorthPanel.setLayout(new GridLayout(1,2));
        edLowernorthPanel.add(searchAreaED);
        edLowernorthPanel.add(searchFieldED);

        edLowersouthPanel.add(editButton, BorderLayout.WEST);
        edLowersouthPanel.add(deleteButton, BorderLayout.EAST);

    }

}
