
import Controller.MatchController;
import Model.Match;
import Model.Player;
import View.ConsoleView;

    public class Main {
        public static void main(String[] args) {
            ConsoleView view = new ConsoleView();

            // 创建玩家
            Player player1 = new Player("Nadal");
            Player player2 = new Player("Alcaraz");

            // 创建比赛
            Match match = new Match(player1, player2, 3);

            // 创建控制器
            MatchController controller = new MatchController(match, view);

            // 开始比赛
            controller.startMatch();
        }
    }



