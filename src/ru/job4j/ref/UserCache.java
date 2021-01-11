package ru.job4j.ref;

import net.jcip.annotations.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@NotThreadSafe
public class UserCache {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));

    }

    public User findById(int id) {
        return User.of(users.get(id).getName());
    }


    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(User.of(users.values().toString()));
        return userList;
    }
}

