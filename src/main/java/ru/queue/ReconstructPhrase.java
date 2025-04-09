package ru.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder evenString = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            Character element = evenElements.poll();
            if (i % 2 == 0) {
                evenString.append(element);
            }
        }
        return evenString.toString();
    }

    private String getDescendingElements() {
        StringBuilder descendingString = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            descendingString.append(descendingElements.pollLast());
        }
        return descendingString.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }

}
