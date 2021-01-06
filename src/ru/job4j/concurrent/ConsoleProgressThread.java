package ru.job4j.concurrent;

class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.print("\r load: " +  " \\|/");
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ConsoleProgressThread {


    public static void main(String[] args) throws InterruptedException {

        Thread progress = new Thread(new ConsoleProgress());
        progress.start();

        Thread.sleep(1); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
        progress.interrupt(); //

    }
}



