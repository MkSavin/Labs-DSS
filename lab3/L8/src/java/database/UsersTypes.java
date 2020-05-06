/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author MkSavin
 */
@Entity
@Table(name = "users_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersTypes.findAll", query = "SELECT u FROM UsersTypes u")
    , @NamedQuery(name = "UsersTypes.findById", query = "SELECT u FROM UsersTypes u WHERE u.id = :id")})
public class UsersTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertypeId", fetch = FetchType.EAGER)
    private Collection<TypesRights> typesRightsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertypeId", fetch = FetchType.EAGER)
    private Collection<Users> usersCollection;

    public UsersTypes() {
    }

    public UsersTypes(Integer id) {
        this.id = id;
    }

    public UsersTypes(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<TypesRights> getTypesRightsCollection() {
        return typesRightsCollection;
    }

    public void setTypesRightsCollection(Collection<TypesRights> typesRightsCollection) {
        this.typesRightsCollection = typesRightsCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersTypes)) {
            return false;
        }
        UsersTypes other = (UsersTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.UsersTypes[ id=" + id + " ]";
    }
    
}
