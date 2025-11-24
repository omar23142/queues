import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private int head;
    private int tail;
    private int current;
    private Item[] array = (Item[]) new Object[1];
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        current = 0;
        head = 0;
        tail = 0;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return array.length == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // resize the array

    private void resize(int capasity) {
        Item[] copy = (Item[]) new Object[capasity];

        for (int i = 0; i < current; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("the item must not be null");
        if (current == array.length)
            resize(2 * array.length);
        array[current++] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("no element to return ");
        Item item;
        int ind;
        ind = StdRandom.uniformInt(size);
        ind = ind % array.length;
        item = array[ind];
        // while (ind < array.length - 1) {
        // array[ind] = array[ind + 1];
        // array[ind + 1] = null;
        // ind++;
        //}
        // System.out.println("array_after_deque: " + Arrays.toString(array));
        array[ind] = array[array.length - 1];
        array[array.length] = null;
        size--;
        if (size > 0 && size == array.length / 4)
            resize(array.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("no element to return ");
        Item item;
        int ind = StdRandom.uniformInt(size);
        item = array[ind];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        int current;
        return new reverseArrayIterator();
    }

    private class reverseArrayIterator implements Iterator<Item> {
        private int y = current;

        public boolean hasNext() {
            return y > 0;
        }

        public Item next() {
            return array[--y];
        }
    }

    public static void main(String[] args) {

    }
}
