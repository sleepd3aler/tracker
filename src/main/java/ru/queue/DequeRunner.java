package ru.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeRunner {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        Iterator<String> iterator = deque.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
