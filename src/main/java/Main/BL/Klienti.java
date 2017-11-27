/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "Klienti.findByData", query = "SELECT k FROM Klienti k WHERE k.data = :data")
    , @NamedQuery(name = "Klienti.findByPytja1TV", query = "SELECT k FROM Klienti k WHERE k.pytja1TV = :pytja1TV")
    , @NamedQuery(name = "Klienti.findByPytja1Radio", query = "SELECT k FROM Klienti k WHERE k.pytja1Radio = :pytja1Radio")
    , @NamedQuery(name = "Klienti.findByPytja1RrjetetSociale", query = "SELECT k FROM Klienti k WHERE k.pytja1RrjetetSociale = :pytja1RrjetetSociale")
    , @NamedQuery(name = "Klienti.findByPytja1Billboards", query = "SELECT k FROM Klienti k WHERE k.pytja1Billboards = :pytja1Billboards")
    , @NamedQuery(name = "Klienti.findByPytja1Gazete", query = "SELECT k FROM Klienti k WHERE k.pytja1Gazete = :pytja1Gazete")
    , @NamedQuery(name = "Klienti.findByPytja1Portale", query = "SELECT k FROM Klienti k WHERE k.pytja1Portale = :pytja1Portale")
    , @NamedQuery(name = "Klienti.findByPytja1Referuar", query = "SELECT k FROM Klienti k WHERE k.pytja1Referuar = :pytja1Referuar")
    , @NamedQuery(name = "Klienti.findByPytja1PromovimetDirekte", query = "SELECT k FROM Klienti k WHERE k.pytja1PromovimetDirekte = :pytja1PromovimetDirekte")
    , @NamedQuery(name = "Klienti.findByPytja1Sms", query = "SELECT k FROM Klienti k WHERE k.pytja1Sms = :pytja1Sms")
    , @NamedQuery(name = "Klienti.findByPytja1Tjeter", query = "SELECT k FROM Klienti k WHERE k.pytja1Tjeter = :pytja1Tjeter")
    , @NamedQuery(name = "Klienti.findByPytja2TV", query = "SELECT k FROM Klienti k WHERE k.pytja2TV = :pytja2TV")
    , @NamedQuery(name = "Klienti.findByPytja2Radio", query = "SELECT k FROM Klienti k WHERE k.pytja2Radio = :pytja2Radio")
    , @NamedQuery(name = "Klienti.findByPytja2RrjeteSociale", query = "SELECT k FROM Klienti k WHERE k.pytja2RrjeteSociale = :pytja2RrjeteSociale")
    , @NamedQuery(name = "Klienti.findByPytja2Billboards", query = "SELECT k FROM Klienti k WHERE k.pytja2Billboards = :pytja2Billboards")
    , @NamedQuery(name = "Klienti.findByPytja2Gazete", query = "SELECT k FROM Klienti k WHERE k.pytja2Gazete = :pytja2Gazete")
    , @NamedQuery(name = "Klienti.findByPytja2Portale", query = "SELECT k FROM Klienti k WHERE k.pytja2Portale = :pytja2Portale")
    , @NamedQuery(name = "Klienti.findByPytja2Referuar", query = "SELECT k FROM Klienti k WHERE k.pytja2Referuar = :pytja2Referuar")
    , @NamedQuery(name = "Klienti.findByPytja2PromovimetDirekte", query = "SELECT k FROM Klienti k WHERE k.pytja2PromovimetDirekte = :pytja2PromovimetDirekte")
    , @NamedQuery(name = "Klienti.findByPytja2Sms", query = "SELECT k FROM Klienti k WHERE k.pytja2Sms = :pytja2Sms")
    , @NamedQuery(name = "Klienti.findByPytja2Tjeter", query = "SELECT k FROM Klienti k WHERE k.pytja2Tjeter = :pytja2Tjeter")
    , @NamedQuery(name = "Klienti.findByPytja3", query = "SELECT k FROM Klienti k WHERE k.pytja3 = :pytja3")
    , @NamedQuery(name = "Klienti.findByPytja4", query = "SELECT k FROM Klienti k WHERE k.pytja4 = :pytja4")
    , @NamedQuery(name = "Klienti.findByPytja5", query = "SELECT k FROM Klienti k WHERE k.pytja5 = :pytja5")
    , @NamedQuery(name = "Klienti.findByKomenti", query = "SELECT k FROM Klienti k WHERE k.komenti = :komenti")})
