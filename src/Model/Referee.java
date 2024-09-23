package Model;

public class Referee {
    private String name;
    private String password;
    private boolean loggedIn;

    public Referee(String name, String password) {
        this.name = name;
        this.password = password;
        this.loggedIn = false;
    }

    public boolean login(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            loggedIn = true;
            System.out.println("Model.Referee " + name + " logged in successfully.");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
        System.out.println("Model.Referee logged out.");
    }
}
