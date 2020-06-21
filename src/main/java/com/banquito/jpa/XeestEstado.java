/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author diego
 */
@Entity
@Table(name = "xeest_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeestEstado.findAll", query = "SELECT x FROM XeestEstado x")
    , @NamedQuery(name = "XeestEstado.findByXeuPeempCodigo", query = "SELECT x FROM XeestEstado x WHERE x.xeestEstadoPK.xeuPeempCodigo = :xeuPeempCodigo")
    , @NamedQuery(name = "XeestEstado.findByXeestCodigo", query = "SELECT x FROM XeestEstado x WHERE x.xeestEstadoPK.xeestCodigo = :xeestCodigo")
    , @NamedQuery(name = "XeestEstado.findByXeestDescri", query = "SELECT x FROM XeestEstado x WHERE x.xeestDescri = :xeestDescri")})
public class XeestEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XeestEstadoPK xeestEstadoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "XEEST_DESCRI")
    private String xeestDescri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xeestEstado")
    private Collection<XesisSistem> xesisSistemCollection;
    @JoinColumn(name = "XEU_PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XeusuUsuar xeusuUsuar;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO")
    @ManyToOne(optional = false)
    private XeusuUsuar peempCodigo;

    public XeestEstado() {
    }

    public XeestEstado(XeestEstadoPK xeestEstadoPK) {
        this.xeestEstadoPK = xeestEstadoPK;
    }

    public XeestEstado(XeestEstadoPK xeestEstadoPK, String xeestDescri) {
        this.xeestEstadoPK = xeestEstadoPK;
        this.xeestDescri = xeestDescri;
    }

    public XeestEstado(String xeuPeempCodigo, Character xeestCodigo) {
        this.xeestEstadoPK = new XeestEstadoPK(xeuPeempCodigo, xeestCodigo);
    }

    public XeestEstadoPK getXeestEstadoPK() {
        return xeestEstadoPK;
    }

    public void setXeestEstadoPK(XeestEstadoPK xeestEstadoPK) {
        this.xeestEstadoPK = xeestEstadoPK;
    }

    public String getXeestDescri() {
        return xeestDescri;
    }

    public void setXeestDescri(String xeestDescri) {
        this.xeestDescri = xeestDescri;
    }

    @XmlTransient
    public Collection<XesisSistem> getXesisSistemCollection() {
        return xesisSistemCollection;
    }

    public void setXesisSistemCollection(Collection<XesisSistem> xesisSistemCollection) {
        this.xesisSistemCollection = xesisSistemCollection;
    }

    public XeusuUsuar getXeusuUsuar() {
        return xeusuUsuar;
    }

    public void setXeusuUsuar(XeusuUsuar xeusuUsuar) {
        this.xeusuUsuar = xeusuUsuar;
    }

    public XeusuUsuar getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(XeusuUsuar peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeestEstadoPK != null ? xeestEstadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeestEstado)) {
            return false;
        }
        XeestEstado other = (XeestEstado) object;
        if ((this.xeestEstadoPK == null && other.xeestEstadoPK != null) || (this.xeestEstadoPK != null && !this.xeestEstadoPK.equals(other.xeestEstadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeestEstado[ xeestEstadoPK=" + xeestEstadoPK + " ]";
    }
    
}
