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
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k")
    , @NamedQuery(name = "Klienti.findByNrPersonal", query = "SELECT k FROM Klienti k WHERE k.nrPersonal = :nrPersonal")
    , @NamedQuery(name = "Klienti.findByEmri", query = "SELECT k FROM Klienti k WHERE k.emri = :emri")
    , @NamedQuery(name = "Klienti.findByMbiemri", query = "SELECT k FROM Klienti k WHERE k.mbiemri = :mbiemri")
    , @NamedQuery(name = "Klienti.findByNrTelefonit", query = "SELECT k FROM Klienti k WHERE k.nrTelefonit = :nrTelefonit")
    , @NamedQuery(name = "Klienti.findByData", query = "SELECT k FROM Klienti k WHERE k.data = :data")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NrPersonal")
    private Integer nrPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NrTelefonit")
    private String nrTelefonit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Data")
    private String data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrPersonal")
    private Collection<Pytesori> pytesoriCollection;

    public Klienti() {
    }

    public Klienti(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public Klienti(Integer nrPersonal, String emri, String mbiemri, String nrTelefonit, String data) {
        this.nrPersonal = nrPersonal;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrTelefonit = nrTelefonit;
        this.data = data;
    }

    public Integer getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit = nrTelefonit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<Pytesori> getPytesoriCollection() {
        return pytesoriCollection;
    }

    public void setPytesoriCollection(Collection<Pytesori> pytesoriCollection) {
        this.pytesoriCollection = pytesoriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrPersonal != null ? nrPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.nrPersonal == null && other.nrPersonal != null) || (this.nrPersonal != null && !this.nrPersonal.equals(other.nrPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Main.BL.Klienti[ nrPersonal=" + nrPersonal + " ]";
    }
    
}
