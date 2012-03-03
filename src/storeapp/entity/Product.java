/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author dalev
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByInStock", query = "SELECT p FROM Product p WHERE p.inStock = :inStock"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByUnitPrice", query = "SELECT p FROM Product p WHERE p.unitPrice = :unitPrice")})
public class Product implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "in_stock", nullable = false)
    private int inStock;
    @Basic(optional = false)
    @Column(name = "product_name", nullable = false, length = 225)
    private String productName;
    @Basic(optional = false)
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Basic(optional = false)
    @Column(name = "unit_price", nullable = false)
    private double unitPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<OrderDetail> orderDetailCollection;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, int inStock, String productName, double quantity, double unitPrice) {
        this.productId = productId;
        this.inStock = inStock;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        Integer oldProductId = this.productId;
        this.productId = productId;
        changeSupport.firePropertyChange("productId", oldProductId, productId);
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        int oldInStock = this.inStock;
        this.inStock = inStock;
        changeSupport.firePropertyChange("inStock", oldInStock, inStock);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        double oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        double oldUnitPrice = this.unitPrice;
        this.unitPrice = unitPrice;
        changeSupport.firePropertyChange("unitPrice", oldUnitPrice, unitPrice);
    }

    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storeapp.entity.Product[productId=" + productId + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
