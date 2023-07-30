package view.commands;

import view.ConsoleUI;

public class AddToy implements Command {
    private ConsoleUI consoleUI;

    public AddToy(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить игрушку";
    }

    @Override
    public void execute() {
        this.consoleUI.addToy();
    }
}
