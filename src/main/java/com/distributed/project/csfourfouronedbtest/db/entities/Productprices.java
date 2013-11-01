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
@Table(name = "productprices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productprices.findAll", query = "SELECT p FROM Productprices p"),
    @NamedQuery(name = "Productprices.findByPpId", query = "SELECT p FROM Productprices p WHERE p.ppId = :ppId"),
    @NamedQuery(name = "Productprices.findByProducPrice", query = "SELECT p FROM Productprices p WHERE p.producPrice = :producPrice"),
    @NamedQuery(name = "Productprices.findBySpecialPrice", query = "SELECT p FROM Productprices p WHERE p.specialPrice = :specialPrice"),
    @NamedQuery(name = "Productprices.findByProductCost", query = "SELECT p FROM Productprices p WHERE p.productCost = :productCost")})
public class Productprices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pp_id")
    private Integer ppId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produc_price")
    private Float producPrice;
    @Column(name = "special_price")
    private Float specialPrice;
    @Column(name = "product_cost")
    private Float productCost;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productprices() {
    }

    public Productprices(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Float getProducPrice() {
        return producPrice;
    }

    public void setProducPrice(Float producPrice) {
        this.producPrice = producPrice;
    }

    public Float getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Float specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Float getProductCost() {
        return productCost;
    }

    public void setProductCost(Float productCost) {
        this.productCost = productCost;
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
        hash += (ppId != null ? ppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productprices)) {
            return false;
        }
        Productprices other = (Productprices) object;
        if ((this.ppId == null && other.ppId != null) || (this.ppId != null && !this.ppId.equals(other.ppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productprices[ ppId=" + ppId + " ]";
    }
    
}
