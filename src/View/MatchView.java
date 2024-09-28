package View;
import Model.Match;
import Model.Player;



public class MatchView {
    public void displayMatchInfo(Match match) {
        Message.MATCH_CREATED.write(match.getPlayers().get(0).getName(), match.getPlayers().get(1).getName(), match.getId());
        System.out.println("date:" + match.getDate());
    }

    public void displayMatchScore(Match match) {
        String[] tennisScores = { "0", "15", "30", "40", "AD" };
        for (Player player : match.getPlayers()) {
            String serveMark = player.isServing() && !player.isFault() ? "*" : " ";  // 只有发球方且没有失误时显示 *
            String faultMark = player.isFault() ? "+" : "";  // 显示服务失误标记 +
            int points = player.getPoints();
            String tennisScore;

            // 检查 Deuce 和 Advantage 状态
            if (match.getPlayers().get(0).getPoints() == 3 && match.getPlayers().get(1).getPoints() == 3) {
                if (Math.abs(player.getPoints() - match.getPlayers().get((match.getPlayers().indexOf(player) + 1) % match.getPlayers().size()).getPoints()) == 1) {
                    tennisScore = "AD";  // 显示 Advantage 状态
                } else {
                    tennisScore = "40";  // 显示 Deuce 状态
                }
            } else if (points < 4) {
                tennisScore = tennisScores[points];  // 使用常规网球分数
            } else {
                tennisScore = tennisScores[3];  // 默认显示 40
            }

            // 打印当前分数和局数
            System.out.printf("%s%s%s: %s %d - - %n", faultMark, serveMark, player.getName(), tennisScore, player.getSetWins()[0]);
        }
    }
    public void displayMatchWinner(Player winner) {
        System.out.println("Match winner is: " + winner.getName());
    }

    public void displaySetWin(Match match) {
        System.out.println("Set won! Current score: ");
        // 打印每个玩家的总得分和当前局数
        for (Player player : match.getPlayers()) {
            System.out.println(player.getName() + " has won " + player.getSetWins()[0] + " sets.");
        }
        displayMatchScore(match);  // 复用现有的显示逻辑

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
