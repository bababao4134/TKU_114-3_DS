import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class DeliveryProcessingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<DeliveryTask>   waiting   = new ArrayDeque<>(); // Queue
        Deque<DeliveryTask>   completed = new ArrayDeque<>(); // Stack
        ArrayList<String>     log       = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu(waiting.size(), completed.size());
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼：");    String code = sc.nextLine();
                    System.out.print("配送地址："); String addr = sc.nextLine();
                    waiting.offer(new DeliveryTask(code, addr));
                    log.add("新增：" + code);
                    System.out.println("已加入：" + code + "，等待：" + waiting.size());
                    break;
                case 2:
                    processNext(waiting, completed, log);
                    break;
                case 3:
                    DeliveryTask next = waiting.peek();
                    System.out.println(next != null
                            ? "下一筆：" + next : "等待清單為空。");
                    break;
                case 4:
                    undoLast(waiting, completed, log);
                    break;
                case 5:
                    printSummary(waiting, completed, log);
                    break;
                case 0:
                    System.out.println("系統結束。");
                    printSummary(waiting, completed, log);
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu(int waitingSize, int completedSize) {
        System.out.println("\n=== 配送系統（等待:" + waitingSize
                + " 完成:" + completedSize + "）===");
        System.out.println("1. 新增配送工作");
        System.out.println("2. 完成下一筆");
        System.out.println("3. 查看下一筆");
        System.out.println("4. 復原最近完成");
        System.out.println("5. 顯示統計與紀錄");
        System.out.println("0. 結束");
    }

    // Queue poll → Stack push
    static void processNext(Deque<DeliveryTask> waiting, Deque<DeliveryTask> completed, ArrayList<String> log) {
        DeliveryTask task = waiting.poll();
        if (task == null) {
            System.out.println("沒有待配送工作。");
        } else {
            completed.push(task);
            log.add("完成：" + task.getCode());
            System.out.println("已完成：" + task
                    + "，剩餘：" + waiting.size());
        }
    }

    // Stack pop → Queue offer（回到等待尾端）
    static void undoLast(Deque<DeliveryTask> waiting,Deque<DeliveryTask> completed,ArrayList<String> log) {
        DeliveryTask task = completed.poll();
        if (task == null) {
            System.out.println("沒有可復原的完成紀錄。");
        } else {
            waiting.offer(task);   // 回到等待 Queue 尾端
            log.add("復原：" + task.getCode());
            System.out.println("已復原：" + task
                    + "，等待：" + waiting.size());
        }
    }

    static void printSummary(Deque<DeliveryTask> waiting, Deque<DeliveryTask> completed,  ArrayList<String> log) {
        System.out.println("\n=== 統計摘要 ===");
        System.out.println("等待數：" + waiting.size());
        System.out.println("完成數：" + completed.size());
        System.out.println("\n=== 處理紀錄 ===");
        if (log.isEmpty()) System.out.println("尚無紀錄。");
        else log.forEach(System.out::println);
    }
}