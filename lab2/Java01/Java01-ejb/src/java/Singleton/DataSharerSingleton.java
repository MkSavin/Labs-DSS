package Singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class DataSharerSingleton {

    int code;
    Object data;

    @PostConstruct
    public void init() {
        code = 0;
        data = new Object();
    }

    public int getCode() {
        return code;
    }
    public void setCode(int _code) {
        code = _code;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object _data) {
        data = _data;
    }

    public void set(int _code, Object _data) {
        setCode(_code);
        setData(_data);
    }
    
}
