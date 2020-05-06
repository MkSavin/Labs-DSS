/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import selfmade.PlayStep;

/**
 *
 * @author MkSavin
 */
@Local
public interface PlayStepFacadeLocal {

    void create(PlayStep playStep);

    void edit(PlayStep playStep);

    void remove(PlayStep playStep);

    PlayStep find(Object id);

    List<PlayStep> findAll();

    List<PlayStep> findRange(int[] range);

    int count();
    
}
