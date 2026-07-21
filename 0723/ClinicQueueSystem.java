import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class ClinicQueueSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Patient>   waiting = new ArrayDeque<>();
        ArrayList<Patient> served = new ArrayList<>();
        int ticketNo = 1;
        int option   = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("姓名：");  String name = sc.nextLine();
                    System.out.print("科別：");  String dept = sc.nextLine();
                    String num = String.format("P%03d", ticketNo);
                    if (isDuplicateNumber(waiting, num)) {
                        System.out.println("號碼重複，請稍後重試。");
                    } else {
                        waiting.offer(new Patient(num, name, dept));
                        ticketNo++;
                        System.out.println("掛號成功：" + num
                                + "，等待人數：" + waiting.size());
                    }
                    break;
                case 2:
                    callNext(waiting, served);
                    break;
                case 3:
                    Patient next = waiting.peek();
                    System.out.println(next != null
                            ? "下一位：" + next : "目前無人等待。");
                    break;
                case 4:
                    printWaiting(waiting);
                    break;
                case 5:
                    printDeptStats(waiting, served);
                    break;
                case 0:
                    System.out.println("系統結束，總服務人數：" + served.size());
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 診所叫號系統 ===");
        System.out.println("1. 掛號");
        System.out.println("2. 叫號");
        System.out.println("3. 查看下一位");
        System.out.println("4. 等待清單");
        System.out.println("5. 各科別統計");
        System.out.println("0. 結束");
    }

    static void callNext(Deque<Patient> waiting, ArrayList<Patient> served) {
        Patient p = waiting.poll();
        if (p == null) {
            System.out.println("目前無人等待。");
        } else {
            served.add(p);
            System.out.println("請 " + p + " 就診，"
                    + "剩餘：" + waiting.size() + " 人");
        }
    }

    static void printWaiting(Deque<Patient> waiting) {
        System.out.println("=== 等待清單（共 " + waiting.size() + " 人）===");
        if (waiting.isEmpty()) { System.out.println("無人等待。"); return; }
        int i = 1;
        for (Patient p : waiting)
            System.out.println(i++ + ". " + p);
    }

    static void printDeptStats(Deque<Patient> waiting,
                                ArrayList<Patient> served) {
        System.out.println("=== 各科別等待人數 ===");
        for (Patient p : waiting) {
            // 用簡單計數顯示
        }
        // 計算等待各科別
        java.util.Map<String, Integer> deptCount = new java.util.LinkedHashMap<>();
        for (Patient p : waiting)
            deptCount.merge(p.getDepartment(), 1, Integer::sum);
        if (deptCount.isEmpty()) System.out.println("目前無人等待。");
        else deptCount.forEach((d, c) -> System.out.println(d + "：" + c + " 人"));

        System.out.println("總服務人數：" + served.size());
    }

    static boolean isDuplicateNumber(Deque<Patient> waiting, String num) {
        for (Patient p : waiting)
            if (p.getNumber().equals(num)) return true;
        return false;
    }
}