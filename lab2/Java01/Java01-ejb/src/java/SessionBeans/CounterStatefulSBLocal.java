package SessionBeans;

import javax.ejb.Local;

@Local
public interface CounterStatefulSBLocal {
    	
    public int increment();
    
    public int get();
    
}