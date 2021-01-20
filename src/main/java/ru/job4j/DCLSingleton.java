package ru.job4j;

public class DCLSingleton {
    private static volatile DCLSingleton ints;

    public static DCLSingleton instOf() {
        if(ints == null) {
            synchronized (DCLSingleton.class) {
                if (ints == null) {
                    ints = new DCLSingleton();
                }
            }
        }
        return ints;
    }

    private DCLSingleton() {
    }
}
