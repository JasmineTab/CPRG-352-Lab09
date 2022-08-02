package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByRID", query = "SELECT r FROM Role r WHERE r.rID = :rID")
    , @NamedQuery(name = "Role.findByRName", query = "SELECT r FROM Role r WHERE r.rName = :rName")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer rID;
    @Basic(optional = false)
    @Column(name = "role_name")
    private String rName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> uList;


    public Role() {
    }
    
    public Role(Integer rID){
        this.rID = rID;
    }

    public Role(Integer rID, String rName) {
        this.rID = rID;
        this.rName = rName;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }
    
    
    @XmlTransient
    public List<User> getUList() {
        return uList;
    }

    public void setUList(List<User> uList) {
        this.uList = uList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rID!= null ? rID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.rID == null && other.rID != null) || (this.rID != null && !this.rID.equals(other.rID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Role[ rID=" + rID + " ]";
    }
    
}
