/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rinor.jashari
 */
@Entity
@Table(name = "RaportUserKlient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RaportUserKlient.findAll", query = "SELECT r FROM RaportUserKlient r")
    , @NamedQuery(name = "RaportUserKlient.findByRaportID", query = "SELECT r FROM RaportUserKlient r WHERE r.raportID = :raportID")})
public class RaportUserKlient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RaportID")
    private Integer raportID;
    @JoinColumn(name = "nrPersonal", referencedColumnName = "nrPersonal")
    @ManyToOne(optional = false)
    private Klienti nrPersonal;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public RaportUserKlient() {
    }

    public RaportUserKlient(Integer raportID) {
        this.raportID = raportID;
    }

    public Integer getRaportID() {
        return raportID;
    }

    public void setRaportID(Integer raportID) {
        this.raportID = raportID;
    }

    public Klienti getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(Klienti nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raportID != null ? raportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaportUserKlient)) {
            return false;
        }
        RaportUserKlient other = (RaportUserKlient) object;
        if ((this.raportID == null && other.raportID != null) || (this.raportID != null && !this.raportID.equals(other.raportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.RaportUserKlient[ raportID=" + raportID + " ]";
    }
    
}
