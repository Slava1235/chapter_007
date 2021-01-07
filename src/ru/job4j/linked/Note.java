package ru.job4j.linked;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
class Node<T> {
    private final Node next;
    private final T value;

    Node(final Node next, final T value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

}