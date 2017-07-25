package dao;

import java.util.HashMap;
import java.util.Map;

public class Parameters {

    private Map<String, Object> map;

    public Parameters() {
        this.map = new HashMap<>();
    }

    public void addParam(String name, Object value){
        map.put(name,value);
    }

    public Map<String, Object> getParameters(){
        return map;
    }
}
