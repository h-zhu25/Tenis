package Controller;

import Model.Match;
import Model.Set;
import View.ConsoleView;
import Model.StandardGame;


public class MatchController {

    private Match match;
    private ConsoleView view;

    public MatchController(Match match, ConsoleView view) {
        this.match = match;
        this.view = view;
    }

    public void startMatch() {
        view.displayMessage("Starting Match: " + match.getMatchScore());

        for (int i = 0; i < match.getTotalSets(); i++) {
            Set set = new Set(match.getPlayer1(), match.getPlayer2());
            for (int j = 0; j < 6; j++) {
                // 在这里可以加入 StandardGame 或 TieBreakGame
                StandardGame game = new StandardGame(match.getPlayer1(), match.getPlayer2());
                set.addGame(game);
            }
            match.addSet(set);
            view.displayMessage("Set finished: " + set.getSetScore());
        }

        view.displayMessage("Match Winner: " + match.getMatchWinner().getName());
    }

}
