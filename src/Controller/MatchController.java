package Controller;
import java.util.Scanner;
import Model.Match;
import Model.Player;
import Model.Referee;
public class MatchController {
    private Referee referee;
    private Match match;

    public void createReferee(String name, String password) {
        referee = new Referee(name, password);
    }

    public boolean loginReferee(String name, String password) {
        if (referee != null && referee.login(name, password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    // 从控制台输入球员名字并创建比赛
    public void createMatchFromInput(Scanner scanner) {
        System.out.println("Enter name of Player 1:");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name);

        System.out.println("Enter name of Player 2:");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name);

        // 假设比赛为3局
        match = new Match(player1, player2, 3);
        System.out.println("Match started between " + player1.getName() + " and " + player2.getName());
    }

    // 选择得分的球员并更新比分板
    public void selectPlayerToScore() {
        Scanner scanner = new Scanner(System.in);

        while (!match.isMatchOver()) {
            System.out.println("Who scored? Enter 1 for " + match.getPlayer1().getName() + " or 2 for " + match.getPlayer2().getName());
            int choice = scanner.nextInt();

            if (choice == 1) {
                match.getPlayer1().winPoint();
                updateScoreBoard();
            } else if (choice == 2) {
                match.getPlayer2().winPoint();
                updateScoreBoard();
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            if (match.isSetOver()) {
                match.endSet();
                System.out.println("Set over.");
            }
        }
        System.out.println("Match over. Winner: " + match.getWinner().getName());
    }

    // 更新并显示比分板
    public void updateScoreBoard() {
        System.out.println("Scoreboard:");
        System.out.println(match.getPlayer1().getName() + ": " + match.getPlayer1().getPoints() + " Points");
        System.out.println(match.getPlayer2().getName() + ": " + match.getPlayer2().getPoints() + " Points");
    }
}
