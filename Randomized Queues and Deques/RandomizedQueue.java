import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private List<Item> list;

    /**
     * Construct an empty randomized queue
     */
    public RandomizedQueue() {
        list = new ArrayList<Item>();
    }

    /**
     * Is the queue empty?
     * @return boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * return the number of items on the queue
     * @return integer
     */
    public int size() {
        return list.size();
    }

    /**
     * Add the item
     * @param item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        list.add(item);
    }

    /** 
     * return a random index
     */
    public int randomIndex() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return StdRandom.uniform(size());        
    }
    
    /**
     * delete and return a random item
     * @return
     */
    public Item dequeue() {
        return (Item) list.remove(randomIndex());
    }

    /**
     * return (but do not delete) a random item
     * @return
     */
    public Item sample() {
        return (Item) list.get(randomIndex());
    }

    private class RandomizedQueueIterator<E> implements Iterator<E> {
        public boolean hasNext() {
            return size() > 0;
        }
        public E next() {
            if (isEmpty()) {
                throw new java.util.NoSuchElementException();
            }
            return (E) dequeue();
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /**
     * return an independent iterator over items in random order
     * @return
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>();
    }
}
