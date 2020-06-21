/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author diego
 */
@Embeddable
public class XeestEstadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "XEU_PEEMP_CODIGO")
    private String xeuPeempCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEEST_CODIGO")
    private Character xeestCodigo;

    public XeestEstadoPK() {
    }

    public XeestEstadoPK(String xeuPeempCodigo, Character xeestCodigo) {
        this.xeuPeempCodigo = xeuPeempCodigo;
        this.xeestCodigo = xeestCodigo;
    }

    public String getXeuPeempCodigo() {
        return xeuPeempCodigo;
    }

    public void setXeuPeempCodigo(String xeuPeempCodigo) {
        this.xeuPeempCodigo = xeuPeempCodigo;
    }

    public Character getXeestCodigo() {
        return xeestCodigo;
    }

    public void setXeestCodigo(Character xeestCodigo) {
        this.xeestCodigo = xeestCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeuPeempCodigo != null ? xeuPeempCodigo.hashCode() : 0);
        hash += (xeestCodigo != null ? xeestCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeestEstadoPK)) {
            return false;
        }
        XeestEstadoPK other = (XeestEstadoPK) object;
        if ((this.xeuPeempCodigo == null && other.xeuPeempCodigo != null) || (this.xeuPeempCodigo != null && !this.xeuPeempCodigo.equals(other.xeuPeempCodigo))) {
            return false;
        }
        if ((this.xeestCodigo == null && other.xeestCodigo != null) || (this.xeestCodigo != null && !this.xeestCodigo.equals(other.xeestCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeestEstadoPK[ xeuPeempCodigo=" + xeuPeempCodigo + ", xeestCodigo=" + xeestCodigo + " ]";
    }
    
}
