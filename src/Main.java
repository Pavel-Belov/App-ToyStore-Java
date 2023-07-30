import model.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String toyStorePath = "source/ToyStore.out";
        String toysWonPath = "source/ToysWon.out";

        View view = new ConsoleUI();
        Service service = new Service();

//        createTestStore(service);

        new Presenter(view, service);
        view.run(toyStorePath, toysWonPath);
    }

    public static void createTestStore(Service service) {
        service.addToy("Мяч", 1);
        service.addToy("Кукла", 1);
        service.addToy("Машинка", 1);
        service.addToy("Мишка", 9);
        service.addToy("Котик", 9);
        service.addToy("Домик", 1);
        service.addToy("Говорящая кукла", 1);
        service.addToy("Машинка на управлении", 1);
        service.addToy("Зайчик", 3);
        service.addToy("Собачка", 6);
    }
}