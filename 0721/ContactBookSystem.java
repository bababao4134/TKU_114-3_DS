import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼：");  String code  = sc.nextLine();
                    System.out.print("姓名：");  String name  = sc.nextLine();
                    System.out.print("電話：");  String phone = sc.nextLine();
                    System.out.print("Email："); String email = sc.nextLine();
                    addContact(contacts, code, name, phone, email);
                    break;
                case 2:
                    System.out.print("請輸入代碼或姓名：");
                    searchContact(contacts, sc.nextLine());
                    break;
                case 3:
                    System.out.print("請輸入代碼：");  String uCode  = sc.nextLine();
                    System.out.print("請輸入新電話："); String uPhone = sc.nextLine();
                    updatePhone(contacts, uCode, uPhone);
                    break;
                case 4:
                    System.out.print("請輸入代碼：");
                    removeContact(contacts, sc.nextLine());
                    break;
                case 5:
                    printAll(contacts);
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
        System.out.println("\n=== 聯絡人管理 ===");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人");
        System.out.println("3. 修改電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 列出全部");
        System.out.println("0. 結束");
    }

    static void addContact(ArrayList<Contact> contacts, String code,
                            String name, String phone, String email) {
        if (name.trim().isEmpty()) {
            System.out.println("姓名不可為空白。"); return;
        }
        if (findByCode(contacts, code) != null) {
            System.out.println("代碼「" + code + "」已存在。"); return;
        }
        contacts.add(new Contact(code.trim(), name.trim(),phone.trim(), email.trim()));
        System.out.println("已新增：" + name.trim());
    }

    static void searchContact(ArrayList<Contact> contacts, String keyword) {
        String kw = keyword.trim();
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(kw)|| c.getName().equalsIgnoreCase(kw)) {
                System.out.println(c); found = true;
            }
        }
        if (!found) System.out.println("找不到「" + kw + "」。");
    }

    static void updatePhone(ArrayList<Contact> contacts, String code, String phone) {
        Contact found = findByCode(contacts, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else {
            found.setPhone(phone.trim());
            System.out.println("已更新：" + found);
        }
    }

    static void removeContact(ArrayList<Contact> contacts, String code) {
        Contact found = findByCode(contacts, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else {
            contacts.remove(found);
            System.out.println("已刪除：" + found.getName());
        }
    }

    static void printAll(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) { System.out.println("聯絡人清單為空。"); return; }
        for (int i = 0; i < contacts.size(); i++)
            System.out.println((i + 1) + ". " + contacts.get(i));
    }

    static Contact findByCode(ArrayList<Contact> contacts, String code) {
        for (Contact c : contacts)
            if (c.getCode().equalsIgnoreCase(code.trim())) return c;
        return null;
    }
}