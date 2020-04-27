package ch.leo.view;

import ch.leo.controller.EditDeleteController;
import ch.leo.controller.LoginController;
import ch.leo.model.AllCompilations;
import ch.leo.model.AllUsers;
import ch.leo.model.Application;
import ch.leo.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.04.2020
 */
public class PasswordManagerLoginGUI extends JFrame {

    private AllCompilations allCompilations;
    private AllUsers allUsers;

    private JPanel upperPanel;
    private JPanel lowerPanel;

    private JLabel userLabel;
    private JTextField userField;
    private JButton requestButton;

    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton loginButton;

    private JButton createAccountButton;

    /**
     * Instantiates a new Password manager login gui.
     *
     * @param allUsers        the all users
     * @param allCompilations the all compilations
     */
    public PasswordManagerLoginGUI(AllUsers allUsers, AllCompilations allCompilations) {

        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        this.allUsers = allUsers;
        this.allCompilations = allCompilations;

        upperPanel = new JPanel(new GridLayout(2, 3));
        lowerPanel = new JPanel();

        userLabel = new JLabel("Username:");
        userField = new JTextField();
        userField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                LoginController.onUserEntered(userField, allUsers, requestButton);
            }
        });
        requestButton = new JButton("Request PW");
        requestButton.addActionListener(e -> LoginController.onClickRequestPW(userField, allUsers, passwordField));
        requestButton.setEnabled(false);

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        passwordField.setEditable(false);
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                LoginController.onPasswordEntered(passwordField, allUsers, loginButton);
            }
        });
        loginButton = new JButton("Login");
        loginButton.setEnabled(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.onClickStart(allCompilations, userField);
                setVisible(false);
            }
        });

        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(e -> LoginController.onClickCreateAccountWindow(allUsers, allCompilations));

        setMinimumSize(new Dimension(300, 200));

        init();
        pack();
        setVisible(true);

    }

    private void init() {

        upperPanel.add(userLabel);
        upperPanel.add(userField);
        upperPanel.add(requestButton);
        upperPanel.add(passwordLabel);
        upperPanel.add(passwordField);
        upperPanel.add(loginButton);

        lowerPanel.add(createAccountButton, BorderLayout.CENTER);

        getContentPane().add(upperPanel, BorderLayout.CENTER);
        getContentPane().add(lowerPanel, BorderLayout.SOUTH);

    }
}
