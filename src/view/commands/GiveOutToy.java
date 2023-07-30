package view.commands;

import view.ConsoleUI;

public class GiveOutToy implements Command {
    private ConsoleUI consoleUi;

    public GiveOutToy(ConsoleUI consoleUi) { this.consoleUi = consoleUi; }

    @Override
    public String getDescription() { return "Забрать игрушку"; }

    @Override
    public void execute() { this.consoleUi.giveOutToy(); }
}