package ru.job4j;

import org.junit.Test;
import ru.job4j.cas.CASCount;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CASCountTest {
    private class ThreadCount extends Thread {
        private final CASCount count;

        public ThreadCount(final CASCount count) {
            this.count =count;
        }
        @Override
        public void run() {
            this.count.increment();
        }
    }
    @Test
    public void when() throws InterruptedException {
        final CASCount count = new CASCount();

        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();

        first.join();
        second.join();

        assertThat(count.get(), is(2));
    }
}