package View;
import Model.Match;
import Model.Player;

import javax.swing.*;


public class MatchView {
    public void displayMatchInfo(Match match) {
        String tennisScore ="0";
        Message.MATCH_CREATED.write(match.getPlayers().get(0).getName(), match.getPlayers().get(1).getName(), match.getId());
        System.out.println("date:" + match.getDate());
        for (Player player : match.getPlayers()) {
            String serveMark = player.isServing() && !player.isFault() ? "*" : " ";  // 发球标记
            String faultMark = player.isFault() ? "+" : "";  // 错误标记
            System.out.printf("%s%s%s: %s %d - - %n", faultMark, serveMark, player.getName(), tennisScore, player.getSetWins()[0]);
    }
    }

    public void displayMatchScore(Match match) {
        String[] tennisScores = { "0", "15", "30", "40", "AD" };
        boolean isGameBall = false;  // 标记是否是 Game Ball

        for (Player player : match.getPlayers()) {
            Player opponent = match.getPlayers().get((match.getPlayers().indexOf(player) + 1) % match.getPlayers().size());

            String tennisScore;

            // 处理 Deuce 和 Advantage 状态
            if (player.getPoints() >= 3 && opponent.getPoints() >= 3) {
                if (player.getPoints() == opponent.getPoints()) {
                    // 双方 40-40，进入 Deuce 状态
                    tennisScore = "40";
                } else if (player.getPoints() > opponent.getPoints()) {
                    // 一方领先一分，进入 Advantage 状态
                    tennisScore = "AD";
                    isGameBall = true;  // 进入 Advantage，可能是 Game Ball
                }
                else if (opponent.getPoints() > player.getPoints()) {
                    // 一方领先一分，进入 Advantage 状态
                    tennisScore = "AD";
                    isGameBall = true;  // 进入 Advantage，可能是 Game Ball
                } else {
                    // 对手处于 Advantage 状态，因此显示 40
                    tennisScore = "40";
                }
            } else {
                // 常规比分显示
                if (player.getPoints() <= 3) {
                    tennisScore = tennisScores[player.getPoints()];  // 常规分数
                } else {
                    tennisScore = tennisScores[3];  // 默认显示为 40，避免异常
                }
            }

            // 显示分数
            String serveMark = player.isServing() && !player.isFault() ? "*" : " ";  // 发球标记
            String faultMark = player.isFault() ? "+" : "";  // 错误标记
            System.out.printf("%s%s%s: %s %d - - %n", faultMark, serveMark, player.getName(), tennisScore, player.getSetWins()[0]);


        }

        // 如果是 Game Ball，调用显示逻辑
        if (isGameBall) {
            displayGameBall();
        }
    }





    public void displayMatchWinner(Player winner) {
        System.out.println("Match winner is: " + winner.getName());
    }




    public void displayGameBall() {
        Message.GAME_BALL.write();
    }

    public void displayMatchBall() {
        Message.MATCH_BALL.write();
    }

    public void displayTieBreak() {
        Message.TIE_BREAK.write();
    }
}
