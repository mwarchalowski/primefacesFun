/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.db.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "store_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreCategories.findAll", query = "SELECT s FROM StoreCategories s"),
    @NamedQuery(name = "StoreCategories.findByCatId", query = "SELECT s FROM StoreCategories s WHERE s.catId = :catId"),
    @NamedQuery(name = "StoreCategories.findByCatDescription", query = "SELECT s FROM StoreCategories s WHERE s.catDescription = :catDescription"),
    @NamedQuery(name = "StoreCategories.findByCatActive", query = "SELECT s FROM StoreCategories s WHERE s.catActive = :catActive"),
    @NamedQuery(name = "StoreCategories.findByCatSearchable", query = "SELECT s FROM StoreCategories s WHERE s.catSearchable = :catSearchable"),
    @NamedQuery(name = "StoreCategories.findByCatName", query = "SELECT s FROM StoreCategories s WHERE s.catName = :catName")})
public class StoreCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Size(max = 45)
    @Column(name = "cat_description")
    private String catDescription;
    @Lob
    @Column(name = "cat_picture")
    private byte[] catPicture;
    @Column(name = "cat_active")
    private Integer catActive;
    @Size(max = 45)
    @Column(name = "cat_searchable")
    private String catSearchable;
    @Size(max = 45)
    @Column(name = "cat_name")
    private String catName;
    @OneToMany(mappedBy = "catId", fetch = FetchType.LAZY)
    private List<Product> productList;

    public StoreCategories() {
    }

    public StoreCategories(Integer catId) {
        this.catId = catId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public byte[] getCatPicture() {
        return catPicture;
    }

    public void setCatPicture(byte[] catPicture) {
        this.catPicture = catPicture;
    }

    public Integer getCatActive() {
        return catActive;
    }

    public void setCatActive(Integer catActive) {
        this.catActive = catActive;
    }

    public String getCatSearchable() {
        return catSearchable;
    }

    public void setCatSearchable(String catSearchable) {
        this.catSearchable = catSearchable;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreCategories)) {
            return false;
        }
        StoreCategories other = (StoreCategories) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.StoreCategories[ catId=" + catId + " ]";
    }
    
}
