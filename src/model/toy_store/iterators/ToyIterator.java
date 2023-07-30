package model.toy_store.iterators;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<T> implements Iterator<T> {
    private int index = 0;
    private List<T> toyList;

    public ToyIterator(List<T> toyList) {
        this.toyList = toyList;
    }

    @Override
    public boolean hasNext() {
        return index < toyList.size();
    }

    @Override
    public T next() {
        return toyList.get(index++);
    }
}
