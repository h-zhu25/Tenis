package Controller;
import java.util.Scanner;
import Model.Match;
import Model.Player;
import Model.Referee;
import View.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchController {
    private Referee referee;
    private List<Player> players;
    private List<Match> matches;

    public MatchController() {
        players = new ArrayList<>();
    }


    public void createReferee(String name, String password) {
        referee = new Referee(name, password);
    }

    public boolean loginReferee(String name, String password) {
        if (referee != null && referee.login(name, password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    public void createPlayer(String name) {
        int id = players.size() + 1;
        Player player = new Player(name, id);
        players.add(player);
        Message.PLAYER_CREATED.write(name, id);
    }

    public void readPlayers() {
        for (Player player : players) {
            System.out.println("name:" + player.getName() + "; id:" + player.getId());
        }
    }

    public void createMatch(int sets, int playerId1, int playerId2) {
        Player player1 = findPlayerById(playerId1);
        Player player2 = findPlayerById(playerId2);

        if (player1 != null && player2 != null) {
            Match match = new Match(player1, player2, sets);
            matches.add(match);
            System.out.println("Match created between " + player1.getName() + " and " + player2.getName() + " with " + sets + " sets.");
        } else {
            System.out.println("Invalid player IDs.");
        }
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

