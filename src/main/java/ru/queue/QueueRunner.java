package ru.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        System.out.println("State of queue after removing: ");
        for (String s : queue) {
            System.out.println(s);
        }
        queue.remove();
        System.out.println();
        System.out.println("State of queue after removing: ");
        for (String s : queue) {
            System.out.println(s);
        }

        Queue<String> queue2 = new LinkedList<>();
        String temp = queue2.poll();
        System.out.println(temp);

        Queue<String> queue3 = new ArrayBlockingQueue<>(3);
        queue3.offer("first");
        queue3.offer("second");
        queue3.offer("third");
        queue3.offer("fourth");
        System.out.println();
        for (String s : queue3) {
            System.out.println(s);
        }

        System.out.println("First element in queue is: " + queue3.peek());
    }
}
