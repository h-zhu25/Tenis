package Model;

public class Referee {
    private String name;
    private String password;


    public Referee(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public boolean login(String inputName, String inputPassword) {
        return name.equals(inputName) && password.equals(inputPassword);
    }
    public String getName() {
        return name;
    }


}
