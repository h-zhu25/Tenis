package Model;

import java.util.List;
public class Game {

    private List<Player> players;
    private Player winner;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void determineWinner() {
        Player topPlayer = players.get(0);

        for (Player player : players) {
            if (player.getPoints() > topPlayer.getPoints()) {
                topPlayer = player;
            }
        }

        this.winner = topPlayer;
    }

    public Player getWinner() {
        return winner;
    }
    public List<Player> getPlayers() {
        return players;
    }


}
