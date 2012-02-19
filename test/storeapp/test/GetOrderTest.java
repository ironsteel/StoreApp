/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp.test;

import java.util.List;
import javax.persistence.Query;
import com.sun.org.apache.xpath.internal.operations.NotEquals;
import java.util.Collection;
import org.junit.Assert;
import storeapp.entity.Product;
import storeapp.entity.Seller;
import storeapp.entity.Customer;
import javax.persistence.EntityManager;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import storeapp.entity.CustomOrder;
import storeapp.entity.OrderDetail;
import static org.junit.Assert.*;

/**
 *
 * @author dalev
 */
public class GetOrderTest {

    private Map<String, String> properties = new HashMap<String, String>();

    EntityManagerFactory emf;
    EntityManager em;
    private Customer customerOne;
    private Seller sellerOne;
    private CustomOrder order;
    private Product productOne;
    private Product productTwo;
    private OrderDetail detailsOne;
    private OrderDetail detailsTwo;

    @Before
    public void setUp() {
        properties.put("toplink.jdbc.user", "toor");
        properties.put("toplink.jdbc.password", "root");
        properties.put("toplink.jdbc.url", "jdbc:mysql://localhost:3306/storedb");
        properties.put("toplink.jdbc.driver", "com.mysql.jdbc.Driver");
        properties.put("toplink.ddl-generation", "drop-and-create-tables");
        emf = Persistence.createEntityManagerFactory("storedbPU", properties);
        createCustomers();
        createSeller();
        createProducts();
        createOrders();
        createDetails();
    }

    @After
    public void tearDown() {
        emf.close();
    }


     @Test
     public void testGetCustomerFromOrder() {
         CustomOrder retrievedOrder = em.find(CustomOrder.class, order.getCustomOrderId());
         Customer customer = retrievedOrder.getCustomer();
         Assert.assertEquals("Rangel", customer.getNameCustomer());
     }


     @Test
     public void testGetSellerFromOrder() {
         CustomOrder retrievedOrder = em.find(CustomOrder.class, order.getCustomOrderId());
         Seller seller = retrievedOrder.getSeller();
         Assert.assertEquals("Dalev", seller.getNameSeller());
     }

     @Test
     public void testGetOrderDetailsListByOrderId() {
         CustomOrder retrievedOrder = em.find(CustomOrder.class, order.getCustomOrderId());
         Query q = em.createNamedQuery("OrderDetail.getGatAllByCustomerOrderId").setParameter("custom_order_id", retrievedOrder.getCustomOrderId());
         List<OrderDetail> orderDetailsList = q.getResultList();

         assertThat(orderDetailsList.size(), IsNot.not(0));


         OrderDetail orderDetail1 = orderDetailsList.get(0);
         OrderDetail orderDetail2 = orderDetailsList.get(1);


         Assert.assertEquals(productOne.getProductName(), orderDetail1.getProduct().getProductName());
         Assert.assertEquals(productTwo.getProductName(), orderDetail2.getProduct().getProductName());
     }


     private void createCustomers() {
        customerOne = new Customer();
        customerOne.setNameCustomer("Rangel");
        customerOne.setPhoneCustomer("911");
        customerOne.setIban("123456");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(customerOne);
        em.getTransaction().commit();
        
     }
     private void createSeller(){
        sellerOne = new Seller();
        sellerOne.setNameSeller("Dalev");
        sellerOne.setSellerPhone("09912123");
        sellerOne.setPassword("1234");
        em.getTransaction().begin();
        em.persist(sellerOne);
        em.getTransaction().commit();
     }
     private void createProducts(){
         productOne = new Product();
         productOne.setProductName("Vero");
         productOne.setQuantity(11);
         productOne.setUnitPrice(11.5);
         productTwo = new Product();
         productTwo.setProductName("sapun");
         productTwo.setQuantity(434);
         productTwo.setUnitPrice(123.5);
         em.getTransaction().begin();
         em.persist(productOne);
         em.persist(productTwo);
         em.getTransaction().commit();
     }
     private void createOrders() {
         order = new CustomOrder();
         order.setCustomer(customerOne);
         order.setSeller(sellerOne);
         
         em.getTransaction().begin();
         em.persist(order);
         em.getTransaction().commit();

     }
     private void createDetails() {
         detailsOne = new OrderDetail();
         detailsOne.setOrderQuantity(11);
         detailsOne.setCustomOrder(order);
         detailsOne.setProduct(productOne);

         detailsTwo = new OrderDetail();
         detailsTwo.setOrderQuantity(2323);
         detailsTwo.setCustomOrder(order);
         detailsTwo.setProduct(productTwo);

         em.getTransaction().begin();
         em.persist(detailsOne);
         em.persist(detailsTwo);
         em.getTransaction().commit();

     }

}