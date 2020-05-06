/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import selfmade.UserStep;

/**
 *
 * @author MkSavin
 */
@Local
public interface UserStepFacadeLocal {

    void create(UserStep userStep);

    void edit(UserStep userStep);

    void remove(UserStep userStep);

    UserStep find(Object id);

    List<UserStep> findAll();

    List<UserStep> findRange(int[] range);

    int count();
    
}
