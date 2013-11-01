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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "customercontact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customercontact.findAll", query = "SELECT c FROM Customercontact c"),
    @NamedQuery(name = "Customercontact.findByCconId", query = "SELECT c FROM Customercontact c WHERE c.cconId = :cconId"),
    @NamedQuery(name = "Customercontact.findByCustomerEmail", query = "SELECT c FROM Customercontact c WHERE c.customerEmail = :customerEmail"),
    @NamedQuery(name = "Customercontact.findByCustomerPhoneDay", query = "SELECT c FROM Customercontact c WHERE c.customerPhoneDay = :customerPhoneDay"),
    @NamedQuery(name = "Customercontact.findByCustomerPhoneNight", query = "SELECT c FROM Customercontact c WHERE c.customerPhoneNight = :customerPhoneNight")})
public class Customercontact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ccon_id")
    private Integer cconId;
    @Size(max = 85)
    @Column(name = "customer_email")
    private String customerEmail;
    @Size(max = 45)
    @Column(name = "customer_phone_day")
    private String customerPhoneDay;
    @Size(max = 45)
    @Column(name = "customer_phone_night")
    private String customerPhoneNight;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerId;

    public Customercontact() {
    }

    public Customercontact(Integer cconId) {
        this.cconId = cconId;
    }

    public Integer getCconId() {
        return cconId;
    }

    public void setCconId(Integer cconId) {
        this.cconId = cconId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneDay() {
        return customerPhoneDay;
    }

    public void setCustomerPhoneDay(String customerPhoneDay) {
        this.customerPhoneDay = customerPhoneDay;
    }

    public String getCustomerPhoneNight() {
        return customerPhoneNight;
    }

    public void setCustomerPhoneNight(String customerPhoneNight) {
        this.customerPhoneNight = customerPhoneNight;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cconId != null ? cconId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customercontact)) {
            return false;
        }
        Customercontact other = (Customercontact) object;
        if ((this.cconId == null && other.cconId != null) || (this.cconId != null && !this.cconId.equals(other.cconId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Customercontact[ cconId=" + cconId + " ]";
    }
    
}
