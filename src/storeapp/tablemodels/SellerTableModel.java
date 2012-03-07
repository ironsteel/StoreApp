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
import storeapp.entity.Seller;

/**
 *
 * @author dalev
 */
public class SellerTableModel extends AbstractTableModel {

    private Map<Integer, String> columsMap = new HashMap<Integer, String>();
    private List<Seller> contents = new ArrayList<Seller>();

    public SellerTableModel() {
        columsMap.put(0, "Seller Id");
        columsMap.put(1, "Seller Phone");
        columsMap.put(2, "Seller Pasword");
        columsMap.put(3, "Name");
        columsMap.put(3, "IS Manager");
    }

    public int getRowCount() {
        return contents.size();
    }

    public void add(Seller s) {
        contents.add(s);
    }

    public void clear() {
        contents.clear();
    }

    public int getColumnCount() {
        return columsMap.size();
    }

    @Override
    public String getColumnName(int column) {
        return columsMap.get(column);
    }

    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return contents.get(row).getSellerId();
            case 1:
                return contents.get(row).getSellerPhone();
            case 2:
                return contents.get(row).getPassword();
            case 3:
                return contents.get(row).getNameSeller();
            case 4:
                return contents.get(row).getIsManager();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
