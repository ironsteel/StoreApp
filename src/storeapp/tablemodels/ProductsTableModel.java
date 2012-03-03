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
import storeapp.entity.Product;

/**
 *
 * @author Rangel Ivanov Iron_steel_88@abv.bg
 */
public class ProductsTableModel extends AbstractTableModel {

    private Map<Integer, String> columsMap = new HashMap<Integer, String>();
    private List<Product> contents = new ArrayList<Product>();

    public ProductsTableModel() {
        columsMap.put(0, "Product Id");
        columsMap.put(1, "In Stock");
        columsMap.put(2, "Product Name");
        columsMap.put(3, "Qantaty");
        columsMap.put(3, "Unit Price");
    }

    public int getRowCount() {
        return contents.size();
    }

    public void add(Product p) {
        contents.add(p);
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
                return contents.get(row).getProductId();
            case 1:
                return contents.get(row).getInStock();
            case 2:
                return contents.get(row).getProductName();
            case 3:
                return contents.get(row).getQuantity();
            case 4:
                return contents.get(row).getUnitPrice();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


}
