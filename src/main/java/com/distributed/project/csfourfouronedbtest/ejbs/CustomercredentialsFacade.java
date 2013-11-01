/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.ejbs;

import com.distributed.project.csfourfouronedbtest.db.entities.Customercredentials;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author punker
 */
@Stateless
public class CustomercredentialsFacade extends AbstractFacade<Customercredentials> {
    @PersistenceContext(unitName = "com.distributed.project_csfourfouronedbtest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomercredentialsFacade() {
        super(Customercredentials.class);
    }
    
    public Customercredentials findByLogin(String login) {
        List<Customercredentials> cl = em.createNamedQuery("Customercredentials.findByCustomerLogin").setParameter("customerLogin",login).getResultList();
        if(cl.size() > 0)
        return cl.get(0);
        return null;
    }
    
}
