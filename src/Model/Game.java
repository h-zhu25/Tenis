package Model;

public abstract class Game {
    protected Player player1;
    protected Player player2;
    protected Point player1Point;
    protected Point player2Point;
    protected Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Point = new Point();
        this.player2Point = new Point();
    }

    public abstract void play();

    protected Player determineWinner() {
        if (player1Point.getPointType() == PointType.ADVANTAGE) {
            return player1;
        } else if (player2Point.getPointType() == PointType.ADVANTAGE) {
            return player2;
        }
        return null;
    }

    public Player getWinner() {
        return winner;
    }

    public void displayScore() {
        System.out.println(player1.getName() + ": " + player1Point + " | " + player2.getName() + ": " + player2Point);
    }
}
