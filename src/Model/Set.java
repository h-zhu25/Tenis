package Model;

import java.util.ArrayList;
import java.util.List;

public class Set {

        private Player player1;
        private Player player2;
        private List<Game> games;
        private int player1GamesWon = 0;
        private int player2GamesWon = 0;

        public Set(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
            this.games = new ArrayList<>();
        }

        public void addGame(Game game) {
            games.add(game);
            game.play();

            if (game.getWinner() == player1) {
                player1GamesWon++;
            } else {
                player2GamesWon++;
            }

            // 检查是否需要进入 TieBreakGame

        }

        public String getSetScore() {
            return player1.getName() + " " + player1GamesWon + " - " + player2GamesWon + " " + player2.getName();
        }

        public Player getSetWinner() {
            return player1GamesWon > player2GamesWon ? player1 : player2;
        }
    }


