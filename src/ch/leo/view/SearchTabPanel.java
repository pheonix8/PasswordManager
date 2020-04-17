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

    private JComboBox<Type> programmType;

    private JList<Application> applications;
    private JScrollPane listscrollpane;

    private JButton searchButton;
    private JTextArea searchArea;
    private JTextField searchfield;

    public SearchTabPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);

        searchPanel = new JPanel();
        searchUpperPanel = new JPanel();
        searchLowerPanel = new JPanel();

        programmType = new JComboBox<>();

        applications = new JList<>();
        listscrollpane = new JScrollPane();

        searchButton = new JButton("Suchen");
        searchArea = new JTextArea("Passwort Anzeigen:");
        searchfield = new JTextField();

        searchArea.setEditable(false);

        init();
    }

    private void init(){

    }
}
