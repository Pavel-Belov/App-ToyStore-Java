package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetToyList(consoleUI));
        commandList.add(new GetToysWonList(consoleUI));
        commandList.add(new AddToy(consoleUI));
        commandList.add(new GetToyById(consoleUI));
        commandList.add(new StartLottery(consoleUI));
        commandList.add(new GiveOutToy(consoleUI));
        commandList.add(new Stop(consoleUI));
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commandList.size();
    }
}
