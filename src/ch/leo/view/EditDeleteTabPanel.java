package ch.leo.view;

import ch.leo.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 17.04.2020
 */
public class EditDeleteTabPanel extends JPanel {

    private DefaultComboBoxModel<String> typeModel;
    private DefaultListModel<Application> applicationModel;

    private JComboBox<String> programmType;
    private JList<Application> applications;

    private JLabel searchLabel;
    private JTextField searchField;

    private JButton editButton;
    private JButton deleteButton;

    public EditDeleteTabPanel(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        this.setLayout(new BorderLayout(10,10));

        this.typeModel = typeModel;
        this.applicationModel = applicationModel;

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));
        programmType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTypeSelection(e);
            }
        });

        applications = new JList<Application>(this.applicationModel);

        searchLabel = new JLabel("Eintrag eingeben:");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200,20));

        editButton = new JButton("Bearbeiten");
        editButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickEditWindow(e);
            }
        }));

        deleteButton = new JButton("Löschen");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickDeleteWindow(e);
            }
        });

        add(editdeleteUpperPanel(), BorderLayout.CENTER);
        add(searchLowerPanel(), BorderLayout.SOUTH );

        setVisible(true);

    }

    private JPanel editdeleteUpperPanel(){
        JPanel upperPanel = new JPanel(new BorderLayout(5,5));
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
        JPanel lowerPanel = new JPanel(new BorderLayout(5, 5));
        JPanel textPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout(5,5));

        textPanel.add(searchLabel);
        textPanel.add(searchField);

        buttonPanel.add(editButton, BorderLayout.WEST);
        buttonPanel.add(deleteButton, BorderLayout.EAST);

        lowerPanel.add(textPanel, BorderLayout.CENTER);
        lowerPanel.add(buttonPanel, BorderLayout.SOUTH);

        return lowerPanel;
    }

    private void onTypeSelection(ActionEvent e) {
        ((Compilation)applicationModel).setSelectedType(programmType.getSelectedItem().toString());
    }

    private void onClickDeleteWindow(ActionEvent e) {
        String getValue;
        DeleteDialog deleteDialog = new DeleteDialog(getValue = searchField.getText());
    }

    private void onClickEditWindow(ActionEvent e) {
        String getValue;
        EditDialog editDialog = new EditDialog(typeModel, getValue = searchField.getText());
    }

}
