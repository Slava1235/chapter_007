package ru.job4j.concurrent;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {
                });
        Thread second = new Thread(
                () -> {
                });
        Thread three = new Thread(
                () -> {
                });
        first.start();
        while (first.getState() != Thread.State.TERMINATED) {
            second.start();
            three.start();
            System.out.println(second.getName());
            System.out.println(three.getName());

        }
        System.out.println(Thread.currentThread().getName() + " working is finish");

    }
}
