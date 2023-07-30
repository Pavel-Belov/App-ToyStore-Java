package model.toy;

import model.toy_store.ToyItem;
import model.toy_store.ToyStore;

import java.io.Serializable;

public class Toy extends ToyStore implements Serializable, ToyItem<Toy> {
    private int toyId;
    private String toyNme;
    private int toyWeight;

    public Toy(int toyId, String toyNme, int toyWeight) {
        this.toyId = toyId;
        this.toyNme = toyNme;
        this.toyWeight = toyWeight;
    }

    public Integer getToyId() { return toyId; }

    public String getToyName() { return toyNme; }

    public Integer getToyWeight() { return toyWeight; }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getToyInfo()).append("\n");
        return stringBuilder.toString();
    }

    public String getToyInfo() {
        String toyInfo = "id=" + toyId + ", name=" + toyNme + ", weight=" + toyWeight;
        return toyInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Toy toy)) {
            return false;
        }
        if (toy.getToyName().equals(getToyName())) {
            if (toy.getToyWeight().equals(getToyWeight())) {
                if (toy.getToyId() != getToyId()) {
                    return false;
                }
            }
        }
        return toy.getToyId().equals(getToyId());
    }

    public String getNotFoundInfo() {
        return "Такой игрушки в магазине нет";
    }
}
