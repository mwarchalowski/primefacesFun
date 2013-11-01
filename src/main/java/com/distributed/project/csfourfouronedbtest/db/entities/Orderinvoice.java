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
@Table(name = "orderinvoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderinvoice.findAll", query = "SELECT o FROM Orderinvoice o"),
    @NamedQuery(name = "Orderinvoice.findByOiId", query = "SELECT o FROM Orderinvoice o WHERE o.oiId = :oiId"),
    @NamedQuery(name = "Orderinvoice.findByInvoiceDate", query = "SELECT o FROM Orderinvoice o WHERE o.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "Orderinvoice.findByInvoiceStatus", query = "SELECT o FROM Orderinvoice o WHERE o.invoiceStatus = :invoiceStatus"),
    @NamedQuery(name = "Orderinvoice.findByInvoiceAmount", query = "SELECT o FROM Orderinvoice o WHERE o.invoiceAmount = :invoiceAmount")})
public class Orderinvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oi_id")
    private Integer oiId;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Size(max = 45)
    @Column(name = "invoice_status")
    private String invoiceStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "invoice_amount")
    private Float invoiceAmount;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order1 orderId;

    public Orderinvoice() {
    }

    public Orderinvoice(Integer oiId) {
        this.oiId = oiId;
    }

    public Integer getOiId() {
        return oiId;
    }

    public void setOiId(Integer oiId) {
        this.oiId = oiId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Float getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Float invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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
        hash += (oiId != null ? oiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderinvoice)) {
            return false;
        }
        Orderinvoice other = (Orderinvoice) object;
        if ((this.oiId == null && other.oiId != null) || (this.oiId != null && !this.oiId.equals(other.oiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Orderinvoice[ oiId=" + oiId + " ]";
    }
    
}
