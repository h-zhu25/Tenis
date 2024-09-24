package Model;
public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void winPoint() {
        points++;
    }

    public void resetPoints() {
        points = 0;
    }
}

