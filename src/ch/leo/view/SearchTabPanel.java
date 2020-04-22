package ch.leo.view;

import ch.leo.controller.CreateController;
import ch.leo.controller.SearchController;
import ch.leo.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 17.04.2020
 */
public class SearchTabPanel extends JPanel {

    private DefaultComboBoxModel<String> typeModel;
    private DefaultListModel<Application> applicationModel;

    private JComboBox<String> programmType;
    private JList<Application> applications;

    private JButton searchButton;
    private JLabel searchLabel;
    private JTextField searchField;

    public SearchTabPanel(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        this.setLayout(new BorderLayout(10, 10));

        this.typeModel = typeModel;
        this.applicationModel = applicationModel;

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));
        programmType.addActionListener(e -> SearchController.onTypeSelection(programmType,applicationModel));

        applications = new JList<Application>(this.applicationModel);
        applications.setCellRenderer(new MyCellRenderer());

        searchLabel = new JLabel("Passwort Anzeigen:");
        searchField = new JTextField();
        searchButton = new JButton("Suchen");

        searchField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                SearchController.onDataEntered(searchField,applicationModel,searchButton);
            }
        });
        searchButton.addActionListener(e -> SearchController.onClickShowOpen(searchField,applicationModel));

        this.add(searchUpperPanel(), BorderLayout.CENTER);
        this.add(searchLowerPanel(), BorderLayout.SOUTH);

        searchButton.setEnabled(false);


    }

    private JPanel searchUpperPanel() {
        JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        JPanel comboboxPanel = new JPanel(new BorderLayout(5, 5));
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));

        comboboxPanel.add(programmType, BorderLayout.WEST);
        listPanel.add(new JScrollPane(applications, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

        upperPanel.add(comboboxPanel, BorderLayout.WEST);
        upperPanel.add(listPanel, BorderLayout.CENTER);
        upperPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);

        return upperPanel;
    }

    private JPanel searchLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout(10, 10));

        lowerPanel.add(searchLabel, BorderLayout.WEST);
        lowerPanel.add(searchField, BorderLayout.CENTER);
        lowerPanel.add(searchButton, BorderLayout.EAST);

        return lowerPanel;
    }

}
