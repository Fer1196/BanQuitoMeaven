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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
@Table(name = "xesis_sistem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XesisSistem.findAll", query = "SELECT x FROM XesisSistem x")
    , @NamedQuery(name = "XesisSistem.findByXesisCodsis", query = "SELECT x FROM XesisSistem x WHERE x.xesisCodsis = :xesisCodsis")
    , @NamedQuery(name = "XesisSistem.findByXesisDescri", query = "SELECT x FROM XesisSistem x WHERE x.xesisDescri = :xesisDescri")})
public class XesisSistem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XESIS_CODSIS")
    private String xesisCodsis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "XESIS_DESCRI")
    private String xesisDescri;
    @ManyToMany(mappedBy = "xesisSistemCollection")
    private Collection<XeusuUsuar> xeusuUsuarCollection;
    @JoinColumn(name = "CODIGO_APLICACION", referencedColumnName = "CODIGO_APLICACION")
    @ManyToOne
    private Aplicacion codigoAplicacion;
    @JoinColumns({
        @JoinColumn(name = "XEU_PEEMP_CODIGO", referencedColumnName = "XEU_PEEMP_CODIGO")
        , @JoinColumn(name = "XEEST_CODIGO", referencedColumnName = "XEEST_CODIGO")})
    @ManyToOne(optional = false)
    private XeestEstado xeestEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xesisCodsis")
    private Collection<XeopcOpcion> xeopcOpcionCollection;

    public XesisSistem() {
    }

    public XesisSistem(String xesisCodsis) {
        this.xesisCodsis = xesisCodsis;
    }

    public XesisSistem(String xesisCodsis, String xesisDescri) {
        this.xesisCodsis = xesisCodsis;
        this.xesisDescri = xesisDescri;
    }

    public String getXesisCodsis() {
        return xesisCodsis;
    }

    public void setXesisCodsis(String xesisCodsis) {
        this.xesisCodsis = xesisCodsis;
    }

    public String getXesisDescri() {
        return xesisDescri;
    }

    public void setXesisDescri(String xesisDescri) {
        this.xesisDescri = xesisDescri;
    }

    @XmlTransient
    public Collection<XeusuUsuar> getXeusuUsuarCollection() {
        return xeusuUsuarCollection;
    }

    public void setXeusuUsuarCollection(Collection<XeusuUsuar> xeusuUsuarCollection) {
        this.xeusuUsuarCollection = xeusuUsuarCollection;
    }

    public Aplicacion getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(Aplicacion codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public XeestEstado getXeestEstado() {
        return xeestEstado;
    }

    public void setXeestEstado(XeestEstado xeestEstado) {
        this.xeestEstado = xeestEstado;
    }

    @XmlTransient
    public Collection<XeopcOpcion> getXeopcOpcionCollection() {
        return xeopcOpcionCollection;
    }

    public void setXeopcOpcionCollection(Collection<XeopcOpcion> xeopcOpcionCollection) {
        this.xeopcOpcionCollection = xeopcOpcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xesisCodsis != null ? xesisCodsis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XesisSistem)) {
            return false;
        }
        XesisSistem other = (XesisSistem) object;
        if ((this.xesisCodsis == null && other.xesisCodsis != null) || (this.xesisCodsis != null && !this.xesisCodsis.equals(other.xesisCodsis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XesisSistem[ xesisCodsis=" + xesisCodsis + " ]";
    }
    
}
