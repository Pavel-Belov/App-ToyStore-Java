package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean show;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        show = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void run(String toyStorePath, String toysWonPath) throws IOException, ClassNotFoundException {
        print("-----Добро поджаловать в магазин игрушек-----");
        presenter.loadToyStore(toyStorePath);
        presenter.loadToysWon(toysWonPath);
        showMainMenu(toyStorePath, toysWonPath);
    }

    public void stop() {
        this.print("Ещё увидимся! Удачи!");
        this.show = false;
    }

    public void showMainMenu(String toyStorePath, String toysWonPath) throws IOException, ClassNotFoundException {
        while (show) {
            print(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                print("Ошибка ввода");
                continue;
            }
            presenter.saveToyStore(toyStorePath);
            presenter.saveToysWon(toysWonPath);
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scan();
        if (!checkChoiceNumMenu(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private String scan() {
        return scanner.nextLine();
    }

    private boolean checkChoiceNumMenu(String line) {
        if (!isDigitEntered(line)) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    private boolean isDigitEntered(String entered) {
        return entered.matches("-?\\d+(\\.\\d+)?");
    }

    public void addToy() {
        String toyName = addToyName();
        Integer toyWeight = addToyWeight();
        presenter.addToy(toyName, toyWeight);
    }

    private String addToyName() {
        print("Укажите название игрушки");
        String toyName = inputRequiredName();
        return toyName;
    }

    private String inputRequiredName() {
        String toyName = scan();
        return inputNameValidation(toyName);
    }

    private String inputNameValidation(String toyName) {
        while (!checkName(toyName)) {
            print("Ошибка ввода имени игрушки, повторите попытку");
            toyName = scan();
        }
        return toyName;
    }

    private boolean checkName(String name) {
        return name.matches("^\\p{L}+$");
    }


    private Integer addToyWeight() {
        print("Укажите нашс выпадения игрушки (от 1 и выше)");
        return inputRequiredLine();
    }

    public void getToyById() {
        Integer toyId = addToyId();
        presenter.getToyById(toyId);
    }

    private Integer addToyId() {
        print("Укажите id игрушки (от 1 и выше)");
        Integer toyId = inputRequiredLine();
        return toyId;
    }

    private Integer inputRequiredLine() {
        String toyId = scan();
        if (isDigitEntered(toyId)) {
            if (Integer.parseInt(toyId) > 0) {
                return Integer.parseInt(toyId);
            }
        }
        print("Ошибка ввода. Число должно быть от 1 и выше. Повторите попытку");
        return inputRequiredLine();
    }

    public void giveOutToy() {
        print("-----Поздравляем! Вот Ваша игрушка-----");
        presenter.giveOutToy();
    }

    public void startLottery() {
        print("-----Начинаем розыгрыш-----");
        print("-----Игрушка разыграна-----");
        presenter.startLottery();
    }

    public void getToyList() {
        print("-----Список игрушек в магазине-----");
        presenter.getToyList();
    }

    public void getToyWonList() {
        print("-----Список разыгранных игрушек-----");
        presenter.getToyWonList();
    }
}
