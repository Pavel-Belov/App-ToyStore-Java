package view.commands;

import view.ConsoleUI;

public class GetToyList implements Command {
    private ConsoleUI consoleUI;

    public GetToyList(ConsoleUI consoleUI) { this.consoleUI = consoleUI; }

    @Override
    public String getDescription() {
        return "Показать магазин игрушек";
    }

    @Override
    public void execute() { consoleUI.getToyList(); }
}
