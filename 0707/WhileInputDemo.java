import java.util.Scanner;
public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("input:");
        int input = sc.nextInt();
        while (input != 0){
            System.out.println(input);
        }
    }
}
/*
課堂實作題
建立 WhileInputDemo.java，使用 Scanner 讀取使用者輸入的整數，只要輸入不是 0，就持續輸出該數字。
 */