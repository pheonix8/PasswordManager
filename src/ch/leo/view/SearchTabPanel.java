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
public class SearchTabPanel extends JPanel {

    private JPanel searchPanel;
    private JPanel searchUpperPanel;
    private JPanel searchLowerPanel;

    private JComboBox programmType;

    private JList<Application> applications;
    private JScrollPane listscrollpane;

    private JButton searchButton;
    private JLabel searchArea;
    private JTextField searchfield;

    public SearchTabPanel() {

        searchPanel = new JPanel();
        searchUpperPanel = new JPanel();
        searchLowerPanel = new JPanel();

        programmType = new JComboBox();

        applications = new JList<>();
        listscrollpane = new JScrollPane();

        searchButton = new JButton("Suchen");
        searchArea = new JLabel("Passwort Anzeigen:");
        searchfield = new JTextField();

        init();

        setVisible(true);
    }

    private void init(){

        add(searchPanel);

        searchPanel.add(searchUpperPanel, BorderLayout.CENTER);

        searchUpperPanel.add(programmType, BorderLayout.WEST);
        searchUpperPanel.add(applications, BorderLayout.CENTER);

        searchPanel.add(new JSeparator(SwingConstants.VERTICAL));

        searchPanel.add(searchLowerPanel, BorderLayout.SOUTH);

        searchLowerPanel.setLayout(new GridLayout(1,3));
        searchLowerPanel.add(searchArea);
        searchLowerPanel.add(searchfield);
        searchLowerPanel.add(searchButton);

    }
}
