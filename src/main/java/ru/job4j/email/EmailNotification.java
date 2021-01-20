package ru.job4j.email;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool;

    public EmailNotification(ExecutorService pool) {
        this.pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        pool.submit(new Runnable() {
            @Override
            public void run() {
                new User("name", "user@gmail.com");
            }
        });
    }


    void emailTo(User user) {
        String suject = user.getUsername() + " " + user.getEmail();
        String body = user.getUsername();
    }


    void close() {
        pool.shutdown();
        while (pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void send(String suject, String body, String email) {

    }


}
