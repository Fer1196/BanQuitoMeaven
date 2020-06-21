/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.controladores;

import com.banquito.jpa.XeuxpUsuper;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class XeuxpUsuperFacade extends AbstractFacade<XeuxpUsuper> {

    @PersistenceContext(unitName = "banquitoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XeuxpUsuperFacade() {
        super(XeuxpUsuper.class);
    }
    
}
