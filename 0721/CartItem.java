public class CartItem {
    private String code;
    private String name;
    private int    unitPrice;
    private int    quantity;

    public CartItem(String code, String name, int unitPrice, int quantity) {
        this.code      = code;
        this.name      = name;
        this.unitPrice = unitPrice;
        this.quantity  = Math.max(quantity, 1);
    }

    public String getCode()      { return code;      }
    public String getName()      { return name;      }
    public int    getUnitPrice() { return unitPrice; }
    public int    getQuantity()  { return quantity;  }

    public boolean setQuantity(int quantity) {
        if (quantity <= 0) return false;
        this.quantity = quantity;
        return true;
    }

    public void addQuantity(int amount) {
        if (amount > 0) quantity += amount;
    }

    public int getSubtotal() { return unitPrice * quantity; }

    @Override
    public String toString() {
        return code + " | " + name + " | $" + unitPrice + " x " + quantity + " = $" + getSubtotal();
    }
}