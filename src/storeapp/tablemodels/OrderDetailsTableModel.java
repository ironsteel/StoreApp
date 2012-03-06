/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storeapp.tablemodels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import storeapp.entity.OrderDetail;

/**
 *
 * @author dalev
 */
public class OrderDetailsTableModel extends AbstractTableModel {

    private Map<Integer, String> columsMap = new HashMap<Integer, String>();
    private List<OrderDetail> contents = new ArrayList<OrderDetail>();
    private String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    public OrderDetailsTableModel() {
        columsMap.put(0, "Order Details Id");
        columsMap.put(1, "Order Quantaty");
        columsMap.put(2, "total");
        columsMap.put(3, "Product Name");
        columsMap.put(4, "Product Unit Price");
    }

    public void add(OrderDetail od) {
        contents.add(od);
    }

    public void clear() {
        contents.clear();
    }

    public int getRowCount() {
        return contents.size();
    }

    public int getColumnCount() {
        return columsMap.size();
    }

    public Object getValueAt(final int row, int column) {
        switch (column) {
            case 0:
                return contents.get(row).getOrderId();
            case 1:
                return contents.get(row).getOrderQuantity();
            case 2:
                final JComboBox button = new JComboBox(petStrings);
                button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
							}
						});
                return button;
            case 3:
                return contents.get(row).getProduct().getProductName();
            case 4:
                return contents.get(row).getProduct().getUnitPrice();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columsMap.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
