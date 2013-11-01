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
@Table(name = "admincredentials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admincredentials.findAll", query = "SELECT a FROM Admincredentials a"),
    @NamedQuery(name = "Admincredentials.findByUacId", query = "SELECT a FROM Admincredentials a WHERE a.uacId = :uacId"),
    @NamedQuery(name = "Admincredentials.findByLogin", query = "SELECT a FROM Admincredentials a WHERE a.login = :login"),
    @NamedQuery(name = "Admincredentials.findByPassword", query = "SELECT a FROM Admincredentials a WHERE a.password = :password"),
    @NamedQuery(name = "Admincredentials.findByActive", query = "SELECT a FROM Admincredentials a WHERE a.active = :active")})
public class Admincredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uac_id")
    private Integer uacId;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Integer active;
    @JoinColumn(name = "ua_id", referencedColumnName = "ua_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Useradmin uaId;

    public Admincredentials() {
    }

    public Admincredentials(Integer uacId) {
        this.uacId = uacId;
    }

    public Integer getUacId() {
        return uacId;
    }

    public void setUacId(Integer uacId) {
        this.uacId = uacId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Useradmin getUaId() {
        return uaId;
    }

    public void setUaId(Useradmin uaId) {
        this.uaId = uaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uacId != null ? uacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admincredentials)) {
            return false;
        }
        Admincredentials other = (Admincredentials) object;
        if ((this.uacId == null && other.uacId != null) || (this.uacId != null && !this.uacId.equals(other.uacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Admincredentials[ uacId=" + uacId + " ]";
    }
    
}
