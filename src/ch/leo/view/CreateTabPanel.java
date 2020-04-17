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
public class CreateTabPanel extends JPanel {

    private JPanel createPanel;
    private JPanel createLeftPanel;
    private JPanel createRightPanel;

    private JTextArea applicationArea;
    private JTextField applicationField;

    private JTextArea usernameArea;
    private JTextField usernameField;

    private JTextArea emailArea;
    private JTextField emailField;

    private JTextArea passwordArea;
    private JTextField passwordField;

    private JComboBox<Type> getProgrammType;

    private JButton createButton;

    public CreateTabPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);

        createPanel = new JPanel();
        createLeftPanel = new JPanel();
        createRightPanel = new JPanel();

        applicationArea = new JTextArea("Application:");
        applicationField = new JTextField();

        usernameArea = new JTextArea("Benutzername:");
        usernameField = new JTextField();

        emailArea = new JTextArea("E-Mail:");
        emailField = new JTextField();

        passwordArea = new JTextArea("Passwort:");
        passwordField = new JTextField();

        getProgrammType = new JComboBox<>();

        createButton = new JButton("Erstellen");

        applicationArea.setEditable(false);
        usernameArea.setEditable(false);
        emailArea.setEditable(false);
        passwordArea.setEditable(false);

        init();

    }

    private void init(){

    }
}
