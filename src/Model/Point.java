package Model;

public class Point {

    private Player scorer;
    private boolean isAce;
    private boolean isDoubleFault;

    public Point(Player scorer, boolean isAce, boolean isDoubleFault) {
        this.scorer = scorer;
        this.isAce = isAce;
        this.isDoubleFault = isDoubleFault;
    }

    public Player getScorer() {
        return scorer;
    }

    public boolean isAce() {
        return isAce;
    }

    public boolean isDoubleFault() {
        return isDoubleFault;
    }

    @Override
    public String toString() {
        return "Scorer: " + scorer.getName() + ", Ace: " + isAce + ", Double Fault: " + isDoubleFault;
    }
    }


