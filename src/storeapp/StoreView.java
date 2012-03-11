/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StoreView.java
 *
 * Created on Mar 3, 2012, 7:01:42 PM
 */
package storeapp;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jdesktop.application.Action;
import storeapp.entity.CustomOrder;
import storeapp.entity.OrderDetail;
import storeapp.entity.Product;
import storeapp.session.UserSessionManager;
import storeapp.tablemodels.OrderModel;
import storeapp.tablemodels.OrdersTableModel;
import storeapp.tablemodels.ProductsTableModel;
import sun.awt.AWTAccessor.ComponentAccessor;

/**
 *
 * @author dalev
 */
public class StoreView extends javax.swing.JFrame {

    private static final String APP_NAME = "StoreApp";
    public static final String PRODUCT_TABLE_TITLE = "Product";
    private String SELLER_CRUD_TAB_TITLE = "Seller";
    private String CUSTOMER_CRUD_TABLE = "Customers";
    public static final int READ_ONLY_PRODUCTS_TABLE_INDEX = 1;
    private EntityManager entityManager = Persistence.createEntityManagerFactory("storedbPU").createEntityManager();
    private LoginDialog loginDialog;
    private ViewOrderDetailsDialog editOrderDialog;
    private AddOrderDialog addOrderDialog;
    private List<CustomOrder> orders;
    private List<Product> allProducts;
    private OrdersTableModel ordersTableModel = new OrdersTableModel();
    private ProductsTableModel productsTableModel = new ProductsTableModel();
    private ProductCrudTable productCrud;
    private SellerCrudTable sellerCrud;
    private CustomerCrudTable customerCrudTable;

