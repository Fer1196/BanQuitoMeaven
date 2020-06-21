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
public class XerolRol2PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "XEPER_CODPER")
    private String xeperCodper;

    public XerolRol2PK() {
    }

    public XerolRol2PK(String peempCodigo, String xeperCodper) {
        this.peempCodigo = peempCodigo;
        this.xeperCodper = xeperCodper;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public String getXeperCodper() {
        return xeperCodper;
    }

    public void setXeperCodper(String xeperCodper) {
        this.xeperCodper = xeperCodper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        hash += (xeperCodper != null ? xeperCodper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XerolRol2PK)) {
            return false;
        }
        XerolRol2PK other = (XerolRol2PK) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        if ((this.xeperCodper == null && other.xeperCodper != null) || (this.xeperCodper != null && !this.xeperCodper.equals(other.xeperCodper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XerolRol2PK[ peempCodigo=" + peempCodigo + ", xeperCodper=" + xeperCodper + " ]";
    }
    
}
