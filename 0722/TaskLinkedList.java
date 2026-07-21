public class TaskLinkedList {
    private TaskNode head;
    private int size;

    public TaskLinkedList() { head = null; size = 0; }

    public int size()        { return size;        }
    public boolean isEmpty() { return head == null; }

    // 緊急工作加到前端
    public boolean addFirst(String code, String desc) {
        if (findByCode(code) != null) {
            System.out.println("代碼「" + code + "」已存在。");
            return false;
        }
        TaskNode newNode = new TaskNode(code, desc);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    // 一般工作加到尾端
    public boolean addLast(String code, String desc) {
        if (findByCode(code) != null) {
            System.out.println("代碼「" + code + "」已存在。");
            return false;
        }
        TaskNode newNode = new TaskNode(code, desc);
        if (head == null) { head = newNode; size++; return true; }
        TaskNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        size++;
        return true;
    }

    // 完成工作
    public boolean completeTask(String code) {
        TaskNode found = findByCode(code);
        if (found == null) return false;
        if (found.done) { System.out.println("此工作已完成。"); return false; }
        found.complete();
        return true;
    }

    // 刪除工作
    public boolean removeByCode(String code) {
        if (head == null) return false;
        if (head.code.equalsIgnoreCase(code)) {
            head = head.next; size--; return true;
        }
        TaskNode previous = head;
        TaskNode current  = head.next;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                previous.next = current.next;
                size--; return true;
            }
            previous = current;
            current  = current.next;
        }
        return false;
    }

    // 依代碼搜尋
    public TaskNode findByCode(String code) {
        TaskNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) return current;
            current = current.next;
        }
        return null;
    }

    // 列出未完成工作
    public void printPending() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            if (!current.done) { System.out.println(current); count++; }
            current = current.next;
        }
        if (count == 0) System.out.println("所有工作已完成！");
    }

    // 列出全部工作
    public void printAll() {
        if (head == null) { System.out.println("工作清單為空。"); return; }
        TaskNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // 統計未完成數
    public int countPending() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            if (!current.done) count++;
            current = current.next;
        }
        return count;
    }
}