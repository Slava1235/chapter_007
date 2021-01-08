package ru.job4j.concurrent;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {
                });
        Thread second = new Thread(
                () -> {
                });
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName());
            System.out.println(second.getName());
        }
        System.out.println("working is finish");
    }
}
