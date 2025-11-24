import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private node first;
    private node last;
    private int size;

    private class node {
        Item item;
        node next;
        node pervious;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        // node x = first;
        // while (x.next != null) {
        //  size++;
        //  x = x.next;

        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item != null) {
            if (first != null) {
                node old_first = first;
                node newnode = new node();
                first = newnode;
                first.item = item;
                first.next = old_first;
                first.pervious = null;
                old_first.pervious = first;
            }
            else {
                node newnode = new node();
                first = newnode;
                last = first;
                first.item = item;
                first.next = null;
                first.pervious = null;
                last.next = null;
                last.pervious = null;
            }
            size++;
        }
        else
            throw new IllegalArgumentException("the item is empty");
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item != null) {
            if (first != null) {
                node oldlast = last;
                node newnode = new node();
                last = newnode;
                last.item = item;
                last.next = null;
                last.pervious = oldlast;
                oldlast.next = last;
            }
            else {
                node newnode = new node();
                first = newnode;
                last = newnode;
                first.item = item;
                first.next = null;
                first.pervious = null;
                last.next = null;
                last.pervious = null;
            }
            size++;
        }
        else
            throw new IllegalArgumentException("the item is empty");
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("the dequeu is empty");
        }
        else if (size == 1) {
            Item item;
            item = first.item;
            first = null;
            last = null;
            size--;
            return item;

        }
        else {
            Item item = null;
            item = first.item;
            first = first.next;
            first.pervious = null;
            size--;
            return item;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (first == null)
            throw new NoSuchElementException("the dequeu is empty");
        else if (size == 1) {
            Item item = last.item;
            first = null;
            last = null;
            size--;
            return item;
        }
        else {
            Item item = last.item;
            // node oldlast = last;
            last = last.pervious;
            last.next = null;
            size--;
            return item;
        }

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<Item> {
        node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements");
            }
            Item item = current.item;
            current = current.next;

            return item;

        }
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> obj = new Deque<>();
        obj.addFirst(4);
        obj.addFirst(3);
        obj.addLast(5);
        obj.addLast(6);
        System.out.println(obj.size);
        int x, y;
        // x = obj.removeFirst();
        // System.out.println(x);
        // y = obj.removeLast();
        // System.out.println(y);
        System.out.println("the size off deque is ");
        System.out.println(obj.size);
        // obj.addLast(null);
        Iterator<Integer> it = obj.iterator();
        while (it.hasNext()) {
            int z = it.next();
            System.out.println(z);
        }

    }
}
