package Model;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Player player1;
    private Player player2;
    private List<Set> sets;
    private int totalSets;

    // 新增的变量，用来记录每个玩家赢得的 Set 数量
    private int player1SetsWon;
    private int player2SetsWon;

    public Match(Player player1, Player player2, int totalSets) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalSets = totalSets;
        this.sets = new ArrayList<>();
        this.player1SetsWon = 0; // 初始化为0
        this.player2SetsWon = 0; // 初始化为0
    }

    public int getTotalSets() {
        return totalSets;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void addSet(Set set) {
        sets.add(set);
        if (set.getSetWinner() == player1) {
            player1SetsWon++; // 如果 player1 赢得了 Set，增加计数
        } else if (set.getSetWinner() == player2) {
            player2SetsWon++; // 如果 player2 赢得了 Set，增加计数
        }
    }

    public String getMatchScore() {
        return player1.getName() + " " + player1SetsWon + " - " + player2SetsWon + " " + player2.getName();
    }

    public Player getMatchWinner() {
        if (player1SetsWon > player2SetsWon && player1SetsWon == totalSets / 2 + 1) {
            return player1;
        } else if (player2SetsWon > player1SetsWon && player2SetsWon == totalSets / 2 + 1) {
            return player2;
        }
        return null; // 如果还没有胜者，返回 null
    }
}
