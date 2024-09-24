package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Match {
    private String date;
    private List<Player> players;
    private int[] playerSetWins;
    private boolean serviceFault;
    private int setsCount;
    private int id;
    private List<Point> points;
    private boolean tieBreak;
    private final String[] tennisScores = { "0", "15", "30", "40", "AD" };


    public Match(int id, List<Player> players, int setsCount, String date) {
        this.id = id;
        this.players = players;
        this.setsCount = setsCount;
        this.date = date;
        this.serviceFault = false;
        this.playerSetWins = new int[players.size()];
        this.points = new ArrayList<>();
        this.tieBreak = false;

        players.get(0).setServing(true);
        players.get(1).setServing(false);
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
    public boolean isTieBreak() {
        return tieBreak;
    }
    public void startTieBreak() {
        tieBreak = true;
    }
    private String getTennisScore(int points) {
        if (tieBreak) {
            return String.valueOf(points);
        }
        if (points < tennisScores.length) {
            return tennisScores[points];
        }
        return tennisScores[tennisScores.length - 1];
    }
    public void lackService() {
        serviceFault = !serviceFault;
        displayScore();
    }

    public void pointService(boolean isAce, boolean isDoubleFault) {
        for (Player player : players) {
            if (player.isServing()) {
                Point point = new Point(player, isAce, isDoubleFault);
                points.add(point);
                player.winPoint();
                checkGameOver();
                break;
            }
        }
    }
    private void checkGameOver() {
        int p1Points = players.get(0).getPoints();
        int p2Points = players.get(1).getPoints();

        if (!tieBreak && ((p1Points >= 4 && p1Points - p2Points >= 2) || (p2Points >= 4 && p2Points - p1Points >= 2))) {
            Player winner = p1Points > p2Points ? players.get(0) : players.get(1);
            winGame(winner);
            resetPoints();
        } else if (tieBreak && (Math.max(p1Points, p2Points) >= 7 && Math.abs(p1Points - p2Points) >= 2)) {
            Player winner = p1Points > p2Points ? players.get(0) : players.get(1);
            winGame(winner);
            resetPoints();
        }
    }
    private void resetPoints() {
        for (Player player : players) {
            player.resetPoints();
        }
    }

    private void winGame(Player winner) {
        int index = players.indexOf(winner);
        playerSetWins[index]++;
        if (isSetOver()) {
            System.out.println("Set ball!!!");
        }
        if (isMatchOver()) {
            System.out.println("Match ball!!!");
        }
    }

    private boolean isSetOver() {
        for (int wins : playerSetWins) {
            if (wins == setsCount) {
                return true;
            }
        }
        return false;
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
            String tennisScore = getTennisScore(player.getPoints());
            System.out.println(servingMark + player.getName() + ": " + tennisScore + " " + playerSetWins[i] + " - - ");
        }
    }






}


