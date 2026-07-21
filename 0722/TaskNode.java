public class TaskNode {
    String  code;
    String  description;
    boolean done;
    TaskNode next;

    public TaskNode(String code, String description) {
        this.code        = code;
        this.description = description;
        this.done        = false;
        this.next        = null;
    }

    public void complete() { done = true; }

    @Override
    public String toString() {
        return "[" + code + "] " + description+ (done ? " ✓" : " ○");
    }
}