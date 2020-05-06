/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import selfmade.StepType;

/**
 *
 * @author MkSavin
 */
@Stateless
public class StepTypeFacade extends AbstractFacade<StepType> implements StepTypeFacadeLocal {

    @PersistenceContext(unitName = "L8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StepTypeFacade() {
        super(StepType.class);
    }
    
}
