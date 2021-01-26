package ru.job4j.producerConsumer;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleBlockingQueueTest {
    @Test
    public void whenCallTwoThreadProducerConsumer() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<Integer>();
        Thread t1 = new Thread(
                () -> {
                    try {
                        simpleBlockingQueue.offer(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        Thread t2 = new Thread(
                () -> {
                    try {
                        simpleBlockingQueue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        assertThat(simpleBlockingQueue.getQueue().size(), is(0));
    }


}