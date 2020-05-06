/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import selfmade.PlayStep;

/**
 *
 * @author MkSavin
 */
@Stateless
public class PlayStepFacade extends AbstractFacade<PlayStep> implements PlayStepFacadeLocal {

    @PersistenceContext(unitName = "L8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayStepFacade() {
        super(PlayStep.class);
    }
    
}
