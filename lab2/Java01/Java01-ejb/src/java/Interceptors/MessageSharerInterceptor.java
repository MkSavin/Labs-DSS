package Interceptors;

import Singleton.DataSharerSingleton;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class MessageSharerInterceptor implements Serializable {
    @EJB
    DataSharerSingleton sharer;

    @AroundInvoke 
    public Object addInterceptor(InvocationContext context) throws Exception {
        sharer.set(123, context.getParameters());
        return context.proceed();
    }

}
