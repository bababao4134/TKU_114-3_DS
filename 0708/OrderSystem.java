import java.util.Scanner;
public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalprice = 0 ;
        int totalquantity = 0 ;
        int option = -1 ;
        
        while(option != 0) {
            System.out.println("選項    商品    單價");
            System.out.println("1    Black tea    30");
            System.out.println("2    Green tea    35");
            System.out.println("3    Coffee    50");
            System.out.println("0    Checkout");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch(option) {
                case 1:
                    System.out.print("請輸入數量：");
                    int quantity1 = sc.nextInt();
                    while(quantity1 <= 0) {
                        System.out.print("請重新輸入（大於0）：");
                        quantity1 = sc.nextInt();
                    }
                    totalprice += quantity1 * 30;
                    totalquantity += quantity1;
                    break;
                case 2:
                    System.out.print("請輸入數量：");
                    int quantity2 = sc.nextInt();
                    while(quantity2 <= 0) {
                        System.out.print("請重新輸入（大於0）：");
                        quantity2 = sc.nextInt();
                    }
                    totalprice += quantity2 * 35;
                    totalquantity += quantity2;
                    break;
                case 3:
                    System.out.print("請輸入數量：");
                    int quantity3 = sc.nextInt();
                    while(quantity3 <= 0) {
                        System.out.print("請重新輸入（大於0）：");
                        quantity3 = sc.nextInt();
                    }
                    totalprice += quantity3 * 50;
                    totalquantity += quantity3;
                    break;
            }
        }
        System.out.println("總數量：" + totalquantity);
        System.out.println("總金額：" + totalprice);
    }
}
/*
課堂實作題
建立 OrderSystem.java，完成簡易點餐系統。

商品：

選項	商品	單價
1	Black tea	30
2	Green tea	35
3	Coffee	50
0	Checkout	結帳
功能要求：

顯示選單。
使用者輸入商品選項。
若選擇 1、2、3，要求輸入數量。
數量必須大於 0。
計算本次小計。
累加總數量與總金額。
選擇 0 時輸出總數量與總金額。
 */