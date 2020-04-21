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

    private DefaultComboBoxModel<String> typeModel;
    private DefaultListModel<Application> applicationModel;

    private JComboBox<String> programmType;
    private JList<Application> applications;

    private JButton searchButton;
    private JLabel searchLabel;
    private JTextField searchfield;

    public SearchTabPanel(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        this.setLayout(new BorderLayout(10, 10));

        this.typeModel = typeModel;
        this.applicationModel = applicationModel;

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));

        applications = new JList<Application>(this.applicationModel);

        searchButton = new JButton("Suchen");
        searchLabel = new JLabel("Passwort Anzeigen:");
        searchfield = new JTextField();

        add(searchUpperPanel(), BorderLayout.CENTER);
        add(searchLowerPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel searchUpperPanel() {
        JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        JPanel comboboxPanel = new JPanel(new BorderLayout(5, 5));
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));

        comboboxPanel.add(programmType, BorderLayout.WEST);
        listPanel.add(new JScrollPane(applications, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

        upperPanel.add(comboboxPanel, BorderLayout.WEST);
        upperPanel.add(comboboxPanel, BorderLayout.CENTER);
        upperPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);

        return upperPanel;
    }

    private JPanel searchLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout(10, 10));

        lowerPanel.add(searchLabel, BorderLayout.WEST);
        lowerPanel.add(searchfield, BorderLayout.CENTER);
        lowerPanel.add(searchButton, BorderLayout.EAST);

        return lowerPanel;
    }

}
