import java.util.Scanner;   
public class AtmMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000; 
        int option = -1;

        while(option != 0 ) {
            System.out.println("選單：");
            System.out.println("1：查詢餘額");
            System.out.println("2：存款");
            System.out.println("3：提款");
            System.out.println("0：離開");
            System.out.print("請選擇操作（0-3）：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;
                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = sc.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("存款成功 目前餘額：" + balance);
                    } else {
                        System.out.println("存款金額必須大於0");
                    }
                    break;
                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = sc.nextInt();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("提款成功 目前餘額：" + balance);
                    } else if (withdraw > balance) {
                        System.out.println("提款金額不能大於目前餘額");
                    } else {
                        System.out.println("提款金額必須大於0");
                    }
                    break;
                case 0:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("請重新選擇！");
            }
        } 

        sc.close();
    }
}
/*
功能需求
程式必須提供以下選單：

1：查詢餘額
2：存款
3：提款
0：離開
規則：

初始餘額設定為 1000。
存款金額必須大於 0。
提款金額必須大於 0。
提款金額不能大於目前餘額。
每次操作後顯示必要結果。
使用 while 讓選單可以重複操作。
使用 switch 判斷選項。
 */