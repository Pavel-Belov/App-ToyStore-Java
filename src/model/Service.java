package model;

import model.file_handler.FileHandler;
import model.toy.Toy;
import model.toy_store.ToyItem;
import model.toy_store.ToyStore;

import java.io.IOException;

public class Service {
    private ToyStore<Toy> toyStore, toysWon;
    private FileHandler fileHandler;

    public Service() {
        this.toyStore = new ToyStore<>();
        this.toysWon = new ToyStore<>();
    }

    public String getToyList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ToyItem toy : toyStore) {
            stringBuilder.append(toy.getInfo());
        }
        return stringBuilder.toString();
    }

    public String getToyWonList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ToyItem toy : toysWon) {
            stringBuilder.append(toy.getInfo());
        }
        return stringBuilder.toString();
    }

    public void addToy(String toyName, Integer toyWeight) {
        int id = getLastToyId() + 1;
        toyStore.addToy(new Toy(id, toyName, toyWeight));
    }

    private int getMaxIdFromToys(ToyStore<Toy> toyList) {
        int maxId = 0;
        for (ToyItem toy : toyList) {
            if (toy.getToyId() >= maxId) {
                maxId = toy.getToyId();
            }
        }
        return maxId;
    }

    private int getLastToyId() {
        int lastId = 0;
        int maxToyStoreId = getMaxIdFromToys(toyStore);
        if (lastId < maxToyStoreId) {
            lastId = maxToyStoreId;
        }
        int maxToysWonId = getMaxIdFromToys(toysWon);
        if (lastId < maxToysWonId) {
            lastId = maxToysWonId;
        }
        int allIds = toyStore.size() + toysWon.size();
        if (allIds > lastId) {
            lastId = allIds;
        }
        return lastId;
    }

    public String getToyById(Integer toyId) {
        return toyStore.getToyById(toyId);
    }

    public String startLottery() {
        Toy toyWon = toyStore.startLottery();
        String toyInfo = toyStore.getToyInfo(toyWon);
        toysWon.addToy(toyWon);
        toyStore.removeToy(toyWon);
        return toyInfo;
    }

    public String giveOutToy() {
        return toysWon.giveOutToy();
    }

    public void saveToyStore(String toyStorePath) throws IOException {
        fileHandler = new FileHandler(toyStorePath);
        fileHandler.save(toyStore);
    }

    public void saveToysWon(String toysWonPath) throws IOException {
        fileHandler = new FileHandler(toysWonPath);
        fileHandler.save(toysWon);
    }

    public void loadToyStore(String toyStorePath) throws IOException, ClassNotFoundException {
        fileHandler = new FileHandler(toyStorePath);
        toyStore = (ToyStore<Toy>) fileHandler.load();
    }

    public void loadToysWon(String toysWonPath) throws IOException, ClassNotFoundException {
        fileHandler = new FileHandler(toysWonPath);
        toysWon = (ToyStore<Toy>) fileHandler.load();
    }
}
