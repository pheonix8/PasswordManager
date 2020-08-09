package ch.leo.view;

import ch.leo.controller.EditDeleteController;
import ch.leo.model.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.04.2020
 */
public class DeleteDialog extends JDialog {
    private String title;

    private JLabel deleteLabel;
    private JPanel buttonPanel;
    private JButton noButton;
    private JButton yesButton;

    /**
     * Instantiates a new Delete dialog.
     *
     * @param title            the title
     * @param applicationModel the application model
     */
    public DeleteDialog(String title, DefaultListModel<Application> applicationModel) {
        this.title = title;
        setTitle(title);
        setSize(300, 125);

        deleteLabel = new JLabel("Do you really want to delete the item: " + title + " ?");
        buttonPanel = new JPanel();
        noButton = new JButton("No");
        yesButton = new JButton("Yes");

        noButton.addActionListener(e -> dispose());

        yesButton.addActionListener(e -> {
            EditDeleteController.onApplicationDeleted(applicationModel, title);
            dispose();
        });

        setLayout(new BorderLayout(10, 10));

        add(deleteLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(noButton, BorderLayout.WEST);
        buttonPanel.add(yesButton, BorderLayout.EAST);

        setVisible(true);
        setLocationRelativeTo(null);

    }
}
