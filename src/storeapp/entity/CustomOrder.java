/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dalev
 */
@Entity
@Table(name = "custom_order")
@NamedQueries({
    @NamedQuery(name = "CustomOrder.findAll", query = "SELECT c FROM CustomOrder c"),
    @NamedQuery(name = "CustomOrder.findByCustomOrderId", query = "SELECT c FROM CustomOrder c WHERE c.customOrderId = :customOrderId")})
public class CustomOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "custom_order_id", nullable = false)
    private Integer customOrderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customOrder")
    private Collection<OrderDetail> orderDetailCollection;
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id", nullable = false)
    @ManyToOne(optional = false)
    private Seller seller;

    public CustomOrder() {
    }

    public CustomOrder(Integer customOrderId) {
        this.customOrderId = customOrderId;
    }

    public Integer getCustomOrderId() {
        return customOrderId;
    }

    public void setCustomOrderId(Integer customOrderId) {
        this.customOrderId = customOrderId;
    }

    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customOrderId != null ? customOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomOrder)) {
            return false;
        }
        CustomOrder other = (CustomOrder) object;
        if ((this.customOrderId == null && other.customOrderId != null) || (this.customOrderId != null && !this.customOrderId.equals(other.customOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storeapp.entity.CustomOrder[customOrderId=" + customOrderId + "]";
    }

}
