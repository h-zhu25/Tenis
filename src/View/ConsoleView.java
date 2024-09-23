package View;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayScore(String score) {
        System.out.println("Current Score: " + score);
    }
}



