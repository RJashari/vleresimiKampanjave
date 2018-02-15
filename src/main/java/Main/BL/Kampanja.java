/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Kampanja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kampanja.findAll", query = "SELECT k FROM Kampanja k")
    , @NamedQuery(name = "Kampanja.findByKampanjaID", query = "SELECT k FROM Kampanja k WHERE k.kampanjaID = :kampanjaID")
    , @NamedQuery(name = "Kampanja.findByEmri", query = "SELECT k FROM Kampanja k WHERE k.emri = :emri")})
public class Kampanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "kampanjaID")
    private Integer kampanjaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emri")
    private String emri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kampanja")
    private Collection<Klienti> klientiCollection;

    public Kampanja() {
    }

    public Kampanja(Integer kampanjaID) {
        this.kampanjaID = kampanjaID;
    }

    public Kampanja(Integer kampanjaID, String emri) {
        this.kampanjaID = kampanjaID;
        this.emri = emri;
    }

    public Integer getKampanjaID() {
        return kampanjaID;
    }

    public void setKampanjaID(Integer kampanjaID) {
        this.kampanjaID = kampanjaID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kampanjaID != null ? kampanjaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kampanja)) {
            return false;
        }
        Kampanja other = (Kampanja) object;
        if ((this.kampanjaID == null && other.kampanjaID != null) || (this.kampanjaID != null && !this.kampanjaID.equals(other.kampanjaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Main.BL.Kampanja[ kampanjaID=" + kampanjaID + " ]";
    }
    
}
