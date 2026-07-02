import java.util.Scanner;
public class HealthCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("姓名:");
        String name = sc.nextLine();

        System.out.println("年齡:");
        int age = sc.nextInt();

        System.out.println("身高，單位為公尺:");
        double height = sc.nextDouble();

        System.out.println("體重，單位為公斤:");
        double weight = sc.nextDouble();

        double BMI = weight/(height*height);
        System.out.println();
        System.out.println("=== 個人健康資料 ===");
        System.out.println("姓名:"+name);
        System.out.println("年齡:"+age);
        System.out.println("身高:"+height);
        System.out.println("體重:"+weight);
        System.out.println("BMI計算結果:"+BMI);
    }
}
/*
請在 0702 資料夾中建立：

HealthCalculator.java
檔案中必須使用：

public class HealthCalculator
請撰寫一個 Java 程式，讓使用者輸入個人資料並計算 BMI。

功能需求
程式必須讀取：

姓名
年齡
身高，單位為公尺
體重，單位為公斤
程式必須輸出：

姓名
年齡
身高
體重
BMI 計算結果
輸出範例
請輸入姓名：Pei
請輸入年齡：20
請輸入身高（公尺）：1.75
請輸入體重（公斤）：68

=== 個人健康資料 ===
姓名：Pei
年齡：20
身高：1.75
體重：68.0
BMI：22.20408163265306
 */