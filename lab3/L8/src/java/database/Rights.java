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
@Table(name = "rights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rights.findAll", query = "SELECT r FROM Rights r")
    , @NamedQuery(name = "Rights.findById", query = "SELECT r FROM Rights r WHERE r.id = :id")})
public class Rights implements Serializable {

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
    @Column(name = "code")
    private String code;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "rightId", fetch = FetchType.EAGER)
    private Collection<TypesRights> typesRightsCollection;

    public Rights() {
    }

    public Rights(Integer id) {
        this.id = id;
    }

    public Rights(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<TypesRights> getTypesRightsCollection() {
        return typesRightsCollection;
    }

    public void setTypesRightsCollection(Collection<TypesRights> typesRightsCollection) {
        this.typesRightsCollection = typesRightsCollection;
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
        if (!(object instanceof Rights)) {
            return false;
        }
        Rights other = (Rights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Rights[ id=" + id + " ]";
    }
    
}
