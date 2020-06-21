/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "xeusu_usuar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeusuUsuar.findAll", query = "SELECT x FROM XeusuUsuar x")
    , @NamedQuery(name = "XeusuUsuar.findByPeempCodigo", query = "SELECT x FROM XeusuUsuar x WHERE x.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuPassword", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPassword = :xeusuPassword")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuPiefirma", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuPiefirma = :xeusuPiefirma")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuFecCrea", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFecCrea = :xeusuFecCrea")
    , @NamedQuery(name = "XeusuUsuar.findByXeusuFecUltimoCambio", query = "SELECT x FROM XeusuUsuar x WHERE x.xeusuFecUltimoCambio = :xeusuFecUltimoCambio")})
public class XeusuUsuar implements Serializable {

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
    @Column(name = "XEUSU_PASSWORD")
    private String xeusuPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEUSU_PIEFIRMA")
    private String xeusuPiefirma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFecCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUSU_FEC_ULTIMO_CAMBIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeusuFecUltimoCambio;
    @JoinTable(name = "historial_sistema", joinColumns = {
        @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "XESIS_CODSIS", referencedColumnName = "XESIS_CODSIS")})
    @ManyToMany
    private Collection<XesisSistem> xesisSistemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xeusuUsuar")
    private Collection<XerolRol2> xerolRol2Collection;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PeempEmple peempEmple;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xeusuUsuar")
    private Collection<XeuxpUsuper> xeuxpUsuperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xeusuUsuar")
    private Collection<XeestEstado> xeestEstadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempCodigo")
    private Collection<XeestEstado> xeestEstadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peempCodigo")
    private Collection<Contrasena> contrasenaCollection;

    public XeusuUsuar() {
    }

    public XeusuUsuar(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public XeusuUsuar(String peempCodigo, String xeusuPassword, String xeusuPiefirma, Date xeusuFecCrea, Date xeusuFecUltimoCambio) {
        this.peempCodigo = peempCodigo;
        this.xeusuPassword = xeusuPassword;
        this.xeusuPiefirma = xeusuPiefirma;
        this.xeusuFecCrea = xeusuFecCrea;
        this.xeusuFecUltimoCambio = xeusuFecUltimoCambio;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getXeusuPassword() {
        return xeusuPassword;
    }

    public void setXeusuPassword(String xeusuPassword) {
        this.xeusuPassword = xeusuPassword;
    }

    public String getXeusuPiefirma() {
        return xeusuPiefirma;
    }

    public void setXeusuPiefirma(String xeusuPiefirma) {
        this.xeusuPiefirma = xeusuPiefirma;
    }

    public Date getXeusuFecCrea() {
        return xeusuFecCrea;
    }

    public void setXeusuFecCrea(Date xeusuFecCrea) {
        this.xeusuFecCrea = xeusuFecCrea;
    }

    public Date getXeusuFecUltimoCambio() {
        return xeusuFecUltimoCambio;
    }

    public void setXeusuFecUltimoCambio(Date xeusuFecUltimoCambio) {
        this.xeusuFecUltimoCambio = xeusuFecUltimoCambio;
    }

    @XmlTransient
    public Collection<XesisSistem> getXesisSistemCollection() {
        return xesisSistemCollection;
    }

    public void setXesisSistemCollection(Collection<XesisSistem> xesisSistemCollection) {
        this.xesisSistemCollection = xesisSistemCollection;
    }

    @XmlTransient
    public Collection<XerolRol2> getXerolRol2Collection() {
        return xerolRol2Collection;
    }

    public void setXerolRol2Collection(Collection<XerolRol2> xerolRol2Collection) {
        this.xerolRol2Collection = xerolRol2Collection;
    }

    public PeempEmple getPeempEmple() {
        return peempEmple;
    }

    public void setPeempEmple(PeempEmple peempEmple) {
        this.peempEmple = peempEmple;
    }

    @XmlTransient
    public Collection<XeuxpUsuper> getXeuxpUsuperCollection() {
        return xeuxpUsuperCollection;
    }

    public void setXeuxpUsuperCollection(Collection<XeuxpUsuper> xeuxpUsuperCollection) {
        this.xeuxpUsuperCollection = xeuxpUsuperCollection;
    }

    @XmlTransient
    public Collection<XeestEstado> getXeestEstadoCollection() {
        return xeestEstadoCollection;
    }

    public void setXeestEstadoCollection(Collection<XeestEstado> xeestEstadoCollection) {
        this.xeestEstadoCollection = xeestEstadoCollection;
    }

    @XmlTransient
    public Collection<XeestEstado> getXeestEstadoCollection1() {
        return xeestEstadoCollection1;
    }

    public void setXeestEstadoCollection1(Collection<XeestEstado> xeestEstadoCollection1) {
        this.xeestEstadoCollection1 = xeestEstadoCollection1;
    }

    @XmlTransient
    public Collection<Contrasena> getContrasenaCollection() {
        return contrasenaCollection;
    }

    public void setContrasenaCollection(Collection<Contrasena> contrasenaCollection) {
        this.contrasenaCollection = contrasenaCollection;
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
        if (!(object instanceof XeusuUsuar)) {
            return false;
        }
        XeusuUsuar other = (XeusuUsuar) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeusuUsuar[ peempCodigo=" + peempCodigo + " ]";
    }
    public String generateRandomText(){
        SecureRandom random = new SecureRandom();
        String text = new BigInteger(130, random).toString(32);
        return text;
    }
}
