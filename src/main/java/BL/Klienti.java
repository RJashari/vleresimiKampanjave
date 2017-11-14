/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

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
    , @NamedQuery(name = "Klienti.findByPytja1TV", query = "SELECT k FROM Klienti k WHERE k.pytja1TV = :pytja1TV")
    , @NamedQuery(name = "Klienti.findByPytja1Radio", query = "SELECT k FROM Klienti k WHERE k.pytja1Radio = :pytja1Radio")
    , @NamedQuery(name = "Klienti.findByPytja1RrjeteSociale", query = "SELECT k FROM Klienti k WHERE k.pytja1RrjeteSociale = :pytja1RrjeteSociale")
    , @NamedQuery(name = "Klienti.findByPytja1Billboards", query = "SELECT k FROM Klienti k WHERE k.pytja1Billboards = :pytja1Billboards")
    , @NamedQuery(name = "Klienti.findByPytja1Gazete", query = "SELECT k FROM Klienti k WHERE k.pytja1Gazete = :pytja1Gazete")
    , @NamedQuery(name = "Klienti.findByPytja1Portale", query = "SELECT k FROM Klienti k WHERE k.pytja1Portale = :pytja1Portale")
    , @NamedQuery(name = "Klienti.findByPytja1Referuar", query = "SELECT k FROM Klienti k WHERE k.pytja1Referuar = :pytja1Referuar")
    , @NamedQuery(name = "Klienti.findByPytja1PromovimetDirekte", query = "SELECT k FROM Klienti k WHERE k.pytja1PromovimetDirekte = :pytja1PromovimetDirekte")
    , @NamedQuery(name = "Klienti.findByPytja1SMS", query = "SELECT k FROM Klienti k WHERE k.pytja1SMS = :pytja1SMS")
    , @NamedQuery(name = "Klienti.findByPytja1Other", query = "SELECT k FROM Klienti k WHERE k.pytja1Other = :pytja1Other")
    , @NamedQuery(name = "Klienti.findByPytja2TV", query = "SELECT k FROM Klienti k WHERE k.pytja2TV = :pytja2TV")
    , @NamedQuery(name = "Klienti.findByPytja2Radio", query = "SELECT k FROM Klienti k WHERE k.pytja2Radio = :pytja2Radio")
    , @NamedQuery(name = "Klienti.findByPytja2RrjeteSociale", query = "SELECT k FROM Klienti k WHERE k.pytja2RrjeteSociale = :pytja2RrjeteSociale")
    , @NamedQuery(name = "Klienti.findByPytja2Billboards", query = "SELECT k FROM Klienti k WHERE k.pytja2Billboards = :pytja2Billboards")
    , @NamedQuery(name = "Klienti.findByPytja2Gazete", query = "SELECT k FROM Klienti k WHERE k.pytja2Gazete = :pytja2Gazete")
    , @NamedQuery(name = "Klienti.findByPytja2Portale", query = "SELECT k FROM Klienti k WHERE k.pytja2Portale = :pytja2Portale")
    , @NamedQuery(name = "Klienti.findByPytja2Referuar", query = "SELECT k FROM Klienti k WHERE k.pytja2Referuar = :pytja2Referuar")
    , @NamedQuery(name = "Klienti.findByPytja2PromovimetDirekte", query = "SELECT k FROM Klienti k WHERE k.pytja2PromovimetDirekte = :pytja2PromovimetDirekte")
    , @NamedQuery(name = "Klienti.findByPytja2SMS", query = "SELECT k FROM Klienti k WHERE k.pytja2SMS = :pytja2SMS")
    , @NamedQuery(name = "Klienti.findByPytja2Other", query = "SELECT k FROM Klienti k WHERE k.pytja2Other = :pytja2Other")
    , @NamedQuery(name = "Klienti.findByPytja3", query = "SELECT k FROM Klienti k WHERE k.pytja3 = :pytja3")
    , @NamedQuery(name = "Klienti.findByPytja4", query = "SELECT k FROM Klienti k WHERE k.pytja4 = :pytja4")
    , @NamedQuery(name = "Klienti.findByPytja5", query = "SELECT k FROM Klienti k WHERE k.pytja5 = :pytja5")
    , @NamedQuery(name = "Klienti.findByKomenti", query = "SELECT k FROM Klienti k WHERE k.komenti = :komenti")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nrPersonal")
    private Integer nrPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emri")
    private String emri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nrTelefonit")
    private String nrTelefonit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1TV")
    private String pytja1TV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1Radio")
    private String pytja1Radio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1RrjeteSociale")
    private String pytja1RrjeteSociale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1Billboards")
    private String pytja1Billboards;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1Gazete")
    private String pytja1Gazete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1Portale")
    private String pytja1Portale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1Referuar")
    private String pytja1Referuar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1PromovimetDirekte")
    private String pytja1PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1SMS")
    private String pytja1SMS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Pytja1Other")
    private String pytja1Other;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2TV")
    private String pytja2TV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2Radio")
    private String pytja2Radio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2RrjeteSociale")
    private String pytja2RrjeteSociale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2Billboards")
    private String pytja2Billboards;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2Gazete")
    private String pytja2Gazete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2Portale")
    private String pytja2Portale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2Referuar")
    private String pytja2Referuar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2PromovimetDirekte")
    private String pytja2PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2SMS")
    private String pytja2SMS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Pytja2Other")
    private String pytja2Other;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja3")
    private String pytja3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Pytja4")
    private String pytja4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja5")
    private String pytja5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Komenti")
    private String komenti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrPersonal")
    private Collection<RaportUserKlient> raportUserKlientCollection;

    public Klienti() {
    }

    public Klienti(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public Klienti(Integer nrPersonal, String emri, String mbiemri, String nrTelefonit, String pytja1TV, String pytja1Radio, String pytja1RrjeteSociale, String pytja1Billboards, String pytja1Gazete, String pytja1Portale, String pytja1Referuar, String pytja1PromovimetDirekte, String pytja1SMS, String pytja1Other, String pytja2TV, String pytja2Radio, String pytja2RrjeteSociale, String pytja2Billboards, String pytja2Gazete, String pytja2Portale, String pytja2Referuar, String pytja2PromovimetDirekte, String pytja2SMS, String pytja2Other, String pytja3, String pytja4, String pytja5, String komenti) {
        this.nrPersonal = nrPersonal;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrTelefonit = nrTelefonit;
        this.pytja1TV = pytja1TV;
        this.pytja1Radio = pytja1Radio;
        this.pytja1RrjeteSociale = pytja1RrjeteSociale;
        this.pytja1Billboards = pytja1Billboards;
        this.pytja1Gazete = pytja1Gazete;
        this.pytja1Portale = pytja1Portale;
        this.pytja1Referuar = pytja1Referuar;
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
        this.pytja1SMS = pytja1SMS;
        this.pytja1Other = pytja1Other;
        this.pytja2TV = pytja2TV;
        this.pytja2Radio = pytja2Radio;
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
        this.pytja2Billboards = pytja2Billboards;
        this.pytja2Gazete = pytja2Gazete;
        this.pytja2Portale = pytja2Portale;
        this.pytja2Referuar = pytja2Referuar;
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
        this.pytja2SMS = pytja2SMS;
        this.pytja2Other = pytja2Other;
        this.pytja3 = pytja3;
        this.pytja4 = pytja4;
        this.pytja5 = pytja5;
        this.komenti = komenti;
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

    public String getPytja1TV() {
        return pytja1TV;
    }

    public void setPytja1TV(String pytja1TV) {
        this.pytja1TV = pytja1TV;
    }

    public String getPytja1Radio() {
        return pytja1Radio;
    }

    public void setPytja1Radio(String pytja1Radio) {
        this.pytja1Radio = pytja1Radio;
    }

    public String getPytja1RrjeteSociale() {
        return pytja1RrjeteSociale;
    }

    public void setPytja1RrjeteSociale(String pytja1RrjeteSociale) {
        this.pytja1RrjeteSociale = pytja1RrjeteSociale;
    }

    public String getPytja1Billboards() {
        return pytja1Billboards;
    }

    public void setPytja1Billboards(String pytja1Billboards) {
        this.pytja1Billboards = pytja1Billboards;
    }

    public String getPytja1Gazete() {
        return pytja1Gazete;
    }

    public void setPytja1Gazete(String pytja1Gazete) {
        this.pytja1Gazete = pytja1Gazete;
    }

    public String getPytja1Portale() {
        return pytja1Portale;
    }

    public void setPytja1Portale(String pytja1Portale) {
        this.pytja1Portale = pytja1Portale;
    }

    public String getPytja1Referuar() {
        return pytja1Referuar;
    }

    public void setPytja1Referuar(String pytja1Referuar) {
        this.pytja1Referuar = pytja1Referuar;
    }

    public String getPytja1PromovimetDirekte() {
        return pytja1PromovimetDirekte;
    }

    public void setPytja1PromovimetDirekte(String pytja1PromovimetDirekte) {
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
    }

    public String getPytja1SMS() {
        return pytja1SMS;
    }

    public void setPytja1SMS(String pytja1SMS) {
        this.pytja1SMS = pytja1SMS;
    }

    public String getPytja1Other() {
        return pytja1Other;
    }

    public void setPytja1Other(String pytja1Other) {
        this.pytja1Other = pytja1Other;
    }

    public String getPytja2TV() {
        return pytja2TV;
    }

    public void setPytja2TV(String pytja2TV) {
        this.pytja2TV = pytja2TV;
    }

    public String getPytja2Radio() {
        return pytja2Radio;
    }

    public void setPytja2Radio(String pytja2Radio) {
        this.pytja2Radio = pytja2Radio;
    }

    public String getPytja2RrjeteSociale() {
        return pytja2RrjeteSociale;
    }

    public void setPytja2RrjeteSociale(String pytja2RrjeteSociale) {
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
    }

    public String getPytja2Billboards() {
        return pytja2Billboards;
    }

    public void setPytja2Billboards(String pytja2Billboards) {
        this.pytja2Billboards = pytja2Billboards;
    }

    public String getPytja2Gazete() {
        return pytja2Gazete;
    }

    public void setPytja2Gazete(String pytja2Gazete) {
        this.pytja2Gazete = pytja2Gazete;
    }

    public String getPytja2Portale() {
        return pytja2Portale;
    }

    public void setPytja2Portale(String pytja2Portale) {
        this.pytja2Portale = pytja2Portale;
    }

    public String getPytja2Referuar() {
        return pytja2Referuar;
    }

    public void setPytja2Referuar(String pytja2Referuar) {
        this.pytja2Referuar = pytja2Referuar;
    }

    public String getPytja2PromovimetDirekte() {
        return pytja2PromovimetDirekte;
    }

    public void setPytja2PromovimetDirekte(String pytja2PromovimetDirekte) {
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
    }

    public String getPytja2SMS() {
        return pytja2SMS;
    }

    public void setPytja2SMS(String pytja2SMS) {
        this.pytja2SMS = pytja2SMS;
    }

    public String getPytja2Other() {
        return pytja2Other;
    }

    public void setPytja2Other(String pytja2Other) {
        this.pytja2Other = pytja2Other;
    }

    public String getPytja3() {
        return pytja3;
    }

    public void setPytja3(String pytja3) {
        this.pytja3 = pytja3;
    }

    public String getPytja4() {
        return pytja4;
    }

    public void setPytja4(String pytja4) {
        this.pytja4 = pytja4;
    }

    public String getPytja5() {
        return pytja5;
    }

    public void setPytja5(String pytja5) {
        this.pytja5 = pytja5;
    }

    public String getKomenti() {
        return komenti;
    }

    public void setKomenti(String komenti) {
        this.komenti = komenti;
    }

    @XmlTransient
    public Collection<RaportUserKlient> getRaportUserKlientCollection() {
        return raportUserKlientCollection;
    }

    public void setRaportUserKlientCollection(Collection<RaportUserKlient> raportUserKlientCollection) {
        this.raportUserKlientCollection = raportUserKlientCollection;
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
        return "BL.Klienti[ nrPersonal=" + nrPersonal + " ]";
    }
    
}
