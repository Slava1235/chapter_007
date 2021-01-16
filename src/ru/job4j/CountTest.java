package ru.job4j;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CountTest {
    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();

        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(count.get(), CoreMatchers.is(2));
    }
}