/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Pytesori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pytesori.findAll", query = "SELECT p FROM Pytesori p")
    , @NamedQuery(name = "Pytesori.findByPytesoriID", query = "SELECT p FROM Pytesori p WHERE p.pytesoriID = :pytesoriID")
    , @NamedQuery(name = "Pytesori.findByPytja1TV", query = "SELECT p FROM Pytesori p WHERE p.pytja1TV = :pytja1TV")
    , @NamedQuery(name = "Pytesori.findByPytja1Radio", query = "SELECT p FROM Pytesori p WHERE p.pytja1Radio = :pytja1Radio")
    , @NamedQuery(name = "Pytesori.findByPytja1RrjeteSociale", query = "SELECT p FROM Pytesori p WHERE p.pytja1RrjeteSociale = :pytja1RrjeteSociale")
    , @NamedQuery(name = "Pytesori.findByPytja1Billboards", query = "SELECT p FROM Pytesori p WHERE p.pytja1Billboards = :pytja1Billboards")
    , @NamedQuery(name = "Pytesori.findByPytja1Gazete", query = "SELECT p FROM Pytesori p WHERE p.pytja1Gazete = :pytja1Gazete")
    , @NamedQuery(name = "Pytesori.findByPytja1Portale", query = "SELECT p FROM Pytesori p WHERE p.pytja1Portale = :pytja1Portale")
    , @NamedQuery(name = "Pytesori.findByPytja1Referuar", query = "SELECT p FROM Pytesori p WHERE p.pytja1Referuar = :pytja1Referuar")
    , @NamedQuery(name = "Pytesori.findByPytja1PromovimetDirekte", query = "SELECT p FROM Pytesori p WHERE p.pytja1PromovimetDirekte = :pytja1PromovimetDirekte")
    , @NamedQuery(name = "Pytesori.findByPytja1SMS", query = "SELECT p FROM Pytesori p WHERE p.pytja1SMS = :pytja1SMS")
    , @NamedQuery(name = "Pytesori.findByPytja1Other", query = "SELECT p FROM Pytesori p WHERE p.pytja1Other = :pytja1Other")
    , @NamedQuery(name = "Pytesori.findByPytja2TV", query = "SELECT p FROM Pytesori p WHERE p.pytja2TV = :pytja2TV")
    , @NamedQuery(name = "Pytesori.findByPytja2Radio", query = "SELECT p FROM Pytesori p WHERE p.pytja2Radio = :pytja2Radio")
    , @NamedQuery(name = "Pytesori.findByPytja2RrjeteSociale", query = "SELECT p FROM Pytesori p WHERE p.pytja2RrjeteSociale = :pytja2RrjeteSociale")
    , @NamedQuery(name = "Pytesori.findByPytja2Billboards", query = "SELECT p FROM Pytesori p WHERE p.pytja2Billboards = :pytja2Billboards")
    , @NamedQuery(name = "Pytesori.findByPytja2Gazete", query = "SELECT p FROM Pytesori p WHERE p.pytja2Gazete = :pytja2Gazete")
    , @NamedQuery(name = "Pytesori.findByPytja2Portale", query = "SELECT p FROM Pytesori p WHERE p.pytja2Portale = :pytja2Portale")
    , @NamedQuery(name = "Pytesori.findByPytja2Referuar", query = "SELECT p FROM Pytesori p WHERE p.pytja2Referuar = :pytja2Referuar")
    , @NamedQuery(name = "Pytesori.findByPytja2PromovimetDirekte", query = "SELECT p FROM Pytesori p WHERE p.pytja2PromovimetDirekte = :pytja2PromovimetDirekte")
    , @NamedQuery(name = "Pytesori.findByPytja2SMS", query = "SELECT p FROM Pytesori p WHERE p.pytja2SMS = :pytja2SMS")
    , @NamedQuery(name = "Pytesori.findByPytja2Other", query = "SELECT p FROM Pytesori p WHERE p.pytja2Other = :pytja2Other")
    , @NamedQuery(name = "Pytesori.findByPytja3", query = "SELECT p FROM Pytesori p WHERE p.pytja3 = :pytja3")
    , @NamedQuery(name = "Pytesori.findByPytja4", query = "SELECT p FROM Pytesori p WHERE p.pytja4 = :pytja4")
    , @NamedQuery(name = "Pytesori.findByPytja5", query = "SELECT p FROM Pytesori p WHERE p.pytja5 = :pytja5")
    , @NamedQuery(name = "Pytesori.findByKomenti", query = "SELECT p FROM Pytesori p WHERE p.komenti = :komenti")})
