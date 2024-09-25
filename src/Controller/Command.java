package Controller;
import java.util.HashMap;
import java.util.Map;

public enum Command {
    CREATE_REFEREE {
        @Override
        public void execute(String[] args, MatchController controller) {
            String name = getArgument(args, 0);
            String password = getArgument(args, 1);
            controller.createReferee(name, password);
        }
    },
    LOGIN {
        @Override
        public void execute(String[] args, MatchController controller) {
            String name = getArgument(args, 0);
            String password = getArgument(args, 1);
            controller.loginReferee(name, password);
        }
    },
    CREATE_PLAYER {
        @Override
        public void execute(String[] args, MatchController controller) {
            String name = getArgument(args, 0);
            controller.createPlayer(name);
        }
    },
    READ_PLAYERS {
        @Override
        public void execute(String[] args, MatchController controller) {
            controller.readPlayers();
        }
    },
    CREATE_MATCH {
        @Override
        public void execute(String[] args, MatchController controller) {
            int sets = Integer.parseInt(getArgument(args, 0).split(":")[1]);  // 解析 sets 参数
            String[] playerIds = getArgument(args, 1).split(":")[1].split(",");  // 解析 ids 参数
            int playerId1 = Integer.parseInt(playerIds[0]);
            int playerId2 = Integer.parseInt(playerIds[1]);
            controller.createMatch(sets, playerId1, playerId2);  // 调用 MatchController 创建比赛
        }
    },
    POINT_SERVICE {
        @Override
        public void execute(String[] args, MatchController controller) {
            controller.handleService("pointService");
        }
    },
    LACK_SERVICE {
        @Override
        public void execute(String[] args, MatchController controller) {
            controller.handleService("lackService");
        }
    };

    public abstract void execute(String[] args, MatchController controller);

    protected static String getArgument(String[] args, int index) {
        if (index < args.length) {
            return args[index];
        } else {
            throw new IllegalArgumentException("Missing argument at index " + index);
        }
    }

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {
        COMMAND_MAP.put("createReferee", CREATE_REFEREE);
        COMMAND_MAP.put("login", LOGIN);
        COMMAND_MAP.put("createPlayer", CREATE_PLAYER);
        COMMAND_MAP.put("readPlayers", READ_PLAYERS);
        COMMAND_MAP.put("createMatch", CREATE_MATCH);
        COMMAND_MAP.put("pointService", POINT_SERVICE);
        COMMAND_MAP.put("lackService", LACK_SERVICE);
    }

    public static Command from(String commandName) {
        Command command = COMMAND_MAP.get(commandName);
        if (command == null) {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }
        return command;
    }
}

