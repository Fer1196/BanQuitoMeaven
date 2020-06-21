/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "xerol_rol2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XerolRol2.findAll", query = "SELECT x FROM XerolRol2 x")
    , @NamedQuery(name = "XerolRol2.findByPeempCodigo", query = "SELECT x FROM XerolRol2 x WHERE x.xerolRol2PK.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "XerolRol2.findByXerolInserc", query = "SELECT x FROM XerolRol2 x WHERE x.xerolInserc = :xerolInserc")
    , @NamedQuery(name = "XerolRol2.findByXeperCodper", query = "SELECT x FROM XerolRol2 x WHERE x.xerolRol2PK.xeperCodper = :xeperCodper")
    , @NamedQuery(name = "XerolRol2.findByXerolActual", query = "SELECT x FROM XerolRol2 x WHERE x.xerolActual = :xerolActual")
    , @NamedQuery(name = "XerolRol2.findByXerolElimin", query = "SELECT x FROM XerolRol2 x WHERE x.xerolElimin = :xerolElimin")
    , @NamedQuery(name = "XerolRol2.findByXerolConsul", query = "SELECT x FROM XerolRol2 x WHERE x.xerolConsul = :xerolConsul")})
public class XerolRol2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XerolRol2PK xerolRol2PK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_INSERC")
    private String xerolInserc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_ACTUAL")
    private String xerolActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_ELIMIN")
    private String xerolElimin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "XEROL_CONSUL")
    private String xerolConsul;
    @JoinTable(name = "perfil_rol", joinColumns = {
        @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO")
        , @JoinColumn(name = "XEPER_CODPER", referencedColumnName = "XEPER_CODPER")}, inverseJoinColumns = {
        @JoinColumn(name = "XEP_XEPER_CODPER", referencedColumnName = "XEPER_CODPER")})
    @ManyToMany
    private Collection<XeperPerfil2> xeperPerfil2Collection;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XeusuUsuar xeusuUsuar;

    public XerolRol2() {
    }

    public XerolRol2(XerolRol2PK xerolRol2PK) {
        this.xerolRol2PK = xerolRol2PK;
    }

    public XerolRol2(XerolRol2PK xerolRol2PK, String xerolInserc, String xerolActual, String xerolElimin, String xerolConsul) {
        this.xerolRol2PK = xerolRol2PK;
        this.xerolInserc = xerolInserc;
        this.xerolActual = xerolActual;
        this.xerolElimin = xerolElimin;
        this.xerolConsul = xerolConsul;
    }

    public XerolRol2(String peempCodigo, String xeperCodper) {
        this.xerolRol2PK = new XerolRol2PK(peempCodigo, xeperCodper);
    }

    public XerolRol2PK getXerolRol2PK() {
        return xerolRol2PK;
    }

    public void setXerolRol2PK(XerolRol2PK xerolRol2PK) {
        this.xerolRol2PK = xerolRol2PK;
    }

    public String getXerolInserc() {
        return xerolInserc;
    }

    public void setXerolInserc(String xerolInserc) {
        this.xerolInserc = xerolInserc;
    }

    public String getXerolActual() {
        return xerolActual;
    }

    public void setXerolActual(String xerolActual) {
        this.xerolActual = xerolActual;
    }

    public String getXerolElimin() {
        return xerolElimin;
    }

    public void setXerolElimin(String xerolElimin) {
        this.xerolElimin = xerolElimin;
    }

    public String getXerolConsul() {
        return xerolConsul;
    }

    public void setXerolConsul(String xerolConsul) {
        this.xerolConsul = xerolConsul;
    }

    @XmlTransient
    public Collection<XeperPerfil2> getXeperPerfil2Collection() {
        return xeperPerfil2Collection;
    }

    public void setXeperPerfil2Collection(Collection<XeperPerfil2> xeperPerfil2Collection) {
        this.xeperPerfil2Collection = xeperPerfil2Collection;
    }

    public XeusuUsuar getXeusuUsuar() {
        return xeusuUsuar;
    }

    public void setXeusuUsuar(XeusuUsuar xeusuUsuar) {
        this.xeusuUsuar = xeusuUsuar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xerolRol2PK != null ? xerolRol2PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XerolRol2)) {
            return false;
        }
        XerolRol2 other = (XerolRol2) object;
        if ((this.xerolRol2PK == null && other.xerolRol2PK != null) || (this.xerolRol2PK != null && !this.xerolRol2PK.equals(other.xerolRol2PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XerolRol2[ xerolRol2PK=" + xerolRol2PK + " ]";
    }
    
}
