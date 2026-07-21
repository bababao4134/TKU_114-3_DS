public class PlaylistLinkedList {
    private PlaylistNode head;
    private int size;

    public PlaylistLinkedList() {
        head = null;
        size = 0;
    }

    public int size()      { return size;        }
    public boolean isEmpty() { return head == null; }

    // 尾端新增，代碼不可重複
    public boolean addLast(String code, String songName) {
        if (findByCode(code) != null) {
            System.out.println("代碼「" + code + "」已存在。");
            return false;
        }
        PlaylistNode newNode = new PlaylistNode(code, songName);
        if (head == null) {
            head = newNode;
        } else {
            PlaylistNode current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    // 依代碼搜尋
    public PlaylistNode findByCode(String code) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) return current;
            current = current.next;
        }
        return null;
    }

    // 依代碼刪除
    public boolean removeByCode(String code) {
        if (head == null) return false;

        // 刪除 head
        if (head.code.equalsIgnoreCase(code)) {
            head = head.next;
            size--;
            return true;
        }

        PlaylistNode previous = head;
        PlaylistNode current  = head.next;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current  = current.next;
        }
        return false;
    }

    // 輸出完整播放順序
    public void print() {
        if (head == null) { System.out.println("播放清單為空。"); return; }
        int i = 1;
        PlaylistNode current = head;
        while (current != null) {
            System.out.println(i++ + ". " + current);
            current = current.next;
        }
    }
}