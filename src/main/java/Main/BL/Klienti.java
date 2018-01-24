/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import Main.BL.Users;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    , @NamedQuery(name = "Klienti.findByKlientInfo", query = "SELECT k FROM Klienti k WHERE k.klientInfo = :klientInfo")
    , @NamedQuery(name = "Klienti.findByNrTelefonit", query = "SELECT k FROM Klienti k WHERE k.nrTelefonit = :nrTelefonit")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "nrPersonal")
    private Integer nrPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "klientInfo")
    private String klientInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nrTelefonit")
    private String nrTelefonit;
    @JoinColumn(name = "UserId", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userId;

    public Klienti() {
    }

    public Klienti(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public Klienti(Integer nrPersonal, String klientInfo, String nrTelefonit) {
        this.nrPersonal = nrPersonal;
        this.klientInfo = klientInfo;
        this.nrTelefonit = nrTelefonit;
    }

    public Integer getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public String getKlientInfo() {
        return klientInfo;
    }

    public void setKlientInfo(String klientInfo) {
        this.klientInfo = klientInfo;
    }

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit = nrTelefonit;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
