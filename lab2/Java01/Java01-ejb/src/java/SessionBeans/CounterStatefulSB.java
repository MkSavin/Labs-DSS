package SessionBeans;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@Stateful
@SessionScoped
public class CounterStatefulSB {
    
    int data;
    
    @PostConstruct
    private void init(){
        data = 0;
    }
    
    public int increment() {
        return ++data;
    }
    
    public int get() {
        return data;
    }
    
}
