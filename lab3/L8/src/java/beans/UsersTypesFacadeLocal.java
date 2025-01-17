/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import database.UsersTypes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MkSavin
 */
@Local
public interface UsersTypesFacadeLocal {

    void create(UsersTypes usersTypes);

    void edit(UsersTypes usersTypes);

    void remove(UsersTypes usersTypes);

    UsersTypes find(Object id);

    List<UsersTypes> findAll();

    List<UsersTypes> findRange(int[] range);

    int count();
    
}
