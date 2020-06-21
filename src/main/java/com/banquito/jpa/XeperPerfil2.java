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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "xeper_perfil2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeperPerfil2.findAll", query = "SELECT x FROM XeperPerfil2 x")
    , @NamedQuery(name = "XeperPerfil2.findByXeperCodper", query = "SELECT x FROM XeperPerfil2 x WHERE x.xeperCodper = :xeperCodper")
    , @NamedQuery(name = "XeperPerfil2.findByXeperDescri", query = "SELECT x FROM XeperPerfil2 x WHERE x.xeperDescri = :xeperDescri")
    , @NamedQuery(name = "XeperPerfil2.findByXeperObserv", query = "SELECT x FROM XeperPerfil2 x WHERE x.xeperObserv = :xeperObserv")})
public class XeperPerfil2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEPER_CODPER")
    private String xeperCodper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEPER_DESCRI")
    private String xeperDescri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XEPER_OBSERV")
    private String xeperObserv;
    @ManyToMany(mappedBy = "xeperPerfil2Collection")
    private Collection<XerolRol2> xerolRol2Collection;
    @JoinTable(name = "rol_aplicacion", joinColumns = {
        @JoinColumn(name = "XEPER_CODPER", referencedColumnName = "XEPER_CODPER")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGO_APLICACION", referencedColumnName = "CODIGO_APLICACION")})
    @ManyToMany
    private Collection<Aplicacion> aplicacionCollection;

    public XeperPerfil2() {
    }

    public XeperPerfil2(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    public XeperPerfil2(String xeperCodper, String xeperDescri, String xeperObserv) {
        this.xeperCodper = xeperCodper;
        this.xeperDescri = xeperDescri;
        this.xeperObserv = xeperObserv;
    }

    public String getXeperCodper() {
        return xeperCodper;
    }

    public void setXeperCodper(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    public String getXeperDescri() {
        return xeperDescri;
    }

    public void setXeperDescri(String xeperDescri) {
        this.xeperDescri = xeperDescri;
    }

    public String getXeperObserv() {
        return xeperObserv;
    }

    public void setXeperObserv(String xeperObserv) {
        this.xeperObserv = xeperObserv;
    }

    @XmlTransient
    public Collection<XerolRol2> getXerolRol2Collection() {
        return xerolRol2Collection;
    }

    public void setXerolRol2Collection(Collection<XerolRol2> xerolRol2Collection) {
        this.xerolRol2Collection = xerolRol2Collection;
    }

    @XmlTransient
    public Collection<Aplicacion> getAplicacionCollection() {
        return aplicacionCollection;
    }

    public void setAplicacionCollection(Collection<Aplicacion> aplicacionCollection) {
        this.aplicacionCollection = aplicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeperCodper != null ? xeperCodper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeperPerfil2)) {
            return false;
        }
        XeperPerfil2 other = (XeperPerfil2) object;
        if ((this.xeperCodper == null && other.xeperCodper != null) || (this.xeperCodper != null && !this.xeperCodper.equals(other.xeperCodper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeperPerfil2[ xeperCodper=" + xeperCodper + " ]";
    }
    
}
