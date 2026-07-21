public class BuildLinkedList {
    public static void main(String[] args) {
        // 建立四個 Node 並連接
        IntNode head = new IntNode(10);
        head.next = new IntNode(20);
        head.next.next = new IntNode(30);
        head.next.next.next = new IntNode(40);

        System.out.print("串列內容：");
        printList(head);
        System.out.println("節點數：" + count(head));
        System.out.println("總和：" + sum(head));
    }

    public static void printList(IntNode head) {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static int count(IntNode head) {
        int count = 0;
        IntNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static int sum(IntNode head) {
        int total = 0;
        IntNode current = head;
        while (current != null) {
            total += current.data;
            current = current.next;
        }
        return total;
    }
}