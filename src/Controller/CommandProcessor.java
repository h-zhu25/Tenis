package Controller;
import java.util.Scanner;

public class CommandProcessor {
    private MatchController controller;

    public CommandProcessor() {
        this.controller = new MatchController();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">");
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ");
            String commandName = inputParts[0];
            String[] args = inputParts.length > 1 ? inputParts[1].split(";") : new String[0];

            try {
                Command command = Command.from(commandName);
                command.execute(args, controller);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command.");
            }
        }
    }

}
