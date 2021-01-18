package ru.job4j;


import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    private final HashMap<Integer, User> userMap = new HashMap<>();

    public synchronized boolean add(User user) {
        userMap.putIfAbsent(user.getId(), user);
        return userMap.containsValue(user);
    }

    public synchronized boolean update(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            return true;
        }
        return false;
    }


    public synchronized boolean delete(User user) {
        if (userMap.containsKey(user.getId()) && user.equals(userMap.get(user.getId()))) {
            userMap.remove(user.getId());
            return true;
        }
        return false;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User from = userMap.get(fromId);
        User to = userMap.get(toId);

        if (from != null && to != null && from.getAmount() >= amount) {
            from.setAmount(to.getAmount() + amount);
            to.setAmount(to.getAmount() + amount);

        }
    }


    public static void main(String[] args) {
        UserStorage stoge = new UserStorage();

        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));

        stoge.transfer(1, 2, 50);
    }
}
