/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import selfmade.UserStep;

/**
 *
 * @author MkSavin
 */
@Stateless
public class UserStepFacade extends AbstractFacade<UserStep> implements UserStepFacadeLocal {

    @PersistenceContext(unitName = "L8PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserStepFacade() {
        super(UserStep.class);
    }
    
}
