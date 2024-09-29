package Model;

import View.MatchView;
import java.util.List;


public class Match {
    private String date;
    private List<Player> players;
    private int[] playerSetWins;

    private int setsCount;
    private int id;

    private boolean tieBreak;
    private final String[] tennisScores = { "0", "15", "30", "40", "AD" };
    private boolean firstFault = false;
    private MatchView matchView;
    private Set currentSet;
    private int gamesToWinInSet;


    public Match(int id, List<Player> players, int setsCount, String date) {
        this.id = id;
        this.players = players;
        this.setsCount = setsCount;
        this.date = date;
        this.playerSetWins = new int[players.size()];

        this.tieBreak = false;
        this.matchView = new MatchView();
        this.gamesToWinInSet = gamesToWinInSet;
        this.currentSet = new Set(players, gamesToWinInSet);

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
        Player servingPlayer = null;
        for (Player player : players) {
            if (player.isServing()) {
                servingPlayer = player;
                break;
            }
        }
        if (servingPlayer != null) {
            if (!firstFault) {
                firstFault = true;
                servingPlayer.setFault(true);
                System.out.println(servingPlayer.getName());
            } else {
                Player opponent = players.get((players.indexOf(servingPlayer) + 1) % players.size());
                opponent.winPoint();
                System.out.println(opponent.getName());
                firstFault = false;  // Reset fault after second fault
                servingPlayer.setFault(false);
                checkGameOver();  // Check if the game ends due to the point
            }
        }
    }



    public void pointService(boolean isAce, boolean isDoubleFault) {
        for (Player player : players) {
            if (player.isServing()) {
                Player opponent = players.get((players.indexOf(player) + 1) % players.size());

                if (!isDoubleFault) {
                    player.winPoint();

                } else {

                    opponent.winPoint();
                    System.out.println(opponent.getName());
                }

                checkGameOver();
                break;
            }
        }
    }







    private void checkGameOver() {
        int p1Points = players.get(0).getPoints();
        int p2Points = players.get(1).getPoints();
        int pointDifference = Math.abs(p1Points - p2Points);

        // 处理 Deuce 和 Advantage 机制
        if (p1Points >= 3 && p2Points >= 3) {
            if (p1Points == p2Points) {

            } else if (pointDifference == 1) {

             } else if (pointDifference >= 2) {
                // 一方在 Advantage 后获得 2 分差距，赢得比赛
                Player winner = p1Points > p2Points ? players.get(0) : players.get(1);
                resetPoints();
                firstFault = false;

                // 切换发球方
                switchService();;  // 调用 winGame 方法结束比赛
            }
        } else if ((p1Points >= 4 || p2Points >= 4) && pointDifference >= 2) {
            // 没有进入 Deuce 的常规比赛结束
            Player winner = p1Points > p2Points ? players.get(0) : players.get(1);
            winGame(winner);  // 调用 winGame 方法结束比赛
        }
    }




    // Match.java
    public void winGame(Player winner) {


        // 更新当前 set 中的胜利局数
        currentSet.winGame(winner);

        // 判断当前 set 是否结束
        if (currentSet.isSetOver()) {
            Player setWinner = currentSet.getSetWinner();


            // 更新 Player 中赢得的 set 数量
            setWinner.winSet();  // 这里更新玩家赢得的 set 数量

            // 显示当前比分
             // 显示 set 胜利后的状态

            // 判断 Match 是否结束
            if (isMatchOver()) {

                matchView.displayMatchWinner(setWinner);
            } else {
                // 开始新的 set
                currentSet = new Set(players, gamesToWinInSet);
            }
        }

        // 重置当前 game 的分数
        resetPoints();
        firstFault = false;

        // 切换发球方
        switchService();


    }


    public void pointRest() {
        // 找到当前发球球员
        Player servingPlayer = null;
        for (Player player : players) {
            if (player.isServing()) {
                servingPlayer = player;
                break;
            }
        }

        if (servingPlayer != null) {
            // 对手加分
            Player opponent = players.get((players.indexOf(servingPlayer) + 1) % players.size());
            opponent.winPoint();  // 给对方加分
            checkGameOver();
        }
//
    }



    private void resetPoints() {
        for (Player player : players) {
            player.resetPoints();
        }
    }







    public boolean isSetOver() {
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
}


