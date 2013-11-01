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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductSku", query = "SELECT p FROM Product p WHERE p.productSku = :productSku"),
    @NamedQuery(name = "Product.findByProductDescr", query = "SELECT p FROM Product p WHERE p.productDescr = :productDescr")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Size(max = 45)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 45)
    @Column(name = "product_sku")
    private String productSku;
    @Size(max = 45)
    @Column(name = "product_descr")
    private String productDescr;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productshippingprops> productshippingpropsList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productprices> productpricesList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Orderitems> orderitemsList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productdim> productdimList;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StoreCategories catId;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productdetail> productdetailList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productinventory> productinventoryList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Productcustomattr> productcustomattrList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductDescr() {
        return productDescr;
    }

    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }

    @XmlTransient
    public List<Productshippingprops> getProductshippingpropsList() {
        return productshippingpropsList;
    }

    public void setProductshippingpropsList(List<Productshippingprops> productshippingpropsList) {
        this.productshippingpropsList = productshippingpropsList;
    }

    @XmlTransient
    public List<Productprices> getProductpricesList() {
        return productpricesList;
    }

    public void setProductpricesList(List<Productprices> productpricesList) {
        this.productpricesList = productpricesList;
    }

    @XmlTransient
    public List<Orderitems> getOrderitemsList() {
        return orderitemsList;
    }

    public void setOrderitemsList(List<Orderitems> orderitemsList) {
        this.orderitemsList = orderitemsList;
    }

    @XmlTransient
    public List<Productdim> getProductdimList() {
        return productdimList;
    }

    public void setProductdimList(List<Productdim> productdimList) {
        this.productdimList = productdimList;
    }

    public StoreCategories getCatId() {
        return catId;
    }

    public void setCatId(StoreCategories catId) {
        this.catId = catId;
    }

    @XmlTransient
    public List<Productdetail> getProductdetailList() {
        return productdetailList;
    }

    public void setProductdetailList(List<Productdetail> productdetailList) {
        this.productdetailList = productdetailList;
    }

    @XmlTransient
    public List<Productinventory> getProductinventoryList() {
        return productinventoryList;
    }

    public void setProductinventoryList(List<Productinventory> productinventoryList) {
        this.productinventoryList = productinventoryList;
    }

    @XmlTransient
    public List<Productcustomattr> getProductcustomattrList() {
        return productcustomattrList;
    }

    public void setProductcustomattrList(List<Productcustomattr> productcustomattrList) {
        this.productcustomattrList = productcustomattrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Product[ productId=" + productId + " ]";
    }
    
}
