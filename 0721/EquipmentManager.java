import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> list = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼："); String code = sc.nextLine();
                    System.out.print("名稱："); String name = sc.nextLine();
                    addEquipment(list, code, name);
                    break;
                case 2:
                    System.out.print("請輸入代碼：");
                    searchEquipment(list, sc.nextLine());
                    break;
                case 3:
                    System.out.print("請輸入代碼：");
                    borrowEquipment(list, sc.nextLine());
                    break;
                case 4:
                    System.out.print("請輸入代碼：");
                    returnEquipment(list, sc.nextLine());
                    break;
                case 5:
                    printAvailable(list);
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
        System.out.println("\n=== 設備管理 ===");
        System.out.println("1. 新增設備");
        System.out.println("2. 搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出可借設備");
        System.out.println("0. 結束");
    }

    static void addEquipment(ArrayList<Equipment> list,
                              String code, String name) {
        if (findByCode(list, code) != null) {
            System.out.println("代碼「" + code + "」已存在。");
            return;
        }
        list.add(new Equipment(code, name));
        System.out.println("已新增：" + code + " " + name);
    }

    static void searchEquipment(ArrayList<Equipment> list, String code) {
        Equipment found = findByCode(list, code);
        if (found != null) System.out.println(found);
        else System.out.println("找不到代碼「" + code + "」。");
    }

    static void borrowEquipment(ArrayList<Equipment> list, String code) {
        Equipment found = findByCode(list, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else if (found.borrow()) {
            System.out.println("借出成功：" + found);
        } else {
            System.out.println("此設備已借出。");
        }
    }

    static void returnEquipment(ArrayList<Equipment> list, String code) {
        Equipment found = findByCode(list, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else if (found.returnEquip()) {
            System.out.println("歸還成功：" + found);
        } else {
            System.out.println("此設備原本就在庫中。");
        }
    }

    static void printAvailable(ArrayList<Equipment> list) {
        System.out.println("=== 可借用設備 ===");
        boolean found = false;
        for (Equipment e : list) {
            if (e.isAvailable()) { System.out.println(e); found = true; }
        }
        if (!found) System.out.println("目前無可借用設備。");
    }

    static Equipment findByCode(ArrayList<Equipment> list, String code) {
        for (Equipment e : list)
            if (e.getCode().equalsIgnoreCase(code.trim())) return e;
        return null;
    }
}