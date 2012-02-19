/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dalev
 */
@Entity
@Table(name = "order_detail")
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrderId", query = "SELECT o FROM OrderDetail o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderDetail.getGatAllByCustomerOrderId", query = "SELECT o FROM OrderDetail o WHERE o.customOrder.customOrderId = :custom_order_id"),
    @NamedQuery(name = "OrderDetail.findByOrderQuantity", query = "SELECT o FROM OrderDetail o WHERE o.orderQuantity = :orderQuantity")})
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "order_quantity", nullable = false)
    private double orderQuantity;
    @JoinColumn(name = "custom_order_id", referencedColumnName = "custom_order_id", nullable = false)
    @ManyToOne(optional = false)
    private CustomOrder customOrder;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderDetail(Integer orderId, double orderQuantity) {
        this.orderId = orderId;
        this.orderQuantity = orderQuantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public CustomOrder getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(CustomOrder customOrder) {
        this.customOrder = customOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storeapp.entity.OrderDetail[orderId=" + orderId + "]";
    }

}
