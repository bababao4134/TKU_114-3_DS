import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);
        int[] scores = new int[count];

        inputScores(sc, scores);
        printScores(scores);

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int pass = countPass(scores);

        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f%n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + pass);
        System.out.println("不及格人數：" + (scores.length - pass));

        System.out.print("請輸入目標成績：");
        int target = sc.nextInt();
        int index = findIndex(scores, target);

        if (index >= 0) {
            System.out.println(target + " 第一次出現在索引 " + index);
        } else {
            System.out.println("找不到 " + target);
        }

        sc.close();
    }

    public static int readCount(Scanner sc) {
        System.out.print("請輸入資料筆數（1～50）：");
        int count = sc.nextInt();
        while (count < 1 || count > 50) {
            System.out.print("範圍必須在 1～50，請重新輸入：");
            count = sc.nextInt();
        }
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.print("第 " + (i + 1) + " 筆成績（0～100）：");
            int score = sc.nextInt();
            while (score < 0 || score > 100) {
                System.out.print("成績必須在 0～100，請重新輸入：");
                score = sc.nextInt();
            }
            scores[i] = score;
        }
    }

    public static void printScores(int[] scores) {
        System.out.print("所有成績：");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) max = scores[i];
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score >= 60) count++;
        }
        return count;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) return i;
        }
        return -1;
    }
}
/*
程式必須：

輸入資料筆數，範圍為 1 到 50。
建立對應長度的 int[]。
逐筆輸入 0 到 100 的成績，錯誤資料必須重新輸入。
顯示全部成績。
顯示總分、平均、最高分、最低分。
顯示及格與不及格人數。
輸入一個目標成績並顯示第一次出現的索引；找不到要顯示明確訊息。
至少使用 5 個自訂方法。
必要方法：

public static int readCount(Scanner sc)
public static void inputScores(Scanner sc, int[] scores)
public static int calculateTotal(int[] scores)
public static int findMax(int[] scores)
public static int findMin(int[] scores)
public static int countPass(int[] scores)
public static int findIndex(int[] scores, int target)
 */