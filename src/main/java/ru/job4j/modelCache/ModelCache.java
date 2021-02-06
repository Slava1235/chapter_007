package ru.job4j.modelCache;

import java.util.concurrent.ConcurrentHashMap;

class ModelCache {
    private ConcurrentHashMap<Integer, Base> base = new ConcurrentHashMap<>();


    public void add(Base model) {
        base.put(model.getId(), model);
    }

    public void update(Base model) {
        base.computeIfPresent(model.getId(), (k, v) -> {
            if (base.get(k).getVersion() != model.getVersion()) {
                throw new OptimisticException(" Exception in Thread");
            }
            model.setVersion(model.getVersion() + 1);
            return model;
        });
    }


    public void delete(Base model) {
        base.remove(model.getId(), model);
    }

    public class OptimisticException extends RuntimeException {
        public OptimisticException(String message) {
            super(message);
        }
    }
}