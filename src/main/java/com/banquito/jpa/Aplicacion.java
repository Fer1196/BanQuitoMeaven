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
import javax.persistence.ManyToMany;
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
@Table(name = "aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a")
    , @NamedQuery(name = "Aplicacion.findByCodigoAplicacion", query = "SELECT a FROM Aplicacion a WHERE a.codigoAplicacion = :codigoAplicacion")
    , @NamedQuery(name = "Aplicacion.findByNombre", query = "SELECT a FROM Aplicacion a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Aplicacion.findByDescripcionapp", query = "SELECT a FROM Aplicacion a WHERE a.descripcionapp = :descripcionapp")})
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_APLICACION")
    private Long codigoAplicacion;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCIONAPP")
    private String descripcionapp;
    @ManyToMany(mappedBy = "aplicacionCollection")
    private Collection<XeperPerfil2> xeperPerfil2Collection;
    @OneToMany(mappedBy = "codigoAplicacion")
    private Collection<XesisSistem> xesisSistemCollection;

    public Aplicacion() {
    }

    public Aplicacion(Long codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public Long getCodigoAplicacion() {
        return codigoAplicacion;
    }

    public void setCodigoAplicacion(Long codigoAplicacion) {
        this.codigoAplicacion = codigoAplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionapp() {
        return descripcionapp;
    }

    public void setDescripcionapp(String descripcionapp) {
        this.descripcionapp = descripcionapp;
    }

    @XmlTransient
    public Collection<XeperPerfil2> getXeperPerfil2Collection() {
        return xeperPerfil2Collection;
    }

    public void setXeperPerfil2Collection(Collection<XeperPerfil2> xeperPerfil2Collection) {
        this.xeperPerfil2Collection = xeperPerfil2Collection;
    }

    @XmlTransient
    public Collection<XesisSistem> getXesisSistemCollection() {
        return xesisSistemCollection;
    }

    public void setXesisSistemCollection(Collection<XesisSistem> xesisSistemCollection) {
        this.xesisSistemCollection = xesisSistemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAplicacion != null ? codigoAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.codigoAplicacion == null && other.codigoAplicacion != null) || (this.codigoAplicacion != null && !this.codigoAplicacion.equals(other.codigoAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.Aplicacion[ codigoAplicacion=" + codigoAplicacion + " ]";
    }
    
}
