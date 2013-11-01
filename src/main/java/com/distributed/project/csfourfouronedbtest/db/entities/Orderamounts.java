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
@Table(name = "orderamounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderamounts.findAll", query = "SELECT o FROM Orderamounts o"),
    @NamedQuery(name = "Orderamounts.findByOaId", query = "SELECT o FROM Orderamounts o WHERE o.oaId = :oaId"),
    @NamedQuery(name = "Orderamounts.findByOrderTotal", query = "SELECT o FROM Orderamounts o WHERE o.orderTotal = :orderTotal"),
    @NamedQuery(name = "Orderamounts.findByOrderSubtotal", query = "SELECT o FROM Orderamounts o WHERE o.orderSubtotal = :orderSubtotal"),
    @NamedQuery(name = "Orderamounts.findByOrderShipping", query = "SELECT o FROM Orderamounts o WHERE o.orderShipping = :orderShipping")})
public class Orderamounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oa_id")
    private Integer oaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_total")
    private Float orderTotal;
    @Column(name = "order_subtotal")
    private Float orderSubtotal;
    @Column(name = "order_shipping")
    private Float orderShipping;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order1 orderId;

    public Orderamounts() {
    }

    public Orderamounts(Integer oaId) {
        this.oaId = oaId;
    }

    public Integer getOaId() {
        return oaId;
    }

    public void setOaId(Integer oaId) {
        this.oaId = oaId;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Float getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(Float orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public Float getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(Float orderShipping) {
        this.orderShipping = orderShipping;
    }

    public Order1 getOrderId() {
        return orderId;
    }

    public void setOrderId(Order1 orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oaId != null ? oaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderamounts)) {
            return false;
        }
        Orderamounts other = (Orderamounts) object;
        if ((this.oaId == null && other.oaId != null) || (this.oaId != null && !this.oaId.equals(other.oaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Orderamounts[ oaId=" + oaId + " ]";
    }
    
}
