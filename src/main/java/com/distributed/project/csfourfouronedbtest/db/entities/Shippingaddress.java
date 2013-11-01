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
@Table(name = "shippingaddress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippingaddress.findAll", query = "SELECT s FROM Shippingaddress s"),
    @NamedQuery(name = "Shippingaddress.findBySaId", query = "SELECT s FROM Shippingaddress s WHERE s.saId = :saId"),
    @NamedQuery(name = "Shippingaddress.findByAddr1", query = "SELECT s FROM Shippingaddress s WHERE s.addr1 = :addr1"),
    @NamedQuery(name = "Shippingaddress.findByAddr2", query = "SELECT s FROM Shippingaddress s WHERE s.addr2 = :addr2"),
    @NamedQuery(name = "Shippingaddress.findByCity", query = "SELECT s FROM Shippingaddress s WHERE s.city = :city"),
    @NamedQuery(name = "Shippingaddress.findByState", query = "SELECT s FROM Shippingaddress s WHERE s.state = :state"),
    @NamedQuery(name = "Shippingaddress.findByZip", query = "SELECT s FROM Shippingaddress s WHERE s.zip = :zip")})
public class Shippingaddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sa_id")
    private Integer saId;
    @Size(max = 80)
    @Column(name = "addr1")
    private String addr1;
    @Size(max = 80)
    @Column(name = "addr2")
    private String addr2;
    @Size(max = 80)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "zip")
    private String zip;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerId;

    public Shippingaddress() {
    }

    public Shippingaddress(Integer saId) {
        this.saId = saId;
    }

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
        hash += (saId != null ? saId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippingaddress)) {
            return false;
        }
        Shippingaddress other = (Shippingaddress) object;
        if ((this.saId == null && other.saId != null) || (this.saId != null && !this.saId.equals(other.saId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Shippingaddress[ saId=" + saId + " ]";
    }
    
}
