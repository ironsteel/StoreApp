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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dalev
 */
@Entity
@Table(name = "seller")
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
    @NamedQuery(name = "Seller.logIn", query = "SELECT s FROM Seller s where s.nameSeller = :userName AND s.password = :userPassword"),
    @NamedQuery(name = "Seller.logInManager", query = "SELECT s FROM Seller s where s.nameSeller = :userName AND s.password = :userPassword AND s.isManager = :logInAsManager"),
    @NamedQuery(name = "Seller.findBySellerId", query = "SELECT s FROM Seller s WHERE s.sellerId = :sellerId"),
    @NamedQuery(name = "Seller.findByNameSeller", query = "SELECT s FROM Seller s WHERE s.nameSeller = :nameSeller"),
    @NamedQuery(name = "Seller.findByPassword", query = "SELECT s FROM Seller s WHERE s.password = :password"),
    @NamedQuery(name = "Seller.findBySellerPhone", query = "SELECT s FROM Seller s WHERE s.sellerPhone = :sellerPhone"),
    @NamedQuery(name = "Seller.findByIsManager", query = "SELECT s FROM Seller s WHERE s.isManager = :isManager")})
public class Seller implements Serializable {

    public static final String logIn = "Seller.logIn";
    public static final String logInAsManager = "Seller.logInManager";
    public static final String getAllSellers ="Seller.findAll";



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seller_id", nullable = false)
    private Integer sellerId;
    @Basic(optional = false)
    @Column(name = "name_seller", nullable = false, length = 225)
    private String nameSeller;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 225)
    private String password;
    @Basic(optional = false)
    @Column(name = "seller_phone", nullable = false, length = 20)
    private String sellerPhone;
    @Basic(optional = false)
    @Column(name = "is_manager", nullable = false)
    private int isManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private Collection<CustomOrder> customOrderCollection;

    public Seller() {
    }

    public Seller(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Seller(Integer sellerId, String nameSeller, String password, String sellerPhone, int isManager) {
        this.sellerId = sellerId;
        this.nameSeller = nameSeller;
        this.password = password;
        this.sellerPhone = sellerPhone;
        this.isManager = isManager;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    public Collection<CustomOrder> getCustomOrderCollection() {
        return customOrderCollection;
    }

    public void setCustomOrderCollection(Collection<CustomOrder> customOrderCollection) {
        this.customOrderCollection = customOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerId != null ? sellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.sellerId == null && other.sellerId != null) || (this.sellerId != null && !this.sellerId.equals(other.sellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "storeapp.entity.Seller[sellerId=" + sellerId + "]";
    }

}
