/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MkSavin
 */
@Entity
@Table(name = "types_rights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypesRights.findAll", query = "SELECT t FROM TypesRights t")
    , @NamedQuery(name = "TypesRights.findById", query = "SELECT t FROM TypesRights t WHERE t.id = :id")})
public class TypesRights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "right_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rights rightId;
    @JoinColumn(name = "usertype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UsersTypes usertypeId;

    public TypesRights() {
    }

    public TypesRights(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rights getRightId() {
        return rightId;
    }

    public void setRightId(Rights rightId) {
        this.rightId = rightId;
    }

    public UsersTypes getUsertypeId() {
        return usertypeId;
    }

    public void setUsertypeId(UsersTypes usertypeId) {
        this.usertypeId = usertypeId;
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
        if (!(object instanceof TypesRights)) {
            return false;
        }
        TypesRights other = (TypesRights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TypesRights[ id=" + id + " ]";
    }
    
}
