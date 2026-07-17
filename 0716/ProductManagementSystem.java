// ProductManagementSystem.java
import java.util.Scanner;

public class ProductManagementSystem {

    static Product[] products = new Product[10];
    static int       count    = 0;

    // 操作統計
    static int sellCount    = 0;
    static int restockCount = 0;
    static int priceChange  = 0;
    static int addCount     = 0;

    public static void main(String[] args) {
        // 初始 5 項商品
        products[count++] = new Product("Keyboard",  890,  12);
        products[count++] = new Product("Mouse",     490,  20);
        products[count++] = new Product("Monitor",  5200,   5);
        products[count++] = new Product("USB Cable", 250,  30);
        products[count++] = new Product("Headset",  1290,   8);

        Scanner sc     = new Scanner(System.in);
        int     option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: printAll();                   break;
                case 2: searchByName(sc);             break;
                case 3: addProduct(sc);               break;
                case 4: sellProduct(sc);              break;
                case 5: restockProduct(sc);           break;
                case 6: changePrice(sc);              break;
                case 7: printLowStock();              break;
                case 8: printTotalValue();            break;
                case 0: System.out.println("結束。"); break;
                default: System.out.println("無效選項。");
            }
        }

        printSummary();
        sc.close();
    }

    // ── 選單 ────────────────────────────────────────
    static void printMenu() {
        System.out.println("\n=== 商品管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依名稱搜尋");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改價格");
        System.out.println("7. 顯示低庫存商品");
        System.out.println("8. 顯示庫存總價值");
        System.out.println("0. 結束");
    }

    // ── 顯示全部 ────────────────────────────────────
    static void printAll() {
        System.out.println("編號  商品資訊");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".  " + products[i]);
        }
    }

    // ── 搜尋 ────────────────────────────────────────
    static void searchByName(Scanner sc) {
        System.out.print("請輸入商品名稱：");
        String keyword = sc.nextLine();
        Product found  = findProduct(keyword);
        if (found != null) {
            System.out.println("找到：" + found);
        } else {
            System.out.println("找不到「" + keyword.trim() + "」。");
        }
    }

    // ── 新增商品 ────────────────────────────────────
    static void addProduct(Scanner sc) {
        if (count >= products.length) {
            System.out.println("商品已滿，無法新增。");
            return;
        }

        System.out.print("請輸入名稱：");
        String name = sc.nextLine();

        System.out.print("請輸入價格：");
        int price = sc.nextInt();

        System.out.print("請輸入庫存：");
        int stock = sc.nextInt();
        sc.nextLine();

        products[count++] = new Product(name, price, stock);
        addCount++;
        System.out.println("新增成功：" + products[count - 1]);
    }

    // ── 出售商品 ────────────────────────────────────
    static void sellProduct(Scanner sc) {
        System.out.print("請輸入商品名稱：");
        String  name  = sc.nextLine();
        Product found = findProduct(name);

        if (found == null) {
            System.out.println("找不到商品。");
            return;
        }

        System.out.print("請輸入數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (found.sell(qty)) {
            sellCount++;
            System.out.println("出售成功：" + found);
        } else {
            System.out.println("失敗：數量不合法或庫存不足（庫存 "
                    + found.getStock() + "）。");
        }
    }

    // ── 補充庫存 ────────────────────────────────────
    static void restockProduct(Scanner sc) {
        System.out.print("請輸入商品名稱：");
        String  name  = sc.nextLine();
        Product found = findProduct(name);

        if (found == null) {
            System.out.println("找不到商品。");
            return;
        }

        System.out.print("請輸入補貨數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (found.restock(qty)) {
            restockCount++;
            System.out.println("補貨成功：" + found);
        } else {
            System.out.println("失敗：數量必須大於 0。");
        }
    }

    // ── 修改價格 ────────────────────────────────────
    static void changePrice(Scanner sc) {
        System.out.print("請輸入商品名稱：");
        String  name  = sc.nextLine();
        Product found = findProduct(name);

        if (found == null) {
            System.out.println("找不到商品。");
            return;
        }

        System.out.print("請輸入新價格：");
        int price = sc.nextInt();
        sc.nextLine();

        if (found.setPrice(price)) {
            priceChange++;
            System.out.println("修改成功：" + found);
        } else {
            System.out.println("失敗：價格必須大於 0。");
        }
    }

    // ── 低庫存 ──────────────────────────────────────
    static void printLowStock() {
        System.out.println("=== 低庫存商品（庫存 < 10）===");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (products[i].isLowStock()) {
                System.out.println((i + 1) + ".  " + products[i]);
                found = true;
            }
        }
        if (!found) System.out.println("目前無低庫存商品。");
    }

    // ── 庫存總價值 ──────────────────────────────────
    static void printTotalValue() {
        long total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getInventoryValue();
        }
        System.out.println("庫存總價值：$" + total);
    }

    // ── 結束摘要 ────────────────────────────────────
    static void printSummary() {
        long total = 0;
        for (int i = 0; i < count; i++) total += products[i].getInventoryValue();

        System.out.println("\n=== 操作摘要 ===");
        System.out.println("新增商品次數：" + addCount);
        System.out.println("出售次數：" +     sellCount);
        System.out.println("補貨次數：" +     restockCount);
        System.out.println("改價次數：" +     priceChange);
        System.out.println("目前商品數：" +   count);
        System.out.println("最終庫存總價值：$" + total);
    }

    // ── 輔助：依名稱搜尋（忽略大小寫與前後空白）──────
    static Product findProduct(String name) {
        String trimmed = name.trim();
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(trimmed)) {
                return products[i];
            }
        }
        return null;
    }
}