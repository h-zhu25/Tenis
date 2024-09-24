package Model;
import Model.Player;
public class Match {
    private Player player1;
    private Player player2;
    private int totalSets;
    private int currentSet;

    public Match(Player player1, Player player2, int totalSets) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalSets = totalSets;
        this.currentSet = 0;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isSetOver() {
        // 简单规则：一方先到达4分则赢得一局
        return player1.getPoints() >= 4 || player2.getPoints() >= 4;
    }

    public void endSet() {
        currentSet++;
        player1.resetPoints();
        player2.resetPoints();
    }

    public boolean isMatchOver() {
        // 通过局数控制比赛结束
        return currentSet >= totalSets;
    }

    public Player getWinner() {
        return player1.getPoints() > player2.getPoints() ? player1 : player2;
    }
}


