package Model;


public class MatchHistory {
    private int matchId;
    private String date;
    private Player opponent;
    private boolean isWinner;
    private int setsWon;
    private int setsLost;

    public MatchHistory(int matchId, String date, Player opponent, boolean isWinner, int setsWon, int setsLost) {
        this.matchId = matchId;
        this.date = date;
        this.opponent = opponent;
        this.isWinner = isWinner;
        this.setsWon = setsWon;
        this.setsLost = setsLost;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getDate() {
        return date;
    }

    public Player getOpponent() {
        return opponent;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public int getSetsLost() {
        return setsLost;
    }

    @Override
    public String toString() {
        String result = isWinner ? "winner" : "looser";
        return "match id:" + matchId + "; date:" + date + "; name:" + opponent.getName() + "; sets:" + setsWon + "/" + setsLost + "; " + result;
    }

}
