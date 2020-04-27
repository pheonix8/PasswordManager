package ch.leo.view;

import ch.leo.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Project PasswordManager
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 21.04.2020
 */
public class MyCellRenderer extends JPanel implements ListCellRenderer<Object> {

    JTextField typeName;
    JTextField applicationName;
    JScrollPane scrollPane;

    MyCellRenderer() {
        typeName = new JTextField(12);
        typeName.setEditable(false);
        typeName.setBackground(new Color(248, 240, 176));
        applicationName = new JTextField(12);
        applicationName.setEditable(false);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        this.setLayout(new BorderLayout());
        typeName.setText(((Application) value).getType());
        applicationName.setText(((Application) value).getApplication());
        this.add(typeName, BorderLayout.NORTH);
        this.add(applicationName, BorderLayout.SOUTH);
        return this;
    }
}
