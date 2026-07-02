import java.util.Scanner;
public class ScoreReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("姓名:");
        String name = sc.nextLine();

        System.out.println("Java 成績:");
        int javascore = sc.nextInt();

        System.out.println("English 成績:");
        int englishscore = sc.nextInt();

        System.out.println("Math 成績:");
        int mathscore = sc.nextInt();

        double avg = (javascore+englishscore+mathscore)/3;
        System.out.println();
        System.out.println("=== 成績報表 ===");
        System.out.println("姓名："+name);
        System.out.println("Java:"+javascore);
        System.out.println("English:"+englishscore);
        System.out.println("Math:"+mathscore);
        System.out.println("平均："+avg);
    }
}
/*
在 0702 資料夾中建立：

ScoreReport.java
檔案中必須使用：

public class ScoreReport
撰寫一個 Java 程式，讓使用者輸入：

姓名
Java 成績
English 成績
Math 成績
程式輸出：

姓名
三科成績
平均分數
範例輸出
請輸入姓名：Amy
請輸入 Java 成績：85
請輸入 English 成績：78
請輸入 Math 成績：92

=== 成績報表 ===
姓名：Amy
Java：85
English：78
Math：92
平均：85.0
 */