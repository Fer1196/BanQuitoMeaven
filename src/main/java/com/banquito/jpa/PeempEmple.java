/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "peemp_emple")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeempEmple.findAll", query = "SELECT p FROM PeempEmple p")
    , @NamedQuery(name = "PeempEmple.findByPeempCodigo", query = "SELECT p FROM PeempEmple p WHERE p.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "PeempEmple.findByPeempApelli", query = "SELECT p FROM PeempEmple p WHERE p.peempApelli = :peempApelli")
    , @NamedQuery(name = "PeempEmple.findByPeempNombre", query = "SELECT p FROM PeempEmple p WHERE p.peempNombre = :peempNombre")
    , @NamedQuery(name = "PeempEmple.findByPeempCedula", query = "SELECT p FROM PeempEmple p WHERE p.peempCedula = :peempCedula")
    , @NamedQuery(name = "PeempEmple.findByPeempFecnac", query = "SELECT p FROM PeempEmple p WHERE p.peempFecnac = :peempFecnac")
    , @NamedQuery(name = "PeempEmple.findByPeempDirec", query = "SELECT p FROM PeempEmple p WHERE p.peempDirec = :peempDirec")
    , @NamedQuery(name = "PeempEmple.findByPeempTelefo", query = "SELECT p FROM PeempEmple p WHERE p.peempTelefo = :peempTelefo")
    , @NamedQuery(name = "PeempEmple.findByPeempCargas", query = "SELECT p FROM PeempEmple p WHERE p.peempCargas = :peempCargas")
    , @NamedQuery(name = "PeempEmple.findByPeempEmail", query = "SELECT p FROM PeempEmple p WHERE p.peempEmail = :peempEmail")})
public class PeempEmple implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_APELLI")
    private String peempApelli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEEMP_NOMBRE")
    private String peempNombre;
    @Size(max = 10)
    @Column(name = "PEEMP_CEDULA")
    private String peempCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_FECNAC")
    @Temporal(TemporalType.DATE)
    private Date peempFecnac;
    @Size(max = 200)
    @Column(name = "PEEMP_DIREC")
    private String peempDirec;
    @Size(max = 15)
    @Column(name = "PEEMP_TELEFO")
    private String peempTelefo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEEMP_CARGAS")
    private short peempCargas;
    @Size(max = 100)
    @Column(name = "PEEMP_EMAIL")
    private String peempEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "peempEmple")
    private XeusuUsuar xeusuUsuar;
    @JoinColumn(name = "PEESC_CODIGO", referencedColumnName = "PEESC_CODIGO")
    @ManyToOne
    private PeescEstciv peescCodigo;
    @JoinColumn(name = "PESEX_CODIGO", referencedColumnName = "PESEX_CODIGO")
    @ManyToOne(optional = false)
    private PesexSexo pesexCodigo;

    public PeempEmple() {
    }

    public PeempEmple(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public PeempEmple(String peempCodigo, String peempApelli, String peempNombre, Date peempFecnac, short peempCargas) {
        this.peempCodigo = peempCodigo;
        this.peempApelli = peempApelli;
        this.peempNombre = peempNombre;
        this.peempFecnac = peempFecnac;
        this.peempCargas = peempCargas;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getPeempApelli() {
        return peempApelli;
    }

    public void setPeempApelli(String peempApelli) {
        this.peempApelli = peempApelli;
    }

    public String getPeempNombre() {
        return peempNombre;
    }

    public void setPeempNombre(String peempNombre) {
        this.peempNombre = peempNombre;
    }

    public String getPeempCedula() {
        return peempCedula;
    }

    public void setPeempCedula(String peempCedula) {
        this.peempCedula = peempCedula;
    }

    public Date getPeempFecnac() {
        return peempFecnac;
    }

    public void setPeempFecnac(Date peempFecnac) {
        this.peempFecnac = peempFecnac;
    }

    public String getPeempDirec() {
        return peempDirec;
    }

    public void setPeempDirec(String peempDirec) {
        this.peempDirec = peempDirec;
    }

    public String getPeempTelefo() {
        return peempTelefo;
    }

    public void setPeempTelefo(String peempTelefo) {
        this.peempTelefo = peempTelefo;
    }

    public short getPeempCargas() {
        return peempCargas;
    }

    public void setPeempCargas(short peempCargas) {
        this.peempCargas = peempCargas;
    }

    public String getPeempEmail() {
        return peempEmail;
    }

    public void setPeempEmail(String peempEmail) {
        this.peempEmail = peempEmail;
    }

    public XeusuUsuar getXeusuUsuar() {
        return xeusuUsuar;
    }

    public void setXeusuUsuar(XeusuUsuar xeusuUsuar) {
        this.xeusuUsuar = xeusuUsuar;
    }

    public PeescEstciv getPeescCodigo() {
        return peescCodigo;
    }

    public void setPeescCodigo(PeescEstciv peescCodigo) {
        this.peescCodigo = peescCodigo;
    }

    public PesexSexo getPesexCodigo() {
        return pesexCodigo;
    }

    public void setPesexCodigo(PesexSexo pesexCodigo) {
        this.pesexCodigo = pesexCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeempEmple)) {
            return false;
        }
        PeempEmple other = (PeempEmple) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.PeempEmple[ peempCodigo=" + peempCodigo + " ]";
    }
    
}
