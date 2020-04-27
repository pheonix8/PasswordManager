package ch.leo.view;

import ch.leo.controller.EditDeleteController;
import ch.leo.controller.LoginController;
import ch.leo.model.AllUsers;
import ch.leo.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class CreateAccountDialog extends JDialog {

    private AllUsers allUsers;

    private JPanel upperPanel;
    private JPanel lowerPanel;

    private JLabel userLabel;
    private JTextField userField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JButton createButton;

    /**
     * Instantiates a new Create account dialog.
     *
     * @param allUsers the all users
     */
    public CreateAccountDialog(AllUsers allUsers) {
        setTitle("Create Account");
        setSize(300, 125);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        this.allUsers = allUsers;

        upperPanel = new JPanel(new GridLayout(2, 2));
        lowerPanel = new JPanel();

        userLabel = new JLabel("Username:");
        userField = new JTextField();

        emailLabel = new JLabel("E-Mail:");
        emailField = new JTextField();
        emailField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                LoginController.onDataEntered(emailField, createButton);
            }
        });

        createButton = new JButton("Create");
        createButton.setEnabled(false);
        createButton.addActionListener(e -> LoginController.onUserAdd(userField, emailField, createButton, allUsers));

        init();
        setVisible(true);
    }

    private void init() {

        upperPanel.add(userLabel);
        upperPanel.add(userField);
        upperPanel.add(emailLabel);
        upperPanel.add(emailField);

        lowerPanel.add(createButton);

        getContentPane().add(upperPanel, BorderLayout.CENTER);
        getContentPane().add(lowerPanel, BorderLayout.SOUTH);
    }
}
