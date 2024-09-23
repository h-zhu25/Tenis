package View;

public enum Message {

        REFEREE_CREATED("Referee %s created."),
        REFEREE_LOGIN_SUCCESS("Referee %s logged in successfully."),
        REFEREE_LOGIN_FAILED("Login failed."),
        REFEREE_LOGOUT("Referee logged out."),
        PLAYER_CREATED("Player %s created."),
        NO_PLAYERS_AVAILABLE("No players available."),
        PLAYER_INFO("name: %s; id: %d"),
        MATCH_CREATED("Match created. Match ID: %d"),
        MATCH_NOT_FOUND("Match not found."),
        REFEREE_LOGIN_REQUIRED("You need to log in as a referee first."),
        NO_REFEREE_CREATED("No referee created yet."),
        INVALID_COMMAND("Invalid command.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public void writeln(Object... args) {
            System.out.println(String.format(this.message, args));
        }

        public void write(Object... args) {
            System.out.print(String.format(this.message, args));
        }
    }

