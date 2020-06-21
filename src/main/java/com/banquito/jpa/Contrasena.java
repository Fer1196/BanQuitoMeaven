/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "contrasena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrasena.findAll", query = "SELECT c FROM Contrasena c")
    , @NamedQuery(name = "Contrasena.findByContrasenaActual", query = "SELECT c FROM Contrasena c WHERE c.contrasenaActual = :contrasenaActual")
    , @NamedQuery(name = "Contrasena.findByContrasenaPasada", query = "SELECT c FROM Contrasena c WHERE c.contrasenaPasada = :contrasenaPasada")})
public class Contrasena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CONTRASENA_ACTUAL")
    private String contrasenaActual;
    @Size(max = 100)
    @Column(name = "CONTRASENA_PASADA")
    private String contrasenaPasada;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO")
    @ManyToOne(optional = false)
    private XeusuUsuar peempCodigo;

    public Contrasena() {
    }

    public Contrasena(String contrasenaActual) {
        this.contrasenaActual = contrasenaActual;
    }

    public String getContrasenaActual() {
        return contrasenaActual;
    }

    public void setContrasenaActual(String contrasenaActual) {
        this.contrasenaActual = contrasenaActual;
    }

    public String getContrasenaPasada() {
        return contrasenaPasada;
    }

    public void setContrasenaPasada(String contrasenaPasada) {
        this.contrasenaPasada = contrasenaPasada;
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
        hash += (contrasenaActual != null ? contrasenaActual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrasena)) {
            return false;
        }
        Contrasena other = (Contrasena) object;
        if ((this.contrasenaActual == null && other.contrasenaActual != null) || (this.contrasenaActual != null && !this.contrasenaActual.equals(other.contrasenaActual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.Contrasena[ contrasenaActual=" + contrasenaActual + " ]";
    }
    
}
