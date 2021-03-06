/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEddit.java
 *
 * Created on Mar 3, 2012, 10:51:41 PM
 */
package storeapp;

import java.util.List;
import javax.persistence.Query;
import storeapp.entity.CustomOrder;
import storeapp.entity.OrderDetail;
import storeapp.tablemodels.OrderDetailsTableModel;

/**
 *
 * @author dalev
 */
public class ViewOrderDetailsDialog extends javax.swing.JDialog {

    public static final String TITLE_EDIT = "View Details";
    private List<OrderDetail> orderDetail;

    private OrderDetailsTableModel orderDetailsTableModel;

    public ViewOrderDetailsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle(TITLE_EDIT);
        orderDetailsTableModel = new OrderDetailsTableModel();
        initComponents();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("storedbPU").createEntityManager();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderDetailsTable = new javax.swing.JTable();
        totalPriceLabel = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        orderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        orderDetailsTable.setName("orderDetailsTable"); // NOI18N
        jScrollPane1.setViewportView(orderDetailsTable);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(storeapp.StoreApp.class).getContext().getResourceMap(ViewOrderDetailsDialog.class);
        totalPriceLabel.setText(resourceMap.getString("totalPriceLabel.text")); // NOI18N
        totalPriceLabel.setName("totalPriceLabel"); // NOI18N

        totalPriceField.setText(resourceMap.getString("totalPriceField.text")); // NOI18N
        totalPriceField.setName("totalPriceField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPriceLabel)
                    .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderDetailsTable;
    private javax.swing.JTextField totalPriceField;
    private javax.swing.JLabel totalPriceLabel;
    // End of variables declaration//GEN-END:variables

    void setCustomOrderId(Integer customOrderId) {
        orderDetailsTableModel.clear();

        int customerOrderId = customOrderId;
        orderDetail =  entityManager.createNamedQuery("OrderDetail.getGatAllByCustomerOrderId").setParameter("custom_order_id", customerOrderId).getResultList();
        for(OrderDetail od : orderDetail) {
            orderDetailsTableModel.add(od);
        }
        orderDetailsTable.setModel(orderDetailsTableModel);

        double totalPrice = calcualteTotalPriceForOrder(entityManager.find(CustomOrder.class, customOrderId));

        totalPriceField.setText(String.valueOf(totalPrice));

    }


     private double calcualteTotalPriceForOrder(CustomOrder customerOrder) {

        double totalPrice = 0;

        Query q = entityManager.createNamedQuery("OrderDetail.getGatAllByCustomerOrderId");
        q.setParameter("custom_order_id", customerOrder.getCustomOrderId());
        List<OrderDetail> orderDetailsList = q.getResultList();

        for (OrderDetail od : orderDetailsList) {
            double quantaty = od.getOrderQuantity();
            double productUnitPrice = od.getProduct().getUnitPrice();
            totalPrice += quantaty * productUnitPrice;

        }
        return totalPrice;
    }
}
