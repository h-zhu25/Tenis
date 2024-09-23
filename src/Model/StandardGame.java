package Model;

public class StandardGame extends Game {

    public StandardGame(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public void play() {
        while (winner == null) {
            // 手动输入分数并判断
            displayScore();
            winner = determineWinner();
        }
        System.out.println("Winner of the game: " + winner.getName());
    }
}

