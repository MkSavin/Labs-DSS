/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MkSavin
 */
@Stateless
public class RightsFacade extends AbstractFacade<Rights> {

    @PersistenceContext(unitName = "L8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RightsFacade() {
        super(Rights.class);
    }
    
}
