import java.util.Scanner;

public class ProductDataManager {

    static final int CAPACITY = 20;

    static String[] names  = new String[CAPACITY];
    static int[]    prices = new int[CAPACITY];
    static int[]    stocks = new int[CAPACITY];
    static int      count  = 0;

    public static void main(String[] args) {
        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        parseAll(records);
        printTable();

        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    printTable();
                    break;
                case 2:
                    System.out.print("請輸入完整名稱：");
                    searchExact(sc.nextLine());
                    break;
                case 3:
                    System.out.print("請輸入關鍵字：");
                    searchPartial(sc.nextLine());
                    break;
                case 4:
                    printLowStock();
                    break;
                case 5:
                    System.out.println("庫存總價值：$" + calculateTotalValue());
                    break;
                case 6:
                    System.out.print("請輸入新資料（格式：名稱,價格,庫存）：");
                    addRecord(sc.nextLine());
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

    // 解析所有 records 並存入陣列
    public static void parseAll(String[] records) {
        for (String record : records) {
            parseSingle(record);
        }
    }

    // 解析單筆，回傳是否成功
    public static boolean parseSingle(String record) {
        if (record == null || record.trim().isEmpty()) {
            System.out.println("錯誤：資料為空。");
            return false;
        }

        String[] parts = record.split(",");

        if (parts.length != 3) {
            System.out.println("錯誤：欄位數量不正確（需要 3 欄，實際 "
                    + parts.length + " 欄）：" + record);
            return false;
        }

        String name = parts[0].trim();
        if (name.isEmpty()) {
            System.out.println("錯誤：名稱不可為空。");
            return false;
        }

        try {
            int price = Integer.parseInt(parts[1].trim());
            int stock = Integer.parseInt(parts[2].trim());

            if (price < 0) {
                System.out.println("錯誤：價格不可為負數。");
                return false;
            }
            if (stock < 0) {
                System.out.println("錯誤：庫存不可為負數。");
                return false;
            }

            if (count >= CAPACITY) {
                System.out.println("錯誤：資料已滿，無法新增。");
                return false;
            }

            names[count]  = name;
            prices[count] = price;
            stocks[count] = stock;
            count++;
            return true;

        } catch (NumberFormatException e) {
            System.out.println("錯誤：價格或庫存非整數：" + record);
            return false;
        }
    }

    public static void printMenu() {
        System.out.println("\n=== 商品資料管理器 ===");
        System.out.println("1. 顯示商品表格");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示低庫存商品");
        System.out.println("5. 顯示庫存總價值");
        System.out.println("6. 新增一筆資料");
        System.out.println("0. 結束");
    }

    public static void printTable() {
        System.out.println("\n編號  名稱          單價     庫存");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-4d  %-12s  $%-7d  %d%n",
                    i + 1, names[i], prices[i], stocks[i]);
        }
    }

    // 完整名稱搜尋（忽略大小寫與前後空白）
    public static void searchExact(String keyword) {
        String trimmed = keyword.trim();
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(trimmed)) {
                System.out.printf("找到：[%d] %s  $%d  庫存 %d%n",
                        i + 1, names[i], prices[i], stocks[i]);
                return;
            }
        }
        System.out.println("找不到「" + trimmed + "」。");
    }

    // 部分名稱搜尋（忽略大小寫）
    public static void searchPartial(String keyword) {
        String lower = keyword.trim().toLowerCase();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (names[i].toLowerCase().contains(lower)) {
                System.out.printf("[%d] %s  $%d  庫存 %d%n",
                        i + 1, names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("找不到含「" + keyword.trim() + "」的商品。");
    }

    // 低庫存（庫存 < 10）
    public static void printLowStock() {
        System.out.println("=== 低庫存商品 ===");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (stocks[i] < 10) {
                System.out.printf("[%d] %s  庫存 %d%n",
                        i + 1, names[i], stocks[i]);
                found = true;
            }
        }
        if (!found) System.out.println("目前無低庫存商品。");
    }

    // 庫存總價值
    public static int calculateTotalValue() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i] * stocks[i];
        }
        return total;
    }

    // 輸入並驗證新增一筆資料
    public static void addRecord(String input) {
        boolean success = parseSingle(input);
        if (success) System.out.println("新增成功！目前共 " + count + " 筆。");
    }
}