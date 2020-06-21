/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "pecar_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecarCargo.findAll", query = "SELECT p FROM PecarCargo p")
    , @NamedQuery(name = "PecarCargo.findByPedepCodigo", query = "SELECT p FROM PecarCargo p WHERE p.pecarCargoPK.pedepCodigo = :pedepCodigo")
    , @NamedQuery(name = "PecarCargo.findByPecarCodigo", query = "SELECT p FROM PecarCargo p WHERE p.pecarCargoPK.pecarCodigo = :pecarCodigo")
    , @NamedQuery(name = "PecarCargo.findByPecarDescri", query = "SELECT p FROM PecarCargo p WHERE p.pecarDescri = :pecarDescri")})
public class PecarCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecarCargoPK pecarCargoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PECAR_DESCRI")
    private String pecarDescri;
    @JoinColumn(name = "PEDEP_CODIGO", referencedColumnName = "PEDEP_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PedepDepar pedepDepar;

    public PecarCargo() {
    }

    public PecarCargo(PecarCargoPK pecarCargoPK) {
        this.pecarCargoPK = pecarCargoPK;
    }

    public PecarCargo(PecarCargoPK pecarCargoPK, String pecarDescri) {
        this.pecarCargoPK = pecarCargoPK;
        this.pecarDescri = pecarDescri;
    }

    public PecarCargo(String pedepCodigo, String pecarCodigo) {
        this.pecarCargoPK = new PecarCargoPK(pedepCodigo, pecarCodigo);
    }

    public PecarCargoPK getPecarCargoPK() {
        return pecarCargoPK;
    }

    public void setPecarCargoPK(PecarCargoPK pecarCargoPK) {
        this.pecarCargoPK = pecarCargoPK;
    }

    public String getPecarDescri() {
        return pecarDescri;
    }

    public void setPecarDescri(String pecarDescri) {
        this.pecarDescri = pecarDescri;
    }

    public PedepDepar getPedepDepar() {
        return pedepDepar;
    }

    public void setPedepDepar(PedepDepar pedepDepar) {
        this.pedepDepar = pedepDepar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecarCargoPK != null ? pecarCargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecarCargo)) {
            return false;
        }
        PecarCargo other = (PecarCargo) object;
        if ((this.pecarCargoPK == null && other.pecarCargoPK != null) || (this.pecarCargoPK != null && !this.pecarCargoPK.equals(other.pecarCargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.banquito.jpa.PecarCargo[ pecarCargoPK=" + pecarCargoPK + " ]";
    }
    
}
