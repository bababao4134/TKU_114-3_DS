import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("請輸入成績（輸入 -1 結束）：");
        while (true) {
            System.out.print("> ");
            int input = sc.nextInt();
            if (input == -1) break;
            if (input < 0 || input > 100) {
                System.out.println("成績必須在 0～100，請重新輸入。");
                continue;
            }
            scores.add(input);
        }

        if (scores.isEmpty()) {
            System.out.println("No scores entered.");
        } else {
            System.out.println("筆數：" + scores.size());
            System.out.printf("平均：%.2f%n", calculateAverage(scores));
            System.out.println("最高：" + findMax(scores));
            System.out.println("最低：" + findMin(scores));
            System.out.println("及格名單：" + filterPassing(scores));
        }

        sc.close();
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        int total = 0;
        for (int s : scores) total += s;
        return (double) total / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);
        for (int s : scores) if (s > max) max = s;
        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);
        for (int s : scores) if (s < min) min = s;
        return min;
    }

    public static ArrayList<Integer> filterPassing(ArrayList<Integer> scores) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int s : scores) if (s >= 60) result.add(s);
        return result;
    }
}