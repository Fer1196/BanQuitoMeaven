/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.controladores;

import com.banquito.jpa.XevenVentan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class XevenVentanFacade extends AbstractFacade<XevenVentan> {

    @PersistenceContext(unitName = "banquitoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XevenVentanFacade() {
        super(XevenVentan.class);
    }
    
}
