package ru.job4j.modelCache;

public class Base {
    private int id;
    private int version;

    public Base(int id, int version) {
        this.id = id;
        this.version = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}