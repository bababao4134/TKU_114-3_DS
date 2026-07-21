import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TextEditorUndoSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        String text = "";
        int option  = -1;

        while (option != 0) {
            printMenu(text);
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("請輸入要新增的文字：");
                    String append = sc.nextLine();
                    history.push(text);          // 修改前保存
                    text += append;
                    System.out.println("新增後：「" + text + "」");
                    break;
                case 2:
                    System.out.print("請輸入要刪除的字元數：");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if (n <= 0) {
                        System.out.println("字元數必須大於 0。");
                    } else if (n > text.length()) {
                        System.out.println("超過目前長度（" + text.length() + "），無法刪除。");
                    } else {
                        history.push(text);      // 修改前保存
                        text = text.substring(0, text.length() - n);
                        System.out.println("刪除後：「" + text + "」");
                    }
                    break;
                case 3:
                    text = undo(history, text);
                    break;
                case 4:
                    System.out.println("目前內容：「" + text + "」");
                    System.out.println("歷史紀錄數：" + history.size());
                    break;
                case 0:
                    System.out.println("結束，最終內容：「" + text + "」");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static String undo(Deque<String> history, String current) {
        if (history.isEmpty()) {
            System.out.println("沒有可復原的操作。");
            return current;
        }
        String prev = history.pop();
        System.out.println("Undo：「" + current + "」→「" + prev + "」");
        return prev;
    }

    static void printMenu(String text) {
        System.out.println("\n=== 文字編輯器（目前：「" + text + "」）===");
        System.out.println("1. 新增文字");
        System.out.println("2. 刪除最後 N 個字元");
        System.out.println("3. Undo");
        System.out.println("4. 顯示內容");
        System.out.println("0. 結束");
    }
}