/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import selfmade.StepType;

/**
 *
 * @author MkSavin
 */
@Local
public interface StepTypeFacadeLocal {

    void create(StepType stepType);

    void edit(StepType stepType);

    void remove(StepType stepType);

    StepType find(Object id);

    List<StepType> findAll();

    List<StepType> findRange(int[] range);

    int count();
    
}
