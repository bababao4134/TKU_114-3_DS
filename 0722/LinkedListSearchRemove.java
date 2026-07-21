public class LinkedListSearchRemove {
    public static void main(String[] args) {
        IntNode head = buildList();
        System.out.print("初始串列：");
        printList(head);

        // 搜尋測試
        System.out.println("包含 20：" + contains(head, 20));
        System.out.println("包含 99：" + contains(head, 99));

        // 刪除中間節點（20）
        head = removeValue(head, 20);
        System.out.print("刪除 20 後：");
        printList(head);

        // 刪除 head（10）
        head = removeValue(head, 10);
        System.out.print("刪除 head(10) 後：");
        printList(head);

        // 刪除最後節點（40）
        head = removeValue(head, 40);
        System.out.print("刪除最後(40) 後：");
        printList(head);

        // 找不到的情況
        head = removeValue(head, 99);
        System.out.print("刪除不存在(99) 後：");
        printList(head);

        // 空串列測試
        head = removeValue(null, 10);
        System.out.println("空串列刪除結果：" + head);
    }

    public static IntNode buildList() {
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);
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
        // 空串列
        if (head == null) return null;

        // 刪除 head
        if (head.data == target) return head.next;

        // 刪除中間或尾端
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
        // 找不到，串列不變
        return head;
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