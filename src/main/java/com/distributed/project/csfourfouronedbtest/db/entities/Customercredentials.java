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
@Table(name = "customercredentials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customercredentials.findAll", query = "SELECT c FROM Customercredentials c"),
    @NamedQuery(name = "Customercredentials.findByCcId", query = "SELECT c FROM Customercredentials c WHERE c.ccId = :ccId"),
    @NamedQuery(name = "Customercredentials.findByCustomerLogin", query = "SELECT c FROM Customercredentials c WHERE c.customerLogin = :customerLogin"),
    @NamedQuery(name = "Customercredentials.findByCustomerPassword", query = "SELECT c FROM Customercredentials c WHERE c.customerPassword = :customerPassword"),
    @NamedQuery(name = "Customercredentials.findByAccountActive", query = "SELECT c FROM Customercredentials c WHERE c.accountActive = :accountActive")})
public class Customercredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cc_id")
    private Integer ccId;
    @Size(max = 45)
    @Column(name = "customer_login")
    private String customerLogin;
    @Size(max = 45)
    @Column(name = "customer_password")
    private String customerPassword;
    @Column(name = "account_active")
    private Integer accountActive;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customerId;

    public Customercredentials() {
    }

    public Customercredentials(Integer ccId) {
        this.ccId = ccId;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Integer getAccountActive() {
        return accountActive;
    }

    public void setAccountActive(Integer accountActive) {
        this.accountActive = accountActive;
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
        hash += (ccId != null ? ccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customercredentials)) {
            return false;
        }
        Customercredentials other = (Customercredentials) object;
        if ((this.ccId == null && other.ccId != null) || (this.ccId != null && !this.ccId.equals(other.ccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Customercredentials[ ccId=" + ccId + " ]";
    }
    
}
