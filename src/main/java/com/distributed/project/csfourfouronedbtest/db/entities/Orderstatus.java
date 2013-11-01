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
@Table(name = "orderstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderstatus.findAll", query = "SELECT o FROM Orderstatus o"),
    @NamedQuery(name = "Orderstatus.findByOsId", query = "SELECT o FROM Orderstatus o WHERE o.osId = :osId"),
    @NamedQuery(name = "Orderstatus.findByStatusDate", query = "SELECT o FROM Orderstatus o WHERE o.statusDate = :statusDate"),
    @NamedQuery(name = "Orderstatus.findByStatus", query = "SELECT o FROM Orderstatus o WHERE o.status = :status")})
public class Orderstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "os_id")
    private Integer osId;
    @Column(name = "status_date")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    @Lob
    @Size(max = 65535)
    @Column(name = "status_comments")
    private String statusComments;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order1 orderId;

    public Orderstatus() {
    }

    public Orderstatus(Integer osId) {
        this.osId = osId;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusComments() {
        return statusComments;
    }

    public void setStatusComments(String statusComments) {
        this.statusComments = statusComments;
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
        hash += (osId != null ? osId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderstatus)) {
            return false;
        }
        Orderstatus other = (Orderstatus) object;
        if ((this.osId == null && other.osId != null) || (this.osId != null && !this.osId.equals(other.osId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Orderstatus[ osId=" + osId + " ]";
    }
    
}
