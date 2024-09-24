import java.util.Scanner;
import Controller.MatchController;

public class Main {
    public static void main(String[] args) {
        MatchController controller = new MatchController();
        Scanner scanner = new Scanner(System.in);

        // 创建裁判并登录
        controller.createReferee("Molina", "1234");

        System.out.println("Please login as the referee:");
        System.out.print("Enter referee name: ");
        String refName = scanner.nextLine();
        System.out.print("Enter referee password: ");
        String refPassword = scanner.nextLine();

        if (controller.loginReferee(refName, refPassword)) {
            // 让玩家输入名字
            controller.createMatchFromInput(scanner);

            // 选择球员得分并显示比分
            controller.selectPlayerToScore();
        } else {
            System.out.println("Login failed. Exiting.");
        }
    }
}




