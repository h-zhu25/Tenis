package View;

public enum Message {

                PLAYER_CREATED("Player created: %s with id: %d"),
                REFEREE_CREATED("Referee created: %s"),
                MATCH_CREATED("Match created between %s and %s with %d sets."),
                LOGIN_SUCCESS("Login successful."),
                LOGIN_FAILED("Invalid credentials. Please try again."),
                GAME_BALL("Game ball!!!"),
                MATCH_BALL("Match ball!!!"),
                TIE_BREAK("Tie break!!!");
                private String message;

                Message(String message) {
                        this.message = message;
                }

                public void write(Object... args) {
                        System.out.printf(message + "%n", args);
                }
        }



