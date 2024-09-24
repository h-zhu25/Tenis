package View;

public enum Message {

                PLAYER_CREATED("Player created: %s with id: %d"),
                MATCH_CREATED("Match created between %s and %s with %d sets."),
                PLAYER_SCORED("Who scored? Enter 1 for %s or 2 for %s"),
                MATCH_OVER("Match over. Winner: %s"),
                INVALID_COMMAND("Invalid command."),
                LOGIN_SUCCESS("Login successful."),
                LOGIN_FAILED("Invalid credentials. Please try again.");

                private String message;

                Message(String message) {
                        this.message = message;
                }

                public void write(Object... args) {
                        System.out.printf(message + "%n", args);
                }
        }



