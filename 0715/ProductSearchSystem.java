import java.util.Scanner;

public class ProductSearchSystem {

    static String[] names  = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
    static int[]    prices = {890, 490, 5200, 250, 1290};
    static int[]    stocks = {12, 20, 5, 30, 8};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    printAll();
                    break;
                case 2:
                    System.out.print("請輸入完整名稱：");
                    String exact = sc.nextLine();
                    searchExact(exact);
                    break;
                case 3:
                    System.out.print("請輸入關鍵字：");
                    String partial = sc.nextLine();
                    while (partial.trim().isEmpty()) {
                        System.out.print("關鍵字不可為空，請重新輸入：");
                        partial = sc.nextLine();
                    }
                    searchPartial(partial);
                    break;
                case 4:
                    printLongestName();
                    break;
                case 5:
                    System.out.print("請輸入商品名稱：");
                    String pName = sc.nextLine();
                    System.out.print("請輸入搜尋關鍵字：");
                    String kw = sc.nextLine();
                    printKeywordPosition(pName, kw);
                    break;
                case 0:
                    System.out.println("系統結束。");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 商品搜尋系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示名稱最長的商品");
        System.out.println("5. 顯示關鍵字在商品名稱中的位置");
        System.out.println("0. 結束");
    }

    public static void printAll() {
        System.out.println("編號  名稱          單價   庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-4d  %-12s  $%-6d  %d%n",
                    i + 1, names[i], prices[i], stocks[i]);
        }
    }

    public static void searchExact(String keyword) {
        String trimmed = keyword.trim();
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(trimmed)) {
                System.out.printf("找到：[%d] %s  $%d  庫存 %d%n",
                        i + 1, names[i], prices[i], stocks[i]);
                return;
            }
        }
        System.out.println("找不到「" + trimmed + "」。");
    }

    public static void searchPartial(String keyword) {
        String lower = keyword.trim().toLowerCase();
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(lower)) {
                System.out.printf("[%d] %s  $%d  庫存 %d%n",
                        i + 1, names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("找不到含「" + keyword.trim() + "」的商品。");
    }

    // 名稱最長的商品
    public static void printLongestName() {
        int maxIdx = 0;
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > names[maxIdx].length()) maxIdx = i;
        }
        System.out.println("名稱最長：[" + (maxIdx + 1) + "] "
                + names[maxIdx] + "（長度 " + names[maxIdx].length() + "）");
    }

    public static void printKeywordPosition(String productName, String keyword) {
        int idx = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(productName.trim())) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("找不到商品「" + productName.trim() + "」。");
            return;
        }
        int pos = names[idx].toLowerCase()
                            .indexOf(keyword.trim().toLowerCase());
        if (pos == -1) {
            System.out.println("「" + keyword.trim() + "」不存在於「" + names[idx] + "」中。");
        } else {
            System.out.println("「" + keyword.trim() + "」第一次出現在索引 " + pos + "。");
        }
    }
}