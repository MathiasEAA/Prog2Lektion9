package opgave03.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArrayListRing<T> implements Ring<T> {

    ArrayList<T> ringList = new ArrayList<>();
    T currentItem = null;

    public ArrayList<T> debugGetArrayList() {
        return new ArrayList<>(ringList);
    }

    public T debugGet(int index) {
        return ringList.get(index);
    }
    @Override
    public void advance() {
        int currentItemIndex = ringList.indexOf(currentItem);
        if (!isEmpty() && ringList.indexOf(currentItem) + 1 == ringList.size()) {
            if (currentItemIndex + 1 == ringList.size()) {
                currentItem = ringList.get(0);
            }
        } else if (!isEmpty()){
            currentItem = ringList.get(currentItemIndex + 1);
        }
    }

    @Override
    public T getCurrentItem() {
        return currentItem;
    }

    @Override
    public void add(T item) {
        ringList.add(item);
        currentItem = item;
    }

    @Override
    public boolean removeItem(Object item) {
        boolean removed = false;
        if (ringList.contains((T) item) && currentItem.equals(item)) {
            advance();
            ringList.remove((T) item);
            removed = true;
        } else if (ringList.contains((T) item)) {
            ringList.remove((T) item);
            removed = true;
        }
        return removed;
    }

    @Override
    public T removeCurrentItem() {
        if (!ringList.isEmpty()) {
            T item = currentItem;
            ringList.remove(currentItem);
            advance();
            return item;
        }
        return null;
    }

    @Override
    public int size() {
        return ringList.size();
    }

    @Override
    public boolean isEmpty() {
        return ringList.isEmpty();
    }

    @Override
    public void map(Function<T,T> function) {
        int index = ringList.indexOf(currentItem);
        ringList.replaceAll(t -> function.apply(t));
        this.currentItem = ringList.get(index);
    }

    @Override
    public ArrayListRing<T> where(Predicate<T> predicate) {
        ArrayListRing<T> returnArray = new ArrayListRing<>();

        for (T ringItem : ringList) {
            if (predicate.test(ringItem)) {
                returnArray.add(ringItem);
            }
        }

        return returnArray;
    }

    @Override
    public String toString() {
        return ringList.toString();
    }
}
