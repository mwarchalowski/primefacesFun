/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.db.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "orderitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitems.findAll", query = "SELECT o FROM Orderitems o"),
    @NamedQuery(name = "Orderitems.findByOi", query = "SELECT o FROM Orderitems o WHERE o.oi = :oi"),
    @NamedQuery(name = "Orderitems.findByDateCreated", query = "SELECT o FROM Orderitems o WHERE o.dateCreated = :dateCreated")})
public class Orderitems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oi")
    private Integer oi;
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;
    @JoinColumn(name = "order_number", referencedColumnName = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order1 orderNumber;

    public Orderitems() {
    }

    public Orderitems(Integer oi) {
        this.oi = oi;
    }

    public Integer getOi() {
        return oi;
    }

    public void setOi(Integer oi) {
        this.oi = oi;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Order1 getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Order1 orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oi != null ? oi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderitems)) {
            return false;
        }
        Orderitems other = (Orderitems) object;
        if ((this.oi == null && other.oi != null) || (this.oi != null && !this.oi.equals(other.oi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Orderitems[ oi=" + oi + " ]";
    }
    
}
