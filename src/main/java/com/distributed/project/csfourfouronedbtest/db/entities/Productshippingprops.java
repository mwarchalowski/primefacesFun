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
@Table(name = "productshippingprops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productshippingprops.findAll", query = "SELECT p FROM Productshippingprops p"),
    @NamedQuery(name = "Productshippingprops.findByPspId", query = "SELECT p FROM Productshippingprops p WHERE p.pspId = :pspId"),
    @NamedQuery(name = "Productshippingprops.findByFreeShipping", query = "SELECT p FROM Productshippingprops p WHERE p.freeShipping = :freeShipping"),
    @NamedQuery(name = "Productshippingprops.findByShippingWeight", query = "SELECT p FROM Productshippingprops p WHERE p.shippingWeight = :shippingWeight"),
    @NamedQuery(name = "Productshippingprops.findByShipable", query = "SELECT p FROM Productshippingprops p WHERE p.shipable = :shipable")})
public class Productshippingprops implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "psp_id")
    private Integer pspId;
    @Column(name = "free_shipping")
    private Integer freeShipping;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "shipping_weight")
    private Float shippingWeight;
    @Column(name = "shipable")
    private Integer shipable;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productshippingprops() {
    }

    public Productshippingprops(Integer pspId) {
        this.pspId = pspId;
    }

    public Integer getPspId() {
        return pspId;
    }

    public void setPspId(Integer pspId) {
        this.pspId = pspId;
    }

    public Integer getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Integer freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Float getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(Float shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public Integer getShipable() {
        return shipable;
    }

    public void setShipable(Integer shipable) {
        this.shipable = shipable;
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
        hash += (pspId != null ? pspId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productshippingprops)) {
            return false;
        }
        Productshippingprops other = (Productshippingprops) object;
        if ((this.pspId == null && other.pspId != null) || (this.pspId != null && !this.pspId.equals(other.pspId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productshippingprops[ pspId=" + pspId + " ]";
    }
    
}
