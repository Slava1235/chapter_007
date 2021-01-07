package ru.job4j.concurrent;

class ConsoleProgress implements Runnable {
    String[] strSlash = {"\\", "|", "/"};
    String strOneSlash;

    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                for (int i = 0; i < strSlash.length; i++) {
                    strOneSlash = strSlash[i];
                    System.out.println("\r load: " + strOneSlash);
                    Thread.sleep(500);
                    if (i == 2) {
                        i = i - 2;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(1); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
       // progress.interrupt(); //
    }
}




