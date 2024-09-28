package Model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Set {
    private Map<Player, Integer> playerWins; // 记录每个球员的获胜局数
    private final int gamesToWin;

    public Set(List<Player> players, int gamesToWin) {
        this.playerWins = new HashMap<>();
        this.gamesToWin = gamesToWin;

        for (Player player : players) {
            playerWins.put(player, 0);
        }
    }

    public void winGame(Player player) {
        playerWins.put(player, playerWins.get(player) + 1);  // 增加该玩家的胜利局数
    }

    public boolean isSetOver() {
        for (int wins : playerWins.values()) {
            if (wins >= gamesToWin) {  // 判断玩家是否赢得足够局数
                return true;
            }
        }
        return false;
    }

    public Player getSetWinner() {
        Player setWinner = null;
        int maxWins = 0;

        for (Map.Entry<Player, Integer> entry : playerWins.entrySet()) {
            if (entry.getValue() > maxWins) {
                setWinner = entry.getKey();
                maxWins = entry.getValue();
            }
        }

        return setWinner;

    }

    public int getPlayerWins(Player player) {
        return playerWins.get(player);
    }


    }


