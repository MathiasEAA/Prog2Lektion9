package opgave02.models;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /**
     * Create a bag with the given capacity.
     */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /**
     * Create a bag with capacity 10.
     */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        if (!isFull()) {
            items[size] = newEntry;
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E remove() {
        if (size != 0) {
            E removed = items[size - 1];
            items[size] = null;
            size--;
            return removed;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(E anEntry) {
        boolean removed = false;
        int i = 0;
        while (!removed && i < size) {
            if (items[i].equals(anEntry)) {
                items[i] = null;
                removed = true;
                size--;
            }
            i++;
        }
        return removed;
    }

    @Override
    public void clear() {
        for (E item : items) {
            item = null;
        }
        this.size = 0;
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(anEntry)) {
                total++;
            }
        }
        return total;
    }

    @Override
    public boolean contains(E anEntry) {
        boolean found = false;
        int i = 0;
        while (!found && i < items.length) {
            if (items[i] != null) {
                if (items[i].equals(anEntry)) {
                    found = true;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return found;
    }

    @Override
    public E[] toArray() {
        int length = items.length;
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[length];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        return newArray;
    }
}