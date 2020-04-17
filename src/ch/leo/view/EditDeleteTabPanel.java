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

    private JComboBox<Type> getProgrammTypeED;

    private JList<Application> getApplicationsED;
    private JScrollPane listscrollpaneED;

    private JTextArea searchAreaED;
    private JTextField searchFieldED;

    private JButton editButton;
    private JButton deleteButton;

    public EditDeleteTabPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);

        edPanel = new JPanel();
        edUpperPanel = new JPanel();
        edLowerPanel = new JPanel();

        getProgrammTypeED = new JComboBox<>();

        getApplicationsED = new JList<>();
        listscrollpaneED = new JScrollPane();

        searchAreaED = new JTextArea("Eintrag eingeben:");
        searchFieldED = new JTextField();

        editButton = new JButton("Bearbeiten");
        deleteButton = new JButton("Löschen");

        searchAreaED.setEditable(false);

        init();

    }

    private void init(){

        edPanel.add(edUpperPanel, BorderLayout.CENTER);

    }
}
