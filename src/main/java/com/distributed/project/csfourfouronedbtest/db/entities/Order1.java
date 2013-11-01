/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.db.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Order1.findByOrderNumber", query = "SELECT o FROM Order1 o WHERE o.orderNumber = :orderNumber"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByOrderTotal", query = "SELECT o FROM Order1 o WHERE o.orderTotal = :orderTotal")})
public class Order1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_number")
    private Integer orderNumber;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_total")
    private Float orderTotal;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<Orderstatus> orderstatusList;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<Orderdetails> orderdetailsList;
    @OneToMany(mappedBy = "orderNumber", fetch = FetchType.LAZY)
    private List<Orderitems> orderitemsList;
    @JoinColumn(name = "order_customer", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer orderCustomer;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<Orderinvoice> orderinvoiceList;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<Orderamounts> orderamountsList;

    public Order1() {
    }

    public Order1(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    @XmlTransient
    public List<Orderstatus> getOrderstatusList() {
        return orderstatusList;
    }

    public void setOrderstatusList(List<Orderstatus> orderstatusList) {
        this.orderstatusList = orderstatusList;
    }

    @XmlTransient
    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @XmlTransient
    public List<Orderitems> getOrderitemsList() {
        return orderitemsList;
    }

    public void setOrderitemsList(List<Orderitems> orderitemsList) {
        this.orderitemsList = orderitemsList;
    }

    public Customer getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(Customer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    @XmlTransient
    public List<Orderinvoice> getOrderinvoiceList() {
        return orderinvoiceList;
    }

    public void setOrderinvoiceList(List<Orderinvoice> orderinvoiceList) {
        this.orderinvoiceList = orderinvoiceList;
    }

    @XmlTransient
    public List<Orderamounts> getOrderamountsList() {
        return orderamountsList;
    }

    public void setOrderamountsList(List<Orderamounts> orderamountsList) {
        this.orderamountsList = orderamountsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Order1[ orderId=" + orderId + " ]";
    }
    
}
