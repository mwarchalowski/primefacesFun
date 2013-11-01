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
@Table(name = "orderdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findByOdId", query = "SELECT o FROM Orderdetails o WHERE o.odId = :odId"),
    @NamedQuery(name = "Orderdetails.findByOrderIp", query = "SELECT o FROM Orderdetails o WHERE o.orderIp = :orderIp"),
    @NamedQuery(name = "Orderdetails.findByOrderTaxRate", query = "SELECT o FROM Orderdetails o WHERE o.orderTaxRate = :orderTaxRate")})
public class Orderdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "od_id")
    private Integer odId;
    @Lob
    @Size(max = 65535)
    @Column(name = "order_comments")
    private String orderComments;
    @Size(max = 45)
    @Column(name = "order_ip")
    private String orderIp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_tax_rate")
    private Float orderTaxRate;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order1 orderId;

    public Orderdetails() {
    }

    public Orderdetails(Integer odId) {
        this.odId = odId;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    public String getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp;
    }

    public Float getOrderTaxRate() {
        return orderTaxRate;
    }

    public void setOrderTaxRate(Float orderTaxRate) {
        this.orderTaxRate = orderTaxRate;
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
        hash += (odId != null ? odId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.odId == null && other.odId != null) || (this.odId != null && !this.odId.equals(other.odId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Orderdetails[ odId=" + odId + " ]";
    }
    
}