public class Klienti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
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
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_TV")
    private String pytja1TV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Radio")
    private String pytja1Radio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_RrjetetSociale")
    private String pytja1RrjetetSociale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Billboards")
    private String pytja1Billboards;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Gazete")
    private String pytja1Gazete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Portale")
    private String pytja1Portale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Referuar")
    private String pytja1Referuar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_PromovimetDirekte")
    private String pytja1PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Sms")
    private String pytja1Sms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja1_Tjeter")
    private String pytja1Tjeter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_TV")
    private String pytja2TV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Radio")
    private String pytja2Radio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_RrjeteSociale")
    private String pytja2RrjeteSociale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Billboards")
    private String pytja2Billboards;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Gazete")
    private String pytja2Gazete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Portale")
    private String pytja2Portale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Referuar")
    private String pytja2Referuar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_PromovimetDirekte")
    private String pytja2PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Sms")
    private String pytja2Sms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja2_Tjeter")
    private String pytja2Tjeter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja3")
    private String pytja3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja4")
    private String pytja4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Pytja5")
    private String pytja5;
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "Komenti")
    private String komenti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrPersonal")
    private Collection<RaportUserClient> raportUserClientCollection;

    public Klienti() {
    }

    public Klienti(Integer nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public Klienti(Integer nrPersonal, String emri, String mbiemri, String nrTelefonit, Date data, String pytja1TV, String pytja1Radio, String pytja1RrjetetSociale, String pytja1Billboards, String pytja1Gazete, String pytja1Portale, String pytja1Referuar, String pytja1PromovimetDirekte, String pytja1Sms, String pytja1Tjeter, String pytja2TV, String pytja2Radio, String pytja2RrjeteSociale, String pytja2Billboards, String pytja2Gazete, String pytja2Portale, String pytja2Referuar, String pytja2PromovimetDirekte, String pytja2Sms, String pytja2Tjeter, String pytja3, String pytja4, String pytja5, String komenti) {
        this.nrPersonal = nrPersonal;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrTelefonit = nrTelefonit;
        this.data = data;
        this.pytja1TV = pytja1TV;
        this.pytja1Radio = pytja1Radio;
        this.pytja1RrjetetSociale = pytja1RrjetetSociale;
        this.pytja1Billboards = pytja1Billboards;
        this.pytja1Gazete = pytja1Gazete;
        this.pytja1Portale = pytja1Portale;
        this.pytja1Referuar = pytja1Referuar;
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
        this.pytja1Sms = pytja1Sms;
        this.pytja1Tjeter = pytja1Tjeter;
        this.pytja2TV = pytja2TV;
        this.pytja2Radio = pytja2Radio;
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
        this.pytja2Billboards = pytja2Billboards;
        this.pytja2Gazete = pytja2Gazete;
        this.pytja2Portale = pytja2Portale;
        this.pytja2Referuar = pytja2Referuar;
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
        this.pytja2Sms = pytja2Sms;
        this.pytja2Tjeter = pytja2Tjeter;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getPytja1RrjetetSociale() {
        return pytja1RrjetetSociale;
    }

    public void setPytja1RrjetetSociale(String pytja1RrjetetSociale) {
        this.pytja1RrjetetSociale = pytja1RrjetetSociale;
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

    public String getPytja1Sms() {
        return pytja1Sms;
    }

    public void setPytja1Sms(String pytja1Sms) {
        this.pytja1Sms = pytja1Sms;
    }

    public String getPytja1Tjeter() {
        return pytja1Tjeter;
    }

    public void setPytja1Tjeter(String pytja1Tjeter) {
        this.pytja1Tjeter = pytja1Tjeter;
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

    public String getPytja2Sms() {
        return pytja2Sms;
    }

    public void setPytja2Sms(String pytja2Sms) {
        this.pytja2Sms = pytja2Sms;
    }

    public String getPytja2Tjeter() {
        return pytja2Tjeter;
    }

    public void setPytja2Tjeter(String pytja2Tjeter) {
        this.pytja2Tjeter = pytja2Tjeter;
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
    public Collection<RaportUserClient> getRaportUserClientCollection() {
        return raportUserClientCollection;
    }

    public void setRaportUserClientCollection(Collection<RaportUserClient> raportUserClientCollection) {
        this.raportUserClientCollection = raportUserClientCollection;
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