public class Pytesori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PytesoriID")
    private Integer pytesoriID;
    @Column(name = "Pytja1TV")
    private Boolean pytja1TV;
    @Column(name = "Pytja1Radio")
    private Boolean pytja1Radio;
    @Column(name = "Pytja1RrjeteSociale")
    private Boolean pytja1RrjeteSociale;
    @Column(name = "Pytja1Billboards")
    private Boolean pytja1Billboards;
    @Column(name = "Pytja1Gazete")
    private Boolean pytja1Gazete;
    @Column(name = "Pytja1Portale")
    private Boolean pytja1Portale;
    @Column(name = "Pytja1Referuar")
    private Boolean pytja1Referuar;
    @Column(name = "Pytja1PromovimetDirekte")
    private Boolean pytja1PromovimetDirekte;
    @Column(name = "Pytja1SMS")
    private Boolean pytja1SMS;
    @Column(name = "Pytja1Other")
    private Boolean pytja1Other;
    @Column(name = "Pytja2TV")
    private Boolean pytja2TV;
    @Column(name = "Pytja2Radio")
    private Boolean pytja2Radio;
    @Column(name = "Pytja2RrjeteSociale")
    private Boolean pytja2RrjeteSociale;
    @Column(name = "Pytja2Billboards")
    private Boolean pytja2Billboards;
    @Column(name = "Pytja2Gazete")
    private Boolean pytja2Gazete;
    @Column(name = "Pytja2Portale")
    private Boolean pytja2Portale;
    @Column(name = "Pytja2Referuar")
    private Boolean pytja2Referuar;
    @Column(name = "Pytja2PromovimetDirekte")
    private Boolean pytja2PromovimetDirekte;
    @Column(name = "Pytja2SMS")
    private Boolean pytja2SMS;
    @Size(max = 50)
    @Column(name = "Pytja2Other")
    private String pytja2Other;
    @Column(name = "Pytja3")
    private Boolean pytja3;
    @Size(max = 10)
    @Column(name = "Pytja4")
    private String pytja4;
    @Column(name = "Pytja5")
    private Boolean pytja5;
    @Size(max = 200)
    @Column(name = "Komenti")
    private String komenti;

    public Pytesori() {
    }

    public Pytesori(Integer pytesoriID) {
        this.pytesoriID = pytesoriID;
    }

    public Integer getPytesoriID() {
        return pytesoriID;
    }

    public void setPytesoriID(Integer pytesoriID) {
        this.pytesoriID = pytesoriID;
    }

    public Boolean getPytja1TV() {
        return pytja1TV;
    }

    public void setPytja1TV(Boolean pytja1TV) {
        this.pytja1TV = pytja1TV;
    }

    public Boolean getPytja1Radio() {
        return pytja1Radio;
    }

    public void setPytja1Radio(Boolean pytja1Radio) {
        this.pytja1Radio = pytja1Radio;
    }

    public Boolean getPytja1RrjeteSociale() {
        return pytja1RrjeteSociale;
    }

    public void setPytja1RrjeteSociale(Boolean pytja1RrjeteSociale) {
        this.pytja1RrjeteSociale = pytja1RrjeteSociale;
    }

    public Boolean getPytja1Billboards() {
        return pytja1Billboards;
    }

    public void setPytja1Billboards(Boolean pytja1Billboards) {
        this.pytja1Billboards = pytja1Billboards;
    }

    public Boolean getPytja1Gazete() {
        return pytja1Gazete;
    }

    public void setPytja1Gazete(Boolean pytja1Gazete) {
        this.pytja1Gazete = pytja1Gazete;
    }

    public Boolean getPytja1Portale() {
        return pytja1Portale;
    }

    public void setPytja1Portale(Boolean pytja1Portale) {
        this.pytja1Portale = pytja1Portale;
    }

    public Boolean getPytja1Referuar() {
        return pytja1Referuar;
    }

    public void setPytja1Referuar(Boolean pytja1Referuar) {
        this.pytja1Referuar = pytja1Referuar;
    }

    public Boolean getPytja1PromovimetDirekte() {
        return pytja1PromovimetDirekte;
    }

    public void setPytja1PromovimetDirekte(Boolean pytja1PromovimetDirekte) {
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
    }

    public Boolean getPytja1SMS() {
        return pytja1SMS;
    }

    public void setPytja1SMS(Boolean pytja1SMS) {
        this.pytja1SMS = pytja1SMS;
    }

    public Boolean getPytja1Other() {
        return pytja1Other;
    }

    public void setPytja1Other(Boolean pytja1Other) {
        this.pytja1Other = pytja1Other;
    }

    public Boolean getPytja2TV() {
        return pytja2TV;
    }

    public void setPytja2TV(Boolean pytja2TV) {
        this.pytja2TV = pytja2TV;
    }

    public Boolean getPytja2Radio() {
        return pytja2Radio;
    }

    public void setPytja2Radio(Boolean pytja2Radio) {
        this.pytja2Radio = pytja2Radio;
    }

    public Boolean getPytja2RrjeteSociale() {
        return pytja2RrjeteSociale;
    }

    public void setPytja2RrjeteSociale(Boolean pytja2RrjeteSociale) {
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
    }

    public Boolean getPytja2Billboards() {
        return pytja2Billboards;
    }

    public void setPytja2Billboards(Boolean pytja2Billboards) {
        this.pytja2Billboards = pytja2Billboards;
    }

    public Boolean getPytja2Gazete() {
        return pytja2Gazete;
    }

    public void setPytja2Gazete(Boolean pytja2Gazete) {
        this.pytja2Gazete = pytja2Gazete;
    }

    public Boolean getPytja2Portale() {
        return pytja2Portale;
    }

    public void setPytja2Portale(Boolean pytja2Portale) {
        this.pytja2Portale = pytja2Portale;
    }

    public Boolean getPytja2Referuar() {
        return pytja2Referuar;
    }

    public void setPytja2Referuar(Boolean pytja2Referuar) {
        this.pytja2Referuar = pytja2Referuar;
    }

    public Boolean getPytja2PromovimetDirekte() {
        return pytja2PromovimetDirekte;
    }

    public void setPytja2PromovimetDirekte(Boolean pytja2PromovimetDirekte) {
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
    }

    public Boolean getPytja2SMS() {
        return pytja2SMS;
    }

    public void setPytja2SMS(Boolean pytja2SMS) {
        this.pytja2SMS = pytja2SMS;
    }

    public String getPytja2Other() {
        return pytja2Other;
    }

    public void setPytja2Other(String pytja2Other) {
        this.pytja2Other = pytja2Other;
    }

    public Boolean getPytja3() {
        return pytja3;
    }

    public void setPytja3(Boolean pytja3) {
        this.pytja3 = pytja3;
    }

    public String getPytja4() {
        return pytja4;
    }

    public void setPytja4(String pytja4) {
        this.pytja4 = pytja4;
    }

    public Boolean getPytja5() {
        return pytja5;
    }

    public void setPytja5(Boolean pytja5) {
        this.pytja5 = pytja5;
    }

    public String getKomenti() {
        return komenti;
    }

    public void setKomenti(String komenti) {
        this.komenti = komenti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pytesoriID != null ? pytesoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pytesori)) {
            return false;
        }
        Pytesori other = (Pytesori) object;
        if ((this.pytesoriID == null && other.pytesoriID != null) || (this.pytesoriID != null && !this.pytesoriID.equals(other.pytesoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Main.BL.Pytesori[ pytesoriID=" + pytesoriID + " ]";
    }
    
}
