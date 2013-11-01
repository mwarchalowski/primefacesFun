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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByMiddleName", query = "SELECT c FROM Customer c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByGender", query = "SELECT c FROM Customer c WHERE c.gender = :gender")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 45)
    @Column(name = "middle_name")
    private String middleName;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 45)
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Shippingaddress> shippingaddressList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Customercredentials> customercredentialsList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Billingaddress> billingaddressList;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<Customercontact> customercontactList;
    @OneToMany(mappedBy = "orderCustomer", fetch = FetchType.LAZY)
    private List<Order1> order1List;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlTransient
    public List<Shippingaddress> getShippingaddressList() {
        return shippingaddressList;
    }

    public void setShippingaddressList(List<Shippingaddress> shippingaddressList) {
        this.shippingaddressList = shippingaddressList;
    }

    @XmlTransient
    public List<Customercredentials> getCustomercredentialsList() {
        return customercredentialsList;
    }

    public void setCustomercredentialsList(List<Customercredentials> customercredentialsList) {
        this.customercredentialsList = customercredentialsList;
    }

    @XmlTransient
    public List<Billingaddress> getBillingaddressList() {
        return billingaddressList;
    }

    public void setBillingaddressList(List<Billingaddress> billingaddressList) {
        this.billingaddressList = billingaddressList;
    }

    @XmlTransient
    public List<Customercontact> getCustomercontactList() {
        return customercontactList;
    }

    public void setCustomercontactList(List<Customercontact> customercontactList) {
        this.customercontactList = customercontactList;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Customer[ customerId=" + customerId + " ]";
    }
    
}
