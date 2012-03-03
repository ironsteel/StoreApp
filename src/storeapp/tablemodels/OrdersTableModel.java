/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storeapp.tablemodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rangel Ivanov Iron_steel_88@abv.bg
 */
public class OrdersTableModel extends AbstractTableModel {

    private List<OrderModel> contents = new ArrayList<OrderModel>();
    private Map<Integer, String> columsMap = new HashMap<Integer, String>();

    public OrdersTableModel() {
        columsMap.put(0, "Order Id:");
        columsMap.put(1, "Customer Name");
        columsMap.put(2, "Sum Price");

    }

    public void add(OrderModel m) {
        contents.add(m);
    }

    public void clear() {
        contents.clear();
    }

    public void setContents(List<OrderModel> contents) {
        this.contents = contents;
    }

    @Override
    public String getColumnName(int column) {
        return columsMap.get(column);
    }

    public int getRowCount() {
        return contents.size();
    }

    public int getColumnCount() {
        return columsMap.size();
    }

    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return contents.get(row).getOrderId();
            case 1:
                return contents.get(row).getCustomerName();
            case 2:
                return contents.get(row).getSumPrice();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


}
