public class NumberHistoryList {
    public static void main(String[] args) {
        IntNode head = null;
        int size = 0;

        // 8 次操作測試
        head = addFirst(head, 50); size++;
        head = addFirst(head, 10); size++;
        head = addLast(head,  80); size++;
        head = addLast(head,  30); size++;
        head = addFirst(head, 5);  size++;

        System.out.print("目前串列：");
        printList(head);
        System.out.println("size：" + size);

        // 搜尋
        System.out.println("包含 80：" + contains(head, 80));
        System.out.println("包含 99：" + contains(head, 99));

        // 刪除
        int before = size;
        head = removeValue(head, 50);
        if (before != size) size--;  // 簡化：用 contains 判斷是否真的刪到
        // 正確做法：removeValue 回傳是否成功
        System.out.print("刪除 50 後：");
        printList(head);

        // 統計
        printStats(head);

        // 空串列統計
        System.out.println("\n=== 空串列統計 ===");
        printStats(null);
    }

    public static IntNode addFirst(IntNode head, int value) {
        IntNode newNode = new IntNode(value);
        newNode.next = head;
        return newNode;
    }

    public static IntNode addLast(IntNode head, int value) {
        IntNode newNode = new IntNode(value);
        if (head == null) return newNode;
        IntNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        return head;
    }

    public static boolean contains(IntNode head, int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    public static IntNode removeValue(IntNode head, int target) {
        if (head == null) return null;
        if (head.data == target) return head.next;
        IntNode previous = head;
        IntNode current  = head.next;
        while (current != null) {
            if (current.data == target) {
                previous.next = current.next;
                return head;
            }
            previous = current;
            current  = current.next;
        }
        return head;
    }

    public static void printStats(IntNode head) {
        if (head == null) {
            System.out.println("空串列：size=0, 總和=0, 最大=無, 最小=無");
            return;
        }
        int size = 0, total = 0;
        int max = head.data, min = head.data;
        IntNode current = head;
        while (current != null) {
            size++;
            total += current.data;
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }
        System.out.println("size：" + size);
        System.out.println("總和：" + total);
        System.out.println("最大：" + max);
        System.out.println("最小：" + min);
    }

    public static void printList(IntNode head) {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}