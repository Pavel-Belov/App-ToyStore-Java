package view.commands;

import view.ConsoleUI;

public class GetToysWonList implements Command {
    private ConsoleUI consoleUI;

    public GetToysWonList(ConsoleUI consoleUI) { this.consoleUI = consoleUI; }

    @Override
    public String getDescription() {
        return "Показать разыгранные игрушки";
    }

    @Override
    public void execute() { consoleUI.getToyWonList(); }
}
