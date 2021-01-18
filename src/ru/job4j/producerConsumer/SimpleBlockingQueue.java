package ru.job4j.producerConsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    

    //блокирует продвижение до появления элемента в пустой очереди
    synchronized public void offer(T value) throws InterruptedException {
        while (queue.size() == ) {
            wait();
        }
        queue.add(value);
        notify();
    }

    //блокирует продвижение до тех пор, пока не освободится место в заполненной очереди
    synchronized public T poll() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T result = queue.remove(0);
        notify();
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
       Thread first = new Thread((Runnable) new SimpleBlockingQueue<Integer>());
       Thread second= new Thread((Runnable) new SimpleBlockingQueue<Integer>());
        first.start();
        second.start();

        first.join();
        second.join();
    }
}
