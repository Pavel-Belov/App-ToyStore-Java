package view.commands;

import view.ConsoleUI;

public class StartLottery implements Command {
    private ConsoleUI consoleUi;

    public StartLottery(ConsoleUI consoleUi) { this.consoleUi = consoleUi; }

    @Override
    public String getDescription() { return "Разыграть игрушку"; }

    @Override
    public void execute() { this.consoleUi.startLottery(); }
}
