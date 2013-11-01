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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "productcustomattr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productcustomattr.findAll", query = "SELECT p FROM Productcustomattr p"),
    @NamedQuery(name = "Productcustomattr.findByPcaId", query = "SELECT p FROM Productcustomattr p WHERE p.pcaId = :pcaId"),
    @NamedQuery(name = "Productcustomattr.findByManufacturer", query = "SELECT p FROM Productcustomattr p WHERE p.manufacturer = :manufacturer"),
    @NamedQuery(name = "Productcustomattr.findByArrivalDate", query = "SELECT p FROM Productcustomattr p WHERE p.arrivalDate = :arrivalDate")})
public class Productcustomattr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pca_id")
    private Integer pcaId;
    @Size(max = 45)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Lob
    @Column(name = "product_image")
    private byte[] productImage;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product productId;

    public Productcustomattr() {
    }

    public Productcustomattr(Integer pcaId) {
        this.pcaId = pcaId;
    }

    public Integer getPcaId() {
        return pcaId;
    }

    public void setPcaId(Integer pcaId) {
        this.pcaId = pcaId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
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
        hash += (pcaId != null ? pcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcustomattr)) {
            return false;
        }
        Productcustomattr other = (Productcustomattr) object;
        if ((this.pcaId == null && other.pcaId != null) || (this.pcaId != null && !this.pcaId.equals(other.pcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Productcustomattr[ pcaId=" + pcaId + " ]";
    }
    
}
