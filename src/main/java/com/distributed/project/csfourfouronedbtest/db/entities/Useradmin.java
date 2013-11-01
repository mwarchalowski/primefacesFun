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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author punker
 */
@Entity
@Table(name = "useradmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useradmin.findAll", query = "SELECT u FROM Useradmin u"),
    @NamedQuery(name = "Useradmin.findByUaId", query = "SELECT u FROM Useradmin u WHERE u.uaId = :uaId"),
    @NamedQuery(name = "Useradmin.findByFirstName", query = "SELECT u FROM Useradmin u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Useradmin.findByMiddleName", query = "SELECT u FROM Useradmin u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "Useradmin.findByLastName", query = "SELECT u FROM Useradmin u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Useradmin.findByDisplayName", query = "SELECT u FROM Useradmin u WHERE u.displayName = :displayName")})
public class Useradmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ua_id")
    private Integer uaId;
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
    @Column(name = "display_name")
    private String displayName;
    @OneToMany(mappedBy = "uaId", fetch = FetchType.LAZY)
    private List<Admincredentials> admincredentialsList;

    public Useradmin() {
    }

    public Useradmin(Integer uaId) {
        this.uaId = uaId;
    }

    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlTransient
    public List<Admincredentials> getAdmincredentialsList() {
        return admincredentialsList;
    }

    public void setAdmincredentialsList(List<Admincredentials> admincredentialsList) {
        this.admincredentialsList = admincredentialsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uaId != null ? uaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useradmin)) {
            return false;
        }
        Useradmin other = (Useradmin) object;
        if ((this.uaId == null && other.uaId != null) || (this.uaId != null && !this.uaId.equals(other.uaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distributed.project.csfourfouronedbtest.db.entities.Useradmin[ uaId=" + uaId + " ]";
    }
    
}
