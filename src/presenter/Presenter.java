package presenter;

import model.Service;
import view.View;

import java.io.IOException;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void getToyList() {
        String toyList = service.getToyList();
        view.print(toyList);
    }

    public void getToyWonList() {
        String toyWonList = service.getToyWonList();
        view.print(toyWonList);
    }

    public void addToy(String toyName, Integer toyWeight) {
        service.addToy(toyName, toyWeight);
    }

    public void getToyById(Integer toyId) {
        String toy = service.getToyById(toyId);
        view.print(toy);
    }

    public void startLottery() {
        String toy = service.startLottery();
        view.print(toy);
    }

    public void giveOutToy() {
        String toy = service.giveOutToy();
        view.print(toy);
    }

    public void loadToyStore(String toyStorePath) throws IOException, ClassNotFoundException {
        service.loadToyStore(toyStorePath);
    }

    public void loadToysWon(String toysWonPath) throws IOException, ClassNotFoundException {
        service.loadToysWon(toysWonPath);
    }

    public void saveToyStore(String toyStorePath) throws IOException {
        service.saveToyStore(toyStorePath);
    }

    public void saveToysWon(String toysWonPath) throws IOException {
        service.saveToysWon(toysWonPath);
    }
}
