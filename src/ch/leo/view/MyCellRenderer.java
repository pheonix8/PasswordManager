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

    JTextArea applicationName;
    JScrollPane scrollPane;

    MyCellRenderer(){
        applicationName = new JTextArea(1,12);
        applicationName.setEditable(false);
        scrollPane = new JScrollPane(applicationName, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }



    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus)
    {
        applicationName.setText( ((Application)value).getApplication() );
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        return this;
    }
}
