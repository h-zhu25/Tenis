package Controller;
import Model.Match;
import Model.Player;
import View.MatchView;
import Model.Referee;
import View.Message;
import java.util.ArrayList;
import java.util.List;
public class MatchController {
    private List<Player> players;
    private Match currentMatch;
    private MatchView matchView;
    private Referee referee;

    public MatchController() {
        players = new ArrayList<>();
        matchView = new MatchView();
    }

    public void createReferee(String name, String password) {
        referee = new Referee(name, password);
        Message.REFEREE_CREATED.write(referee.getName());
    }


    public boolean loginReferee(String name, String password) {
        Referee referee = new Referee(name, password);
        if (referee.login(name, password)) {
            Message.LOGIN_SUCCESS.write();
            return true;
        } else {
            Message.LOGIN_FAILED.write();
            return false;
        }
    }

    public void createPlayer(String name) {
        int id = players.size() + 1;
        Player player = new Player(name, id, 3);
        players.add(player);
        Message.PLAYER_CREATED.write(name, id);
    }

    public void readPlayers() {
        for (Player player : players) {
            System.out.println(player.getName() + "; id:" + player.getId());
        }
    }

    public void createMatch(int sets, int playerId1, int playerId2) {
        Player player1 = findPlayerById(playerId1);
        Player player2 = findPlayerById(playerId2);
        if (player1 != null && player2 != null) {
            List<Player> matchPlayers = new ArrayList<>();
            matchPlayers.add(player1);
            matchPlayers.add(player2);
            currentMatch = new Match(players.size() + 1, matchPlayers, sets, "30/9/2024");
            matchView.displayMatchInfo(currentMatch);
        }
    }

    public void handleService(String command) {
        boolean isAce = command.equals("pointAce");
        boolean isDoubleFault = command.equals("doubleFault");

        if (command.equals("pointService")) {
            currentMatch.pointService(false, false);
        } else if (isAce) {
            currentMatch.pointService(true, false);
        } else if (isDoubleFault) {
            currentMatch.pointService(false, true);
        } else if (command.equals("pointRest")) {
            currentMatch.pointRest();
        }

        matchView.displayMatchScore(currentMatch);

        if (currentMatch.isTieBreak()) {
            matchView.displayTieBreak();
        }
    }
    public void handleLackService() {

            currentMatch.lackService();
            matchView.displayMatchScore(currentMatch);
    }

    private Player findPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }
}

