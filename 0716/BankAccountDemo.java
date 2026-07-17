// BankAccountDemo.java
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount amy = new BankAccount("A001", "Amy", 5000);
        BankAccount ben = new BankAccount("A002", "Ben", 1000);

        System.out.println("=== 初始狀態 ===");
        System.out.println(amy);
        System.out.println(ben);

        System.out.println("\n=== 存款測試 ===");
        System.out.println("Amy 存 500：" + amy.deposit(500));
        System.out.println("Ben 存 -100：" + ben.deposit(-100));

        System.out.println("\n=== 提款測試 ===");
        System.out.println("Ben 提 300：" + ben.withdraw(300));
        System.out.println("Ben 提 5000（超額）：" + ben.withdraw(5000));

        System.out.println("\n=== 轉帳測試 ===");
        System.out.println("Amy 轉 Ben 2000：" + amy.transferTo(ben, 2000));
        System.out.println("Ben 轉 Amy 10000（超額）：" + ben.transferTo(amy, 10000));

        System.out.println("\n=== 最終狀態 ===");
        System.out.println(amy);
        System.out.println(ben);
    }
}