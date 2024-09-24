package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Match {
    private String date;
    private List<Player> players;
    private int[] playerSetWins;
    private boolean serviceFault;
    private int setsCount;
    private int id;


    public Match(int id, List<Player> players, int setsCount) {

        this.id = id;
        this.players = players;
        this.setsCount = setsCount;
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.serviceFault = false;
        this.playerSetWins = new int[players.size()];

        // 设置第一个球员发球
        players.get(0).setServing(true);
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void lackService() {
        serviceFault = !serviceFault;
        displayScore();
    }

    public void pointService() {
        if (!serviceFault) {
            for (Player player : players) {
                if (player.isServing()) {
                    player.winPoint();
                }
            }
        }
        serviceFault = false;
        displayScore();
    }

    public void switchService() {
        for (Player player : players) {
            player.setServing(!player.isServing());
        }
    }

    public void winSet(Player winner) {
        int playerIndex = players.indexOf(winner);
        playerSetWins[playerIndex]++;
    }

    public boolean isMatchOver() {
        for (int wins : playerSetWins) {
            if (wins == setsCount) {
                return true;
            }
        }
        return false;
    }

    public Player getMatchWinner() {
        return playerSetWins[0] > playerSetWins[1] ? players.get(0) : players.get(1);
    }

    public void displayScore() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            String servingMark = player.isServing() ? "*" : " ";
            System.out.println(servingMark + player.getName() + ": " + player.getPoints() + " Sets: " + playerSetWins[i]);
        }
    }






}


