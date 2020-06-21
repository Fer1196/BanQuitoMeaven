/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author diego
 */
@Embeddable
public class XeuxpUsuperPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PEEMP_CODIGO")
    private String peempCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEUXP_FECASI")
    @Temporal(TemporalType.DATE)
    private Date xeuxpFecasi;

    public XeuxpUsuperPK() {
    }

    public XeuxpUsuperPK(String peempCodigo, Date xeuxpFecasi) {
        this.peempCodigo = peempCodigo;
        this.xeuxpFecasi = xeuxpFecasi;
    }

    public String getPeempCodigo() {
        return peempCodigo;
    }

    public void setPeempCodigo(String peempCodigo) {
        this.peempCodigo = peempCodigo;
    }

    public Date getXeuxpFecasi() {
        return xeuxpFecasi;
    }

    public void setXeuxpFecasi(Date xeuxpFecasi) {
        this.xeuxpFecasi = xeuxpFecasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peempCodigo != null ? peempCodigo.hashCode() : 0);
        hash += (xeuxpFecasi != null ? xeuxpFecasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeuxpUsuperPK)) {
            return false;
        }
        XeuxpUsuperPK other = (XeuxpUsuperPK) object;
        if ((this.peempCodigo == null && other.peempCodigo != null) || (this.peempCodigo != null && !this.peempCodigo.equals(other.peempCodigo))) {
            return false;
        }
        if ((this.xeuxpFecasi == null && other.xeuxpFecasi != null) || (this.xeuxpFecasi != null && !this.xeuxpFecasi.equals(other.xeuxpFecasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeuxpUsuperPK[ peempCodigo=" + peempCodigo + ", xeuxpFecasi=" + xeuxpFecasi + " ]";
    }
    
}
