import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        // 修正 2：i <= scores.length → i < scores.length
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        // 修正 4：整數除法 → 轉型為 double
        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

        // 修正 5：清除 nextInt() 留下的換行
        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        // 修正 1：加上分號
        // 修正 3：== 改為 equals()
        if (command.equals("exit")) {
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}