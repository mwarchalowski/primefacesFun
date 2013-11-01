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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "productdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productdetail.findAll", query = "SELECT p FROM Productdetail p"),
    @NamedQuery(name = "Productdetail.findByPdId", query = "SELECT p FROM Productdetail p WHERE p.pdId = :pdId"),
    @NamedQuery(name = "Productdetail.findByProductDescrShort", query = "SELECT p FROM Productdetail p WHERE p.productDescrShort = :productDescrShort"),
    @NamedQuery(name = "Productdetail.findByProductColor", query = "SELECT p FROM Productdetail p WHERE p.productColor = :productColor")})
public class Productdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pd_id")
    private Integer pdId;
    @Lob
    @Size(max = 65535)
    @Column(name = "product_descr")
    private String productDescr;
    @Size(max = 100)
    @Column(name = "product_descr_short")
    private String productDescrShort;
    @Size(max = 45)
    @Column(name = "product_color")
    private String productColor;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productdetail() {
    }

    public Productdetail(Integer pdId) {
        this.pdId = pdId;
    }

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public String getProductDescr() {
        return productDescr;
    }

    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }

    public String getProductDescrShort() {
        return productDescrShort;
    }

    public void setProductDescrShort(String productDescrShort) {
        this.productDescrShort = productDescrShort;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
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
        hash += (pdId != null ? pdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productdetail)) {
            return false;
        }
        Productdetail other = (Productdetail) object;
        if ((this.pdId == null && other.pdId != null) || (this.pdId != null && !this.pdId.equals(other.pdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productdetail[ pdId=" + pdId + " ]";
    }
    
}
