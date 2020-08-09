package ch.leo.view;

import ch.leo.controller.EditDeleteController;
import ch.leo.model.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    /**
     * Instantiates a new Edit delete tab panel.
     *
     * @param typeModel        the type model
     * @param applicationModel the application model
     */
    public EditDeleteTabPanel(DefaultComboBoxModel<String> typeModel, DefaultListModel<Application> applicationModel) {
        this.setLayout(new BorderLayout(10, 10));

        this.typeModel = typeModel;
        this.applicationModel = applicationModel;

        programmType = new JComboBox<String>(this.typeModel);
        programmType.setEditable(false);
        programmType.setPreferredSize(new Dimension(150, programmType.getPreferredSize().height));
        programmType.addActionListener(e -> EditDeleteController.onTypeSelection(programmType, applicationModel));

        applications = new JList<Application>(this.applicationModel);
        applications.setCellRenderer(new MyCellRenderer());

        searchLabel = new JLabel("Enter item:");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        searchField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                EditDeleteController.onDataEntered(searchField, applicationModel, deleteButton, editButton);
            }
        });

        editButton = new JButton("Edit");
        editButton.addActionListener(e -> EditDeleteController.onClickEditWindow(searchField, typeModel, applicationModel));

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> EditDeleteController.onClickDeleteWindow(searchField, applicationModel));

        add(editdeleteUpperPanel(), BorderLayout.CENTER);
        add(searchLowerPanel(), BorderLayout.SOUTH);

        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

    }

    private JPanel editdeleteUpperPanel() {
        Border border = BorderFactory.createEmptyBorder(50, 0, 100, 0);

        JPanel upperPanel = new JPanel(new BorderLayout());
        JPanel comboboxPanel = new JPanel(new BorderLayout());
        JPanel listPanel = new JPanel(new BorderLayout());

        comboboxPanel.add(programmType, BorderLayout.WEST);
        comboboxPanel.setBorder(border);
        listPanel.add(new JScrollPane(
                applications,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER),
                BorderLayout.CENTER);

        upperPanel.add(comboboxPanel, BorderLayout.WEST);
        upperPanel.add(listPanel, BorderLayout.CENTER);
        upperPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);

        return upperPanel;
    }

    private JPanel searchLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout(5, 5));
        JPanel textPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout(5, 5));

        textPanel.add(searchLabel);
        textPanel.add(searchField);

        buttonPanel.add(editButton, BorderLayout.WEST);
        buttonPanel.add(deleteButton, BorderLayout.EAST);

        lowerPanel.add(textPanel, BorderLayout.CENTER);
        lowerPanel.add(buttonPanel, BorderLayout.SOUTH);

        return lowerPanel;
    }


}
