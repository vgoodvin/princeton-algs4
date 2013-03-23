import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deque<Item> implements Iterable<Item> {

    private List<Item> list;

    /**
     * construct an empty deque
     */
    public Deque() {
        list = new LinkedList<Item>();
    }

    /**
     * is the deque empty?
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * return the number of items on the deque
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * insert the item at the front
     * @param item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list.add(0, item);
    }

    /**
     * insert the item at the end
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list.add(item);
    }

    /**
     * delete and return the item at the front
     * @return
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return (Item) list.remove(0);
    }

    /**
     * delete and return the item at the end
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return (Item) list.remove(list.size() - 1);
    }

    private class DequeIterator<E> implements Iterator<E> {
        public boolean hasNext() {
            return size() > 0;
        }
        public E next() {
            if (isEmpty()) {
                throw new java.util.NoSuchElementException();
            }
            return (E) removeFirst();
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /**
     * return an iterator over items in order from front to end
     * @return
     */
    public Iterator<Item> iterator() {
        return this.new DequeIterator<Item>();
    }
}

