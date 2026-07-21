import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserUndoSystem {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        String current = "Home";

        System.out.println("目前頁面：" + current);

        // 8 次操作測試
        current = openPage(history, current, "Search");
        current = openPage(history, current, "Java Tutorial");
        current = openPage(history, current, "ArrayList Docs");
        System.out.println("目前頁面：" + current);

        current = goBack(history, current);
        current = goBack(history, current);
        current = goBack(history, current); // 回到 Home

        current = openPage(history, current, "Stack Docs");
        System.out.println("目前頁面：" + current);
        current = goBack(history, current);
        current = goBack(history, current); // 空了，顯示訊息
    }

    // 開啟新頁，先把目前頁 push 進 history
    public static String openPage(Deque<String> history, String current, String newPage) {
        history.push(current);
        System.out.println("開啟：" + newPage + "（歷史 " + history.size() + " 頁）");
        return newPage;
    }

    // 返回上一頁
    public static String goBack(Deque<String> history, String current) {
        if (history.isEmpty()) {
            System.out.println("沒有上一頁了。");
            return current;
        }
        String prev = history.pop();
        System.out.println("返回：" + prev + "（歷史剩 " + history.size() + " 頁）");
        return prev;
    }
}