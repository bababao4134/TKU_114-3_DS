import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("請輸入姓名：");
                    addName(names, sc.nextLine());
                    break;
                case 2:
                    System.out.print("請輸入搜尋姓名：");
                    searchName(names, sc.nextLine());
                    break;
                case 3:
                    System.out.print("請輸入舊姓名：");
                    String oldName = sc.nextLine();
                    System.out.print("請輸入新姓名：");
                    updateName(names, oldName, sc.nextLine());
                    break;
                case 4:
                    System.out.print("請輸入要刪除的姓名：");
                    removeName(names, sc.nextLine());
                    break;
                case 5:
                    printAll(names);
                    break;
                case 0:
                    System.out.println("結束。");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 名單管理 ===");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部");
        System.out.println("0. 結束");
    }

    static void addName(ArrayList<String> names, String name) {
        if (name.trim().isEmpty()) {
            System.out.println("姓名不可為空白。");
            return;
        }
        names.add(name.trim());
        System.out.println("已新增：" + name.trim());
    }

    static void searchName(ArrayList<String> names, String keyword) {
        int index = findIndex(names, keyword);
        if (index >= 0) {
            System.out.println("找到：" + names.get(index) + "（索引 " + index + "）");
        } else {
            System.out.println("找不到「" + keyword.trim() + "」。");
        }
    }

    static void updateName(ArrayList<String> names, String oldName, String newName) {
        if (newName.trim().isEmpty()) {
            System.out.println("新姓名不可為空白。");
            return;
        }
        int index = findIndex(names, oldName);
        if (index >= 0) {
            names.set(index, newName.trim());
            System.out.println("已修改為：" + newName.trim());
        } else {
            System.out.println("找不到「" + oldName.trim() + "」。");
        }
    }

    static void removeName(ArrayList<String> names, String name) {
        int index = findIndex(names, name);
        if (index >= 0) {
            names.remove(index);
            System.out.println("已刪除：" + name.trim());
        } else {
            System.out.println("找不到「" + name.trim() + "」。");
        }
    }

    static void printAll(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("名單為空。");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }

    // 忽略大小寫與前後空白搜尋，回傳索引
    static int findIndex(ArrayList<String> names, String keyword) {
        String trimmed = keyword.trim();
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(trimmed)) return i;
        }
        return -1;
    }
}