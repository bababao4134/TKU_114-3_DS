public class LinkedListReverse {
    public static void main(String[] args) {
        // 測試空串列
        IntNode empty = null;
        System.out.print("空串列反轉：");
        printList(reverse(empty));

        // 測試單一節點
        IntNode single = new IntNode(10);
        System.out.print("單一節點反轉前：");
        printList(single);
        single = reverse(single);
        System.out.print("單一節點反轉後：");
        printList(single);

        // 測試多節點
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);
        System.out.print("多節點反轉前：");
        printList(head);
        head = reverse(head);
        System.out.print("多節點反轉後：");
        printList(head);
    }

    // 不建立第二條串列，直接修改 next 方向
    public static IntNode reverse(IntNode head) {
        IntNode previous = null;
        IntNode current  = head;

        while (current != null) {
            IntNode nextNode = current.next; // 先保存下一個
            current.next = previous;         // 反轉 next 方向
            previous = current;              // previous 前進
            current  = nextNode;             // current 前進
        }
        return previous; // previous 指向原本最後一個節點（新的 head）
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