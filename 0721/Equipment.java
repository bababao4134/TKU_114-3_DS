public class Equipment {
    private String  code;
    private String  name;
    private boolean available;

    public Equipment(String code, String name) {
        this.code      = code;
        this.name      = name;
        this.available = true;
    }

    public String  getCode()      { return code;      }
    public String  getName()      { return name;      }
    public boolean isAvailable()  { return available; }

    public boolean borrow() {
        if (!available) return false;
        available = false;
        return true;
    }

    public boolean returnEquip() {
        if (available) return false;
        available = true;
        return true;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | "+ (available ? "可借用" : "已借出");
    }
}