package ru.job4j.modelCache;

import java.util.concurrent.ConcurrentHashMap;

public class ModelCache {
    ConcurrentHashMap<Integer, Base> base = new ConcurrentHashMap<>();

    public int add(Base model){
        base.put(model.getId(), model);
        return model.version++;
    }
   public int update(Base model){
        base.put(model.getId(), model);
       return model.version++;
    }
    public  int delete(Base model){
        base.remove(model);
        return model.version++;
    }
    public class OptimisticException extends RuntimeException {

    }
}
