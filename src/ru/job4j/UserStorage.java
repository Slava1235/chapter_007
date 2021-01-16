package ru.job4j;


import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    private final HashMap<Integer, Integer> userMap = new HashMap<>();

    public synchronized boolean add(User user) {
        return userMap.putIfAbsent(user.getId(), user.getAmount()) != null;
    }

    public synchronized boolean update(User user) {
        return userMap.putIfAbsent(user.getId(), user.getAmount()) != null;
    }

    public synchronized boolean delete(User user) {
        return userMap.remove(user.getId()) != null;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        if (userMap != null) {
            if (userMap.get(1).intValue() >= 50) {
                fromId = userMap.get(1) - amount;
                toId = userMap.get(2) + amount;

            }
        }
    }

    public static void main(String[] args) {
        UserStorage stoge = new UserStorage();

        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));

        stoge.transfer(1, 2, 50);
    }
}
