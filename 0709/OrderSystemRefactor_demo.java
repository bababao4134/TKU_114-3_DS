import java.util.Scanner;

public class OrderSystemRefactor_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalprice = 0;
        int totalquantity = 0;
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    int quantity1 = readQuantity(sc, "請輸入數量：");
                    totalprice += calcSubtotal(30, quantity1);
                    totalquantity += quantity1;
                    System.out.println("Subtotal: " + totalprice);
                    break;
                case 2:
                    int quantity2 = readQuantity(sc, "請輸入數量：");
                    totalprice    += calcSubtotal(35, quantity2);
                    totalquantity += quantity2;
                    System.out.println("Subtotal: " + totalprice);
                    break;
                case 3:
                    int quantity3 = readQuantity(sc, "請輸入數量：");
                    totalprice    += calcSubtotal(50, quantity3);
                    totalquantity += quantity3;
                    System.out.println("Subtotal: " + totalprice);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("無效選項，請重新輸入。");
            }
        }

        printReceipt(totalquantity, totalprice);
        sc.close();

    }
    public static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Black tea 30");
        System.out.println("2. Green tea  35");
        System.out.println("3. Coffee 50");
        System.out.println("0. Exit");
    }

    public static int readQuantity(Scanner sc, String message) {
        System.out.println(message);
        int quantity = sc.nextInt();
        while (quantity <= 0) {
            System.out.println("請重新輸入：");
            quantity = sc.nextInt();
        }
        return quantity;
    }

    public static int calcSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalquantity, int totalprice) {
        System.out.println("Total items：" + totalquantity);
        System.out.println("Total amount：" + totalprice);
    }
}
/*
功能需求
程式必須：

保留 7/8 點餐系統功能。
使用 while 建立重複選單。
使用 switch 或方法判斷商品價格。
使用方法顯示選單。
使用方法讀取合法數量。
使用方法計算小計。
使用方法印出收據。
主程式 main 不應塞入所有細節。
 */