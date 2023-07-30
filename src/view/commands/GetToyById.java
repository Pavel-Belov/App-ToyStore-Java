package view.commands;

import view.ConsoleUI;

public class GetToyById implements Command {
    private ConsoleUI consoleUi;

    public GetToyById(ConsoleUI consoleUi) { this.consoleUi = consoleUi; }

    @Override
    public String getDescription() { return "Найти игрушку по id"; }

    @Override
    public void execute() { this.consoleUi.getToyById(); }
}
