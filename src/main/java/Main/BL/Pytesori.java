/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.BL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rinor.jashari
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pytesori.findAll", query = "SELECT p FROM Pytesori p")
    , @NamedQuery(name = "Pytesori.countPytja1TV", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1TV = 1")   
    , @NamedQuery(name = "Pytesori.countPytja1Radio", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1Radio = 1")
    , @NamedQuery(name = "Pytesori.countPytja1RrjeteSociale", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1RrjeteSociale = 1")
    , @NamedQuery(name = "Pytesori.countPytja1Billboards", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1Billboards = 1")
    , @NamedQuery(name = "Pytesori.countPytja1Gazete", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1Gazete = 1")
    , @NamedQuery(name = "Pytesori.countPytja1Portale", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1Portale = 1")
    , @NamedQuery(name = "Pytesori.countPytja1Referuar", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1Referuar = 1")
    , @NamedQuery(name = "Pytesori.countPytja1PromovimetDirekte", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1PromovimetDirekte = 1")
    , @NamedQuery(name = "Pytesori.countPytja1SMS", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja1SMS = 1")
        
    , @NamedQuery(name = "Pytesori.countPytja2TV", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2TV = 1")   
    , @NamedQuery(name = "Pytesori.countPytja2Radio", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2Radio = 1")
    , @NamedQuery(name = "Pytesori.countPytja2RrjeteSociale", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2RrjeteSociale = 1")
    , @NamedQuery(name = "Pytesori.countPytja2Billboards", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2Billboards = 1")
    , @NamedQuery(name = "Pytesori.countPytja2Gazete", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2Gazete = 1")
    , @NamedQuery(name = "Pytesori.countPytja2Portale", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2Portale = 1")
    , @NamedQuery(name = "Pytesori.countPytja2Referuar", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2Referuar = 1")
    , @NamedQuery(name = "Pytesori.countPytja2PromovimetDirekte", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2PromovimetDirekte = 1")
    , @NamedQuery(name = "Pytesori.countPytja2SMS", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja2SMS = 1")
        
    , @NamedQuery(name = "Pytesori.countPytja3Po", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja3 = 'po'")  
    , @NamedQuery(name = "Pytesori.countPytja3Jo", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja3 = 'jo'")  
    , @NamedQuery(name = "Pytesori.countPytja4Neutral", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja4 = 'neutral'")
    , @NamedQuery(name = "Pytesori.countPytja4Pozitiv", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja4 = 'pozitiv'")  
    , @NamedQuery(name = "Pytesori.countPytja4Negativ", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja4 = 'negativ'")   
       
    , @NamedQuery(name = "Pytesori.countPytja5Po", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja5 = 'po'")   
    , @NamedQuery(name = "Pytesori.countPytja5Jo", query = "SELECT COUNT(p) FROM Pytesori p WHERE p.pytja5 = 'jo'")
    

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
    , @NamedQuery(name = "Pytesori.findByData", query = "SELECT p FROM Pytesori p WHERE p.data = :data")})
public class Pytesori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "pytesoriID")
    private Integer pytesoriID;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1TV;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1Radio;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1RrjeteSociale;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1Billboards;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1Gazete;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1Portale;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1Referuar;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    private boolean pytja1SMS;
    @Size(max = 50)
    private String pytja1Other;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2TV;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2Radio;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2RrjeteSociale;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2Billboards;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2Gazete;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2Portale;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2Referuar;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2PromovimetDirekte;
    @Basic(optional = false)
    @NotNull
    private boolean pytja2SMS;
    @Size(max = 70)
    private String pytja2Other;
    @Size(max = 50)
    private String pytja3;
    @Size(max = 50)
    private String pytja4;
    @Size(max = 50)
    private String pytja5;
    @Lob
    @Size(max = 2147483647)
    private String komenti;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "KlientID", referencedColumnName = "nrPersonal")
    @ManyToOne(optional = false)
    private Klienti klientID;

    public Pytesori() {
    }

    public Pytesori(Integer pytesoriID) {
        this.pytesoriID = pytesoriID;
    }

    public Pytesori(Integer pytesoriID, boolean pytja1TV, boolean pytja1Radio, boolean pytja1RrjeteSociale, boolean pytja1Billboards, boolean pytja1Gazete, boolean pytja1Portale, boolean pytja1Referuar, boolean pytja1PromovimetDirekte, boolean pytja1SMS, boolean pytja2TV, boolean pytja2Radio, boolean pytja2RrjeteSociale, boolean pytja2Billboards, boolean pytja2Gazete, boolean pytja2Portale, boolean pytja2Referuar, boolean pytja2PromovimetDirekte, boolean pytja2SMS) {
        this.pytesoriID = pytesoriID;
        this.pytja1TV = pytja1TV;
        this.pytja1Radio = pytja1Radio;
        this.pytja1RrjeteSociale = pytja1RrjeteSociale;
        this.pytja1Billboards = pytja1Billboards;
        this.pytja1Gazete = pytja1Gazete;
        this.pytja1Portale = pytja1Portale;
        this.pytja1Referuar = pytja1Referuar;
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
        this.pytja1SMS = pytja1SMS;
        this.pytja2TV = pytja2TV;
        this.pytja2Radio = pytja2Radio;
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
        this.pytja2Billboards = pytja2Billboards;
        this.pytja2Gazete = pytja2Gazete;
        this.pytja2Portale = pytja2Portale;
        this.pytja2Referuar = pytja2Referuar;
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
        this.pytja2SMS = pytja2SMS;
    }

    public Integer getPytesoriID() {
        return pytesoriID;
    }

    public void setPytesoriID(Integer pytesoriID) {
        this.pytesoriID = pytesoriID;
    }

    public boolean getPytja1TV() {
        return pytja1TV;
    }

    public void setPytja1TV(boolean pytja1TV) {
        this.pytja1TV = pytja1TV;
    }

    public boolean getPytja1Radio() {
        return pytja1Radio;
    }

    public void setPytja1Radio(boolean pytja1Radio) {
        this.pytja1Radio = pytja1Radio;
    }

    public boolean getPytja1RrjeteSociale() {
        return pytja1RrjeteSociale;
    }

    public void setPytja1RrjeteSociale(boolean pytja1RrjeteSociale) {
        this.pytja1RrjeteSociale = pytja1RrjeteSociale;
    }

    public boolean getPytja1Billboards() {
        return pytja1Billboards;
    }

    public void setPytja1Billboards(boolean pytja1Billboards) {
        this.pytja1Billboards = pytja1Billboards;
    }

    public boolean getPytja1Gazete() {
        return pytja1Gazete;
    }

    public void setPytja1Gazete(boolean pytja1Gazete) {
        this.pytja1Gazete = pytja1Gazete;
    }

    public boolean getPytja1Portale() {
        return pytja1Portale;
    }

    public void setPytja1Portale(boolean pytja1Portale) {
        this.pytja1Portale = pytja1Portale;
    }

    public boolean getPytja1Referuar() {
        return pytja1Referuar;
    }

    public void setPytja1Referuar(boolean pytja1Referuar) {
        this.pytja1Referuar = pytja1Referuar;
    }

    public boolean getPytja1PromovimetDirekte() {
        return pytja1PromovimetDirekte;
    }

    public void setPytja1PromovimetDirekte(boolean pytja1PromovimetDirekte) {
        this.pytja1PromovimetDirekte = pytja1PromovimetDirekte;
    }

    public boolean getPytja1SMS() {
        return pytja1SMS;
    }

    public void setPytja1SMS(boolean pytja1SMS) {
        this.pytja1SMS = pytja1SMS;
    }

    public String getPytja1Other() {
        return pytja1Other;
    }

    public void setPytja1Other(String pytja1Other) {
        this.pytja1Other = pytja1Other;
    }

    public boolean getPytja2TV() {
        return pytja2TV;
    }

    public void setPytja2TV(boolean pytja2TV) {
        this.pytja2TV = pytja2TV;
    }

    public boolean getPytja2Radio() {
        return pytja2Radio;
    }

    public void setPytja2Radio(boolean pytja2Radio) {
        this.pytja2Radio = pytja2Radio;
    }

    public boolean getPytja2RrjeteSociale() {
        return pytja2RrjeteSociale;
    }

    public void setPytja2RrjeteSociale(boolean pytja2RrjeteSociale) {
        this.pytja2RrjeteSociale = pytja2RrjeteSociale;
    }

    public boolean getPytja2Billboards() {
        return pytja2Billboards;
    }

    public void setPytja2Billboards(boolean pytja2Billboards) {
        this.pytja2Billboards = pytja2Billboards;
    }

    public boolean getPytja2Gazete() {
        return pytja2Gazete;
    }

    public void setPytja2Gazete(boolean pytja2Gazete) {
        this.pytja2Gazete = pytja2Gazete;
    }

    public boolean getPytja2Portale() {
        return pytja2Portale;
    }

    public void setPytja2Portale(boolean pytja2Portale) {
        this.pytja2Portale = pytja2Portale;
    }

    public boolean getPytja2Referuar() {
        return pytja2Referuar;
    }

    public void setPytja2Referuar(boolean pytja2Referuar) {
        this.pytja2Referuar = pytja2Referuar;
    }

    public boolean getPytja2PromovimetDirekte() {
        return pytja2PromovimetDirekte;
    }

    public void setPytja2PromovimetDirekte(boolean pytja2PromovimetDirekte) {
        this.pytja2PromovimetDirekte = pytja2PromovimetDirekte;
    }

    public boolean getPytja2SMS() {
        return pytja2SMS;
    }

    public void setPytja2SMS(boolean pytja2SMS) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Klienti getKlientID() {
        return klientID;
    }

    public void setKlientID(Klienti klientID) {
        this.klientID = klientID;
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
