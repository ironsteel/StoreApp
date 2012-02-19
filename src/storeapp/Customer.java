/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package storeapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rangel Ivanov Iron_steel_88@abv.bg
 */
@Entity
@Table(name = "customer", catalog = "storedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByIdCustomer", query = "SELECT c FROM Customer c WHERE c.idCustomer = :idCustomer"),
    @NamedQuery(name = "Customer.findByNameCustomer", query = "SELECT c FROM Customer c WHERE c.nameCustomer = :nameCustomer"),
    @NamedQuery(name = "Customer.findByPhoneCustomer", query = "SELECT c FROM Customer c WHERE c.phoneCustomer = :phoneCustomer"),
    @NamedQuery(name = "Customer.findByIban", query = "SELECT c FROM Customer c WHERE c.iban = :iban")})
public class Customer implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Basic(optional = false)
    @Column(name = "name_customer")
    private String nameCustomer;
    @Basic(optional = false)
    @Column(name = "phone_customer")
    private String phoneCustomer;
    @Column(name = "IBAN")
    private String iban;

    public Customer() {
    }

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(Integer idCustomer, String nameCustomer, String phoneCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phoneCustomer = phoneCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        Integer oldIdCustomer = this.idCustomer;
        this.idCustomer = idCustomer;
        changeSupport.firePropertyChange("idCustomer", oldIdCustomer, idCustomer);
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        String oldNameCustomer = this.nameCustomer;
        this.nameCustomer = nameCustomer;
        changeSupport.firePropertyChange("nameCustomer", oldNameCustomer, nameCustomer);
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        String oldPhoneCustomer = this.phoneCustomer;
        this.phoneCustomer = phoneCustomer;
        changeSupport.firePropertyChange("phoneCustomer", oldPhoneCustomer, phoneCustomer);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        String oldIban = this.iban;
        this.iban = iban;
        changeSupport.firePropertyChange("iban", oldIban, iban);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storeapp.Customer[idCustomer=" + idCustomer + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
