/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "xeuxp_usuper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeuxpUsuper.findAll", query = "SELECT x FROM XeuxpUsuper x")
    , @NamedQuery(name = "XeuxpUsuper.findByPeempCodigo", query = "SELECT x FROM XeuxpUsuper x WHERE x.xeuxpUsuperPK.peempCodigo = :peempCodigo")
    , @NamedQuery(name = "XeuxpUsuper.findByXeuxpFecasi", query = "SELECT x FROM XeuxpUsuper x WHERE x.xeuxpUsuperPK.xeuxpFecasi = :xeuxpFecasi")
    , @NamedQuery(name = "XeuxpUsuper.findByXeuxpFeccam", query = "SELECT x FROM XeuxpUsuper x WHERE x.xeuxpFeccam = :xeuxpFeccam")})
public class XeuxpUsuper implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XeuxpUsuperPK xeuxpUsuperPK;
    @Column(name = "XEUXP_FECCAM")
    @Temporal(TemporalType.DATE)
    private Date xeuxpFeccam;
    @JoinColumn(name = "PEEMP_CODIGO", referencedColumnName = "PEEMP_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XeusuUsuar xeusuUsuar;

    public XeuxpUsuper() {
    }

    public XeuxpUsuper(XeuxpUsuperPK xeuxpUsuperPK) {
        this.xeuxpUsuperPK = xeuxpUsuperPK;
    }

    public XeuxpUsuper(String peempCodigo, Date xeuxpFecasi) {
        this.xeuxpUsuperPK = new XeuxpUsuperPK(peempCodigo, xeuxpFecasi);
    }

    public XeuxpUsuperPK getXeuxpUsuperPK() {
        return xeuxpUsuperPK;
    }

    public void setXeuxpUsuperPK(XeuxpUsuperPK xeuxpUsuperPK) {
        this.xeuxpUsuperPK = xeuxpUsuperPK;
    }

    public Date getXeuxpFeccam() {
        return xeuxpFeccam;
    }

    public void setXeuxpFeccam(Date xeuxpFeccam) {
        this.xeuxpFeccam = xeuxpFeccam;
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
        hash += (xeuxpUsuperPK != null ? xeuxpUsuperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeuxpUsuper)) {
            return false;
        }
        XeuxpUsuper other = (XeuxpUsuper) object;
        if ((this.xeuxpUsuperPK == null && other.xeuxpUsuperPK != null) || (this.xeuxpUsuperPK != null && !this.xeuxpUsuperPK.equals(other.xeuxpUsuperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeuxpUsuper[ xeuxpUsuperPK=" + xeuxpUsuperPK + " ]";
    }
    
}
