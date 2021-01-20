package ru.job4j.cache;

public class Cache {
    private static Cache cache;
    public synchronized static Cache instOf() {
        if(cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
