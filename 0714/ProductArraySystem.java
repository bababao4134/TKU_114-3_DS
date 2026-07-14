import java.util.Scanner;

public class ProductArraySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names  = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[]    prices = {890, 490, 5200, 250, 1290};
        int[]    stocks = {12, 20, 5, 30, 8};

        int buyCount    = 0;
        int restockCount = 0;
        int option      = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    printAll(names, prices, stocks);
                    break;
                case 2:
                    int id = readProductId(sc, names.length);
                    printProduct(id, names, prices, stocks);
                    break;
                case 3:
                    int buyId = readProductId(sc, names.length);
                    int buyQty = readBuyQty(sc, stocks[buyId]);
                    if (buyQty > 0) {
                        stocks[buyId] -= buyQty;
                        buyCount++;
                        System.out.println("購買成功！剩餘庫存：" + stocks[buyId]);
                    }
                    break;
                case 4:
                    int restockId = readProductId(sc, names.length);
                    int addQty = readPositiveInt(sc, "請輸入補貨數量：");
                    stocks[restockId] += addQty;
                    restockCount++;
                    System.out.println("補貨成功！目前庫存：" + stocks[restockId]);
                    break;
                case 5:
                    printLowStock(names, stocks);
                    break;
                case 6:
                    System.out.println("全部庫存總價值：$" + calculateTotalValue(prices, stocks));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("無效選項，請重新輸入。");
            }
        }

        printSummary(buyCount, restockCount, prices, stocks);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 商品管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依編號查詢商品");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充庫存");
        System.out.println("5. 顯示低庫存商品");
        System.out.println("6. 顯示庫存總價值");
        System.out.println("0. 結束");
    }

    public static void printAll(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n編號  商品名稱        單價    庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-4d  %-14s  $%-6d  %d%n",
                    i + 1, names[i], prices[i], stocks[i]);
        }
    }

    public static void printProduct(int id, String[] names, int[] prices, int[] stocks) {
        System.out.println("商品名稱：" + names[id]);
        System.out.println("單價：$"   + prices[id]);
        System.out.println("庫存："     + stocks[id]);
    }

    public static int readProductId(Scanner sc, int max) {
        System.out.print("請輸入商品編號（1～" + max + "）：");
        int id = sc.nextInt();
        while (id < 1 || id > max) {
            System.out.print("編號必須在 1～" + max + "，請重新輸入：");
            id = sc.nextInt();
        }
        return id - 1;  // 轉成陣列索引
    }

    public static int readBuyQty(Scanner sc, int stock) {
        System.out.print("請輸入購買數量（庫存 " + stock + "）：");
        int qty = sc.nextInt();
        while (qty <= 0 || qty > stock) {
            if (qty <= 0) {
                System.out.print("數量必須大於 0，請重新輸入：");
            } else {
                System.out.print("庫存不足，請重新輸入（最多 " + stock + "）：");
            }
            qty = sc.nextInt();
        }
        return qty;
    }

    public static int readPositiveInt(Scanner sc, String message) {
        System.out.print(message);
        int value = sc.nextInt();
        while (value <= 0) {
            System.out.print("必須大於 0，請重新輸入：");
            value = sc.nextInt();
        }
        return value;
    }

    public static void printLowStock(String[] names, int[] stocks) {
        System.out.println("\n=== 低庫存商品（庫存 < 10）===");
        boolean found = false;
        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i] < 10) {
                System.out.println((i + 1) + ". " + names[i] + "  庫存：" + stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("目前無低庫存商品。");
    }

    public static int calculateTotalValue(int[] prices, int[] stocks) {
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * stocks[i];
        }
        return total;
    }

    public static void printSummary(int buyCount, int restockCount,
            int[] prices, int[] stocks) {
        System.out.println("\n=== 操作摘要 ===");
        System.out.println("購買次數：" + buyCount);
        System.out.println("補貨次數：" + restockCount);
        System.out.println("最終庫存總價值：$" + calculateTotalValue(prices, stocks));
    }
}
/*
使用三個對應陣列：

String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
int[] prices = {890, 490, 5200, 250, 1290};
int[] stocks = {12, 20, 5, 30, 8};
選單功能：

顯示全部商品。
依商品編號查詢。
購買商品並扣除庫存。
補充商品庫存。
顯示低庫存商品，庫存小於 10 視為低庫存。
顯示全部庫存總價值。
結束並顯示操作摘要。
規則：

商品編號從 1 開始顯示，轉成陣列索引時要減 1。
購買數量必須大於 0 且不能超過庫存。
補貨數量必須大於 0。
至少使用 7 個自訂方法。
 */