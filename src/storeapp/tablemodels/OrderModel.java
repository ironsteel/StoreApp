/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storeapp.tablemodels;

/**
 *
 * @author Rangel Ivanov Iron_steel_88@abv.bg
 */
public class OrderModel {

    private int orderId;
    private String customerName;
    private float sumPrice;

    public OrderModel(int orderId, String customerName, float sumPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.sumPrice = sumPrice;
    }


   

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }
}
