/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.distributed.project.csfourfouronedbtest.ejbs;

import com.distributed.project.csfourfouronedbtest.db.entities.Productcustomattr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author punker
 */
@Stateless
public class ProductcustomattrFacade extends AbstractFacade<Productcustomattr> {
    @PersistenceContext(unitName = "com.distributed.project_csfourfouronedbtest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductcustomattrFacade() {
        super(Productcustomattr.class);
    }
    
}
