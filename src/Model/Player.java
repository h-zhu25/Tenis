package Model;

public class Player {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Player(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
