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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "xeope_operfi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XeopeOperfi.findAll", query = "SELECT x FROM XeopeOperfi x")
    , @NamedQuery(name = "XeopeOperfi.findByXeopeFasign", query = "SELECT x FROM XeopeOperfi x WHERE x.xeopeFasign = :xeopeFasign")
    , @NamedQuery(name = "XeopeOperfi.findByXeopeEstado", query = "SELECT x FROM XeopeOperfi x WHERE x.xeopeEstado = :xeopeEstado")})
public class XeopeOperfi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "XEOPE_FASIGN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date xeopeFasign;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "XEOPE_ESTADO")
    private String xeopeEstado;
    @JoinColumn(name = "XEOPC_CODOPC", referencedColumnName = "XEOPC_CODOPC")
    @ManyToOne(optional = false)
    private XeopcOpcion xeopcCodopc;

    public XeopeOperfi() {
    }

    public XeopeOperfi(Date xeopeFasign) {
        this.xeopeFasign = xeopeFasign;
    }

    public XeopeOperfi(Date xeopeFasign, String xeopeEstado) {
        this.xeopeFasign = xeopeFasign;
        this.xeopeEstado = xeopeEstado;
    }

    public Date getXeopeFasign() {
        return xeopeFasign;
    }

    public void setXeopeFasign(Date xeopeFasign) {
        this.xeopeFasign = xeopeFasign;
    }

    public String getXeopeEstado() {
        return xeopeEstado;
    }

    public void setXeopeEstado(String xeopeEstado) {
        this.xeopeEstado = xeopeEstado;
    }

    public XeopcOpcion getXeopcCodopc() {
        return xeopcCodopc;
    }

    public void setXeopcCodopc(XeopcOpcion xeopcCodopc) {
        this.xeopcCodopc = xeopcCodopc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xeopeFasign != null ? xeopeFasign.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XeopeOperfi)) {
            return false;
        }
        XeopeOperfi other = (XeopeOperfi) object;
        if ((this.xeopeFasign == null && other.xeopeFasign != null) || (this.xeopeFasign != null && !this.xeopeFasign.equals(other.xeopeFasign))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.XeopeOperfi[ xeopeFasign=" + xeopeFasign + " ]";
    }
    
}