    /** Creates new form StoreView */
    public StoreView() {
        initComponents();
        setTitle(APP_NAME);
        loginDialog = new LoginDialog(this, true);
        loginDialog.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentHidden(ComponentEvent e) {

                fetchCustomerOrdersBySellerId();
                fetchAllProducts();

                boolean isManager = UserSessionManager.getSingleton().isCurrentUserManager();
                if (isManager) {
                    tabPanel.removeTabAt(READ_ONLY_PRODUCTS_TABLE_INDEX);
                    tabPanel.addTab(PRODUCT_TABLE_TITLE, productCrud);
                    tabPanel.addTab(SELLER_CRUD_TAB_TITLE, sellerCrud);

                }
                tabPanel.addTab(CUSTOMER_CRUD_TABLE, customerCrudTable);
            }
        });



        loginDialog.setEnityManager(entityManager);
        loginDialog.setVisible(true);
        editOrderDialog = new ViewOrderDetailsDialog(this, true);
        addOrderDialog = new AddOrderDialog(this, false);
        productCrud = new ProductCrudTable();
        sellerCrud = new SellerCrudTable();
        customerCrudTable = new CustomerCrudTable();

        addOrderDialog.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentHidden(ComponentEvent e) {
                orders.clear();
                ordersTableModel.clear();
                fetchCustomerOrdersBySellerId();
            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        ordersTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        addOrderButton = new javax.swing.JButton();
        editOrderButton = new javax.swing.JButton();
        removeOrderButton = new javax.swing.JButton();
        viewOrderDetails = new javax.swing.JButton();
        productsTablePanel = new javax.swing.JPanel();
        productsTableScroll = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        tabPanel.setName("tabPanel"); // NOI18N

        ordersTablePanel.setName("ordersTablePanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        orderTable.setName("orderTable"); // NOI18N
        jScrollPane1.setViewportView(orderTable);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(storeapp.StoreApp.class).getContext().getActionMap(StoreView.class, this);
        addOrderButton.setAction(actionMap.get("addOrder")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(storeapp.StoreApp.class).getContext().getResourceMap(StoreView.class);
        addOrderButton.setText(resourceMap.getString("addOrderButton.text")); // NOI18N
        addOrderButton.setName("addOrderButton"); // NOI18N

        editOrderButton.setAction(actionMap.get("editOrder")); // NOI18N
        editOrderButton.setText(resourceMap.getString("editOrderButton.text")); // NOI18N
        editOrderButton.setName("editOrderButton"); // NOI18N

        removeOrderButton.setAction(actionMap.get("removeOrder")); // NOI18N
        removeOrderButton.setText(resourceMap.getString("removeOrderButton.text")); // NOI18N
        removeOrderButton.setName("removeOrderButton"); // NOI18N

        viewOrderDetails.setAction(actionMap.get("viewOrderDetails")); // NOI18N
        viewOrderDetails.setText(resourceMap.getString("viewOrderDetails.text")); // NOI18N
        viewOrderDetails.setName("viewOrderDetails"); // NOI18N

        javax.swing.GroupLayout ordersTablePanelLayout = new javax.swing.GroupLayout(ordersTablePanel);
        ordersTablePanel.setLayout(ordersTablePanelLayout);
        ordersTablePanelLayout.setHorizontalGroup(
            ordersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ordersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(ordersTablePanelLayout.createSequentialGroup()
                        .addComponent(addOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewOrderDetails)))
                .addContainerGap())
        );
        ordersTablePanelLayout.setVerticalGroup(
            ordersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOrderButton)
                    .addComponent(editOrderButton)
                    .addComponent(removeOrderButton)
                    .addComponent(viewOrderDetails)))
        );

        tabPanel.addTab(resourceMap.getString("ordersTablePanel.TabConstraints.tabTitle"), ordersTablePanel); // NOI18N

        productsTablePanel.setName("productsTablePanel"); // NOI18N

        productsTableScroll.setName("productsTableScroll"); // NOI18N

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productsTable.setName("productsTable"); // NOI18N
        productsTableScroll.setViewportView(productsTable);

        javax.swing.GroupLayout productsTablePanelLayout = new javax.swing.GroupLayout(productsTablePanel);
        productsTablePanel.setLayout(productsTablePanelLayout);
        productsTablePanelLayout.setHorizontalGroup(
            productsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productsTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        productsTablePanelLayout.setVerticalGroup(
            productsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productsTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        tabPanel.addTab(resourceMap.getString("productsTablePanel.TabConstraints.tabTitle"), productsTablePanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StoreView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrderButton;
    private javax.swing.JButton editOrderButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JPanel ordersTablePanel;
    private javax.swing.JTable productsTable;
    private javax.swing.JPanel productsTablePanel;
    private javax.swing.JScrollPane productsTableScroll;
    private javax.swing.JButton removeOrderButton;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JButton viewOrderDetails;
    // End of variables declaration//GEN-END:variables

    private void fetchCustomerOrdersBySellerId() {
        int userId = UserSessionManager.getSingleton().getUserId();
        orders = entityManager.createNamedQuery(CustomOrder.orderDetails).setParameter("userID", userId).getResultList();

        for (CustomOrder o : orders) {
            double totalPrice = calcualteTotalPriceForOrder(o);
            ordersTableModel.add(new OrderModel(o.getCustomOrderId(), o.getCustomer().getNameCustomer(), totalPrice));
        }

        orderTable.setModel(ordersTableModel);
        ordersTableModel.fireTableDataChanged();
    }

    public void fetchAllProducts() {
        allProducts = entityManager.createNamedQuery(Product.getAll).getResultList();

        for (Product p : allProducts) {
            productsTableModel.add(p);
        }

        productsTable.setModel(productsTableModel);
        productsTable.setAutoCreateRowSorter(true);
    }

    @Action
    public void editOrder() {
    }

    @Action
    public void removeOrder() {
        if (orderTable.getSelectedRowCount() != 0) {
            CustomOrder customOrderForRemove = orders.get(orderTable.getSelectedRow());
            orders.remove(customOrderForRemove);
            entityManager.getTransaction().begin();
            entityManager.remove(customOrderForRemove);
            entityManager.getTransaction().commit();


            orders.clear();
            ordersTableModel.clear();
            fetchCustomerOrdersBySellerId();
        }


    }

    @Action
    public void addOrder() {
        addOrderDialog.setEntityManager(entityManager);
        addOrderDialog.initializeData();
        addOrderDialog.setVisible(true);
    }

    @Action
    public void viewOrderDetails() {
        if (orderTable.getSelectedRowCount() != 0) {
            editOrderDialog.setCustomOrderId(orders.get(orderTable.getSelectedRow()).getCustomOrderId());
        }
        editOrderDialog.setVisible(true);
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
