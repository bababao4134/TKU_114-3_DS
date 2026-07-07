import java.util.Scanner;
public class HealthAdvisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yn = "y";
        
        while(yn.equals("y")){
            System.out.println("請輸入姓名：");
            String name = sc.next() ;
        
            System.out.println("請輸入身高（公尺）：");
            double height = sc.nextDouble();
        
            System.out.println("請輸入體重（公斤）：");
            double weight = sc.nextDouble();
        
            double bmi = weight / (height * height);

            System.out.println("=== BMI Report ===");
            System.out.println("Name: " + name);
        
            System.out.println("BMI: " + bmi);
            if(bmi < 18.5){
                System.out.println("Underweight");
            } else if(bmi < 24){
                System.out.println("Normal");
            } else if(bmi < 27){
                System.out.println("Overweight");
            } else {
                System.out.println("Obese");
            }

            System.out.println("是否繼續輸入下一筆？(y/n)：");
            yn = sc.next();
        
        }
        sc.close();
    }
}
/*
課堂實作題：BMI 分級系統
請在 0707 資料夾中建立：

HealthAdvisor.java
檔案中必須使用：

public class HealthAdvisor
請撰寫一個 Java 程式，完成 BMI 計算與分級。

功能需求
程式必須：

使用 Scanner 輸入姓名。
輸入身高，單位為公尺。
輸入體重，單位為公斤。
計算 BMI。
使用 if else if else 判斷 BMI 分級。
輸出姓名、BMI 與分級結果。
使用 while 詢問是否繼續輸入下一筆資料。
BMI 分級規則：

BMI	分級
小於 18.5	Underweight
18.5 到未滿 24	Normal
24 到未滿 27	Overweight
27 以上	Obese
輸出範例
請輸入姓名：Amy
請輸入身高（公尺）：1.65
請輸入體重（公斤）：55

=== BMI Report ===
Name: Amy
BMI: 20.202020202020204
Level: Normal

是否繼續輸入下一筆？(y/n)：n
 */