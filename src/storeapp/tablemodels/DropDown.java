/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storeapp.tablemodels;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dalev
 */
public class DropDown extends OrderDetailsTableModel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        
        JComboBox button = (JComboBox) value;
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(UIManager.getColor("Button.background"));
        }
        return button;
    }
}
