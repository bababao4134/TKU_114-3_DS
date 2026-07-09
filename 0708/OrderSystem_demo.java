import java.util.Scanner;
public class OrderSystem_demo {
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
                    System.out.println("Subtotal: " + totalprice);
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
                    System.out.println("Subtotal: " + totalprice);
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
                    System.out.println("Subtotal: " + totalprice);
                    break;
            }
        }
        System.out.println("Total items：" + totalquantity);
        System.out.println("Total amount：" + totalprice);
    }
}
/*
功能需求
程式必須：

使用 while 建立重複選單。
使用 switch 判斷商品選項。
使用 Scanner 讀取商品選項與數量。
使用輸入驗證確認數量大於 0。
使用累加器計算總金額。
使用計數器計算總數量。
選擇 0 時結帳並結束。
輸出最後總數量與總金額。
輸出範例
=== Order Menu ===
1. Black tea  $30
2. Green tea  $35
3. Coffee     $50
0. Checkout
請輸入選項：1
請輸入數量：2
Subtotal: 60

=== Order Menu ===
1. Black tea  $30
2. Green tea  $35
3. Coffee     $50
0. Checkout
請輸入選項：0

=== Receipt ===
Total items: 2
Total amount: 60
 */