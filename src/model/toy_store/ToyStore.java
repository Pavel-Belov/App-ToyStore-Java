package model.toy_store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStore<T extends ToyItem> implements Serializable, Iterable<T> {
    protected List<T> toyList;

    public ToyStore() {
        toyList = new ArrayList<>();
    }

    public void addToy(T toy) {
        toyList.add(toy);
    }

    public void removeToy(T toy) {
        toyList.remove(toy);
    }

    public String getToyInfo(T toy) {
        if (toy != null) {
            return toy.getInfo();
        } else {
            return "тут косяк";
        }
    }

    public String getToyById(Integer toyId) {
        T toy = getToyObjectById(toyId);
        if (toy != null) {
            return toy.getInfo();
        } else {
            return null;
        }
    }

    public T getToyObjectById(Integer toyId) {
        for (T toy : toyList) {
            if (toy.getToyId() == toyId) {
                return toy;
            }
        }
        return null;
    }

    public T startLottery() {
        int wonId = getWonId();
        T toy = getToyObjectById(wonId);
        return toy;
    }

    private int sumToysWeight() {
        int sumWeights = 0;
        for (T toy : toyList) {
            sumWeights += toy.getToyWeight();
        }
        return sumWeights;
    }

    private int getWonId() {
        double randNum;
        double maxNum = 0;
        int id = 0;
        int sumWeights = sumToysWeight();
        for (T toy : toyList) {
            randNum = Math.random() * toy.getToyWeight() / sumWeights;
            if (randNum >= maxNum) {
                maxNum = randNum;
                id = toy.getToyId();
            }
        }
        return id;
    }

    public String giveOutToy() {
        int elementNum = 0;
        String toyInfo;
        T toy = toyList.get(elementNum);
        if (toy != null) {
            toyInfo = getToyInfo(toy);
        } else {
            toyInfo = null;
        }
        removeToy(toy);
        return toyInfo;
    }

    @Override
    public Iterator<T> iterator() {
        return toyList.iterator();
    }

    public int size() {
        return toyList.size();
    }
}
