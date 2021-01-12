package ru.job4j;


import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStorage {
    public synchronized boolean add(User user) {
        return false;
    }

    public synchronized boolean update(User user) {
        return false;
    }

    public synchronized boolean delete(User user) {
        return false;
    }

    public synchronized void transfer(int fromId, int told, int amount) {
    }

    public static void main(String[] args) {
        UserStorage stoge = new UserStorage();
        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));

        stoge.transfer(1, 2, 50);
    }
}
