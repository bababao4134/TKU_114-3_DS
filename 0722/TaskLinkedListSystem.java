import java.util.Scanner;

public class TaskLinkedListSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskLinkedList tasks = new TaskLinkedList();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼："); String uc = sc.nextLine();
                    System.out.print("說明："); String ud = sc.nextLine();
                    if (tasks.addFirst(uc, ud))
                        System.out.println("緊急工作已加到前端。");
                    break;
                case 2:
                    System.out.print("代碼："); String nc = sc.nextLine();
                    System.out.print("說明："); String nd = sc.nextLine();
                    if (tasks.addLast(nc, nd))
                        System.out.println("工作已加到尾端。");
                    break;
                case 3:
                    System.out.print("請輸入代碼：");
                    String done = sc.nextLine();
                    System.out.println(tasks.completeTask(done)
                            ? "已完成：" + done : "找不到「" + done + "」。");
                    break;
                case 4:
                    System.out.print("請輸入代碼：");
                    String del = sc.nextLine();
                    System.out.println(tasks.removeByCode(del)
                            ? "已刪除：" + del : "找不到「" + del + "」。");
                    break;
                case 5:
                    System.out.println("=== 未完成工作 ===");
                    tasks.printPending();
                    break;
                case 6:
                    System.out.println("=== 全部工作 ===");
                    tasks.printAll();
                    System.out.println("工作總數：" + tasks.size());
                    System.out.println("未完成數：" + tasks.countPending());
                    break;
                case 0:
                    System.out.println("=== 系統結束 ===");
                    System.out.println("工作總數：" + tasks.size());
                    System.out.println("未完成數：" + tasks.countPending());
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 工作管理系統 ===");
        System.out.println("1. 新增緊急工作（前端）");
        System.out.println("2. 新增一般工作（尾端）");
        System.out.println("3. 完成工作");
        System.out.println("4. 刪除工作");
        System.out.println("5. 列出未完成工作");
        System.out.println("6. 列出全部 + 統計");
        System.out.println("0. 結束");
    }
}