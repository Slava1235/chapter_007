package ru.job4j.concurrent;


public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        int index = 0;
                        for (int i = 0; i < 100; i++) {
                            Thread.sleep(1000);
                            index++;
                            System.out.println("\rLoading : " + index + "%");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
    }
}