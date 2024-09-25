package View;
import Model.Match;
import Model.Player;



public class MatchView {
    public void displayMatchInfo(Match match) {
        Message.MATCH_CREATED.write(match.getPlayers().get(0).getName(), match.getPlayers().get(1).getName(), match.getId());
        System.out.println("date:" + match.getDate());
    }

    public void displayMatchScore(Match match) {
        for (Player player : match.getPlayers()) {
            String serveMark = player.isServing() ? "*" : "";
            System.out.printf("%s%s: %d %d - - %n", serveMark, player.getName(), player.getPoints(), player.getSetWins()[0]);
        }
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
