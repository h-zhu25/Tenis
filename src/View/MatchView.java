package View;
import Model.Match;
import Model.Player;

public class MatchView {
    public void displayMatchInfo(Match match) {
        String tennisScore ="0";
        Message.MATCH_CREATED.write(match.getPlayers().get(0).getName(), match.getPlayers().get(1).getName(), match.getId());
        System.out.println("date:" + match.getDate());
        for (Player player : match.getPlayers()) {
            String serveMark = player.isServing() && !player.isFault() ? "*" : " ";
            String faultMark = player.isFault() ? "+" : "";
            System.out.printf("%s%s%s: %s %d - - %n", faultMark, serveMark, player.getName(), tennisScore, player.getSetWins()[0]);
    }
    }

    public void displayMatchScore(Match match) {
        String[] tennisScores = { "0", "15", "30", "40", "AD" };
        boolean isGameBall = false;

        for (Player player : match.getPlayers()) {
            Player opponent = match.getPlayers().get((match.getPlayers().indexOf(player) + 1) % match.getPlayers().size());

            String tennisScore;

            if (player.getPoints() >= 3 && opponent.getPoints() >= 3) {
                if (player.getPoints() == opponent.getPoints()) {
                    tennisScore = "40";
                } else if (player.getPoints() > opponent.getPoints()) {
                    tennisScore = "AD";
                    isGameBall = true;
                }
                else if (opponent.getPoints() > player.getPoints()) {

                    tennisScore = "AD";
                    isGameBall = true;
                } else {

                    tennisScore = "40";
                }
            } else {
                if (player.getPoints() <= 3) {
                    tennisScore = tennisScores[player.getPoints()];
                } else {
                    tennisScore = tennisScores[3];
                }
            }

            // 显示分数
            String serveMark = player.isServing() && !player.isFault() ? "*" : " ";  // 发球标记
            String faultMark = player.isFault() ? "+" : "";  // 错误标记
            System.out.printf("%s%s%s: %s %d - - %n", faultMark, serveMark, player.getName(), tennisScore, player.getSetWins()[0]);


        }
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
