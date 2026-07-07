import java.util.Scanner;

public class ScoreMenu {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("java：");
        int java = sc.nextInt();

        System.out.println("math：");
        int math = sc.nextInt();
        
        System.out.println("english：");
        int english = sc.nextInt();

        double avg =(java+math+english)/3;

        String pass ;
        if(avg >= 60){
            pass = "pass";
        } else {
            pass = "fail";
        }

        String grade ; 
        if(avg >= 90){
            grade = "A";
        } else if(avg >= 80){
            grade = "B";
        } else if(avg >= 70){
            grade = "C";
        } else if(avg >= 60){
            grade = "D";
        } else {
            grade = "F";
        }

        int choice = 1 ;
        while(choice != 0){
            System.out.println("請輸入選項： 1.顯示平均分數 2.顯示及格狀態 3.顯示等第 0.離開");
            choice = sc.nextInt();
            
            switch(choice){                
                case 1:
                    System.out.println("平均分數："+avg);
                    break;
                case 2:
                    System.out.println("及格狀態："+pass);
                    break;
                case 3:
                    System.out.println("等第："+grade);
                    break;
                case 0:
                    break;
            }
        }
    }
}
/*
課後作業：成績判斷與選單式查詢系統
請在 0707 資料夾中建立：

ScoreMenu.java
檔案中必須使用：

public class ScoreMenu
功能需求
程式必須：

輸入姓名。
輸入 Java、English、Math 三科成績。
計算平均分數。
判斷及格或不及格。
判斷等第。
使用 switch 建立選單：
1：顯示平均分數
2：顯示及格狀態
3：顯示等第
0：離開
使用 while 讓選單可以重複操作，直到輸入 0。
等第規則
平均分數	等第
90 以上	A
80 到 89	B
70 到 79	C
60 到 69	D
未滿 60	F
 */