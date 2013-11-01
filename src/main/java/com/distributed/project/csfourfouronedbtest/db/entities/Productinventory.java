/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.db.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "productinventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productinventory.findAll", query = "SELECT p FROM Productinventory p"),
    @NamedQuery(name = "Productinventory.findByPiId", query = "SELECT p FROM Productinventory p WHERE p.piId = :piId"),
    @NamedQuery(name = "Productinventory.findByInventoryCount", query = "SELECT p FROM Productinventory p WHERE p.inventoryCount = :inventoryCount"),
    @NamedQuery(name = "Productinventory.findByBackOrder", query = "SELECT p FROM Productinventory p WHERE p.backOrder = :backOrder"),
    @NamedQuery(name = "Productinventory.findByDiscontinued", query = "SELECT p FROM Productinventory p WHERE p.discontinued = :discontinued")})
public class Productinventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pi_id")
    private Integer piId;
    @Column(name = "inventory_count")
    private Integer inventoryCount;
    @Column(name = "back_order")
    private Integer backOrder;
    @Column(name = "discontinued")
    private Integer discontinued;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productinventory() {
    }

    public Productinventory(Integer piId) {
        this.piId = piId;
    }

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Integer getBackOrder() {
        return backOrder;
    }

    public void setBackOrder(Integer backOrder) {
        this.backOrder = backOrder;
    }

    public Integer getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Integer discontinued) {
        this.discontinued = discontinued;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (piId != null ? piId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productinventory)) {
            return false;
        }
        Productinventory other = (Productinventory) object;
        if ((this.piId == null && other.piId != null) || (this.piId != null && !this.piId.equals(other.piId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productinventory[ piId=" + piId + " ]";
    }
    
}
