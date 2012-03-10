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
    private double sumPrice;

    public OrderModel(int orderId, String customerName, double sumPrice) {
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

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
