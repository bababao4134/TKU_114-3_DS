import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class CounterServiceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> waiting   = new ArrayDeque<>();
        ArrayList<String> served = new ArrayList<>();
        int ticketNo = 1;
        int option   = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("請輸入姓名：");
                    String name   = sc.nextLine();
                    String ticket = String.format("A%03d", ticketNo++);
                    waiting.offer(ticket + " " + name);
                    System.out.println("取號成功：" + ticket
                            + "，等待人數：" + waiting.size());
                    break;
                case 2:
                    callNext(waiting, served);
                    break;
                case 3:
                    String next = waiting.peek();
                    System.out.println(next != null
                            ? "下一位：" + next : "目前無人等待。");
                    break;
                case 4:
                    System.out.println("等待人數：" + waiting.size());
                    if (!waiting.isEmpty())
                        System.out.println("等待名單：" + waiting);
                    break;
                case 5:
                    System.out.println("=== 已服務紀錄 ===");
                    if (served.isEmpty()) System.out.println("尚無服務紀錄。");
                    else served.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("系統結束，共服務 "
                            + served.size() + " 人。");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 叫號系統 ===");
        System.out.println("1. 取號");
        System.out.println("2. 叫號（服務下一位）");
        System.out.println("3. 查看下一位");
        System.out.println("4. 等待人數");
        System.out.println("5. 查看已服務紀錄");
        System.out.println("0. 結束");
    }

    static void callNext(Deque<String> waiting, ArrayList<String> served) {
        String customer = waiting.poll();
        if (customer == null) {
            System.out.println("目前無人等待。");
        } else {
            served.add(customer);
            System.out.println("請 " + customer + " 至櫃台，"
                    + "剩餘等待：" + waiting.size() + " 人");
        }
    }
}