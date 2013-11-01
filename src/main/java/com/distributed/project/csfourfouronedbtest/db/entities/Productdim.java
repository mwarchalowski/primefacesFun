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
@Table(name = "productdim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productdim.findAll", query = "SELECT p FROM Productdim p"),
    @NamedQuery(name = "Productdim.findByPdmId", query = "SELECT p FROM Productdim p WHERE p.pdmId = :pdmId"),
    @NamedQuery(name = "Productdim.findByProductHeight", query = "SELECT p FROM Productdim p WHERE p.productHeight = :productHeight"),
    @NamedQuery(name = "Productdim.findByProductWidth", query = "SELECT p FROM Productdim p WHERE p.productWidth = :productWidth"),
    @NamedQuery(name = "Productdim.findByProductLength", query = "SELECT p FROM Productdim p WHERE p.productLength = :productLength")})
public class Productdim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pdm_id")
    private Integer pdmId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_height")
    private Float productHeight;
    @Column(name = "product_width")
    private Float productWidth;
    @Column(name = "product_length")
    private Float productLength;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productdim() {
    }

    public Productdim(Integer pdmId) {
        this.pdmId = pdmId;
    }

    public Integer getPdmId() {
        return pdmId;
    }

    public void setPdmId(Integer pdmId) {
        this.pdmId = pdmId;
    }

    public Float getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Float productHeight) {
        this.productHeight = productHeight;
    }

    public Float getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Float productWidth) {
        this.productWidth = productWidth;
    }

    public Float getProductLength() {
        return productLength;
    }

    public void setProductLength(Float productLength) {
        this.productLength = productLength;
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
        hash += (pdmId != null ? pdmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productdim)) {
            return false;
        }
        Productdim other = (Productdim) object;
        if ((this.pdmId == null && other.pdmId != null) || (this.pdmId != null && !this.pdmId.equals(other.pdmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productdim[ pdmId=" + pdmId + " ]";
    }
    
}
