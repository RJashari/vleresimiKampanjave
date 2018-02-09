/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author rinor.jashari
 */
@Entity
@Table(name = "Dega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dega.findAll", query = "SELECT d FROM Dega d")
    , @NamedQuery(name = "Dega.findByDegaID", query = "SELECT d FROM Dega d WHERE d.degaID = :degaID")
    , @NamedQuery(name = "Dega.findByEmri", query = "SELECT d FROM Dega d WHERE d.emri = :emri")})
public class Dega implements Serializable {

    @OneToMany(mappedBy = "degaID")
    private Collection<Users> usersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "degaID")
    @NotNull
    private Integer degaID;
    @Size(max = 50)
    @Column(name = "emri")
    private String emri;

    public Dega() {
    }

    public Dega(Integer degaID) {
        this.degaID = degaID;
    }

    public Integer getDegaID() {
        return degaID;
    }

    public void setDegaID(Integer degaID) {
        this.degaID = degaID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (degaID != null ? degaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dega)) {
            return false;
        }
        Dega other = (Dega) object;
        if ((this.degaID == null && other.degaID != null) || (this.degaID != null && !this.degaID.equals(other.degaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Main.BL.Dega[ degaID=" + degaID + " ]";
        return emri;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }
    
}
