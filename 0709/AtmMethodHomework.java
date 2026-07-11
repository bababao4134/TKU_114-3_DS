import java.util.Scanner;

public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000; 
        int option = -1;

        while(option != 0 ) {
            printMenu();
            System.out.print("請選擇操作（0-3）：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    printBalance(balance);
                    break;
                case 2:
                    int depositAmount = readPositiveAmount(sc, "請輸入存款金額：");
                    balance = deposit(balance, depositAmount);
                    System.out.println("存款成功 目前餘額：" + balance);
                    break;
                case 3:
                    int withdrawAmount = readPositiveAmount(sc, "請輸入提款金額：");
                    balance = withdraw(balance, withdrawAmount);
                    if (withdrawAmount <= balance) {
                        System.out.println("提款成功 目前餘額：" + balance);
                    }
                    break;
                case 0:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("請重新選擇！");
            }
        } 

        sc.close();
    }
    public static void printMenu(){
        System.out.println("選單：");
        System.out.println("1：查詢餘額");
        System.out.println("2：存款");
        System.out.println("3：提款");
        System.out.println("0：離開");
    }
    public static int readPositiveAmount(Scanner sc, String message){
        int amount;
        do {
            System.out.print(message);
            amount = sc.nextInt();
            if (amount <= 0) {
                System.out.println("金額必須大於0，請重新輸入。");
            }
        } while (amount <= 0);
        return amount;
    }
    public static int deposit(int balance, int amount){
        return balance + amount;
    }
    public static int withdraw(int balance, int amount){
        if (amount > balance) {
            System.out.println("提款金額不能大於目前餘額");
            return balance;
        }
        return balance - amount;
    }
    public static void printBalance(int balance){
        System.out.println("目前餘額：" + balance);
    }
}
/*
功能需求
請將 7/8 的 AtmMenu.java 改寫成方法版本。

至少包含以下方法：

public static void printMenu()
public static int readPositiveAmount(Scanner sc, String message)
public static int deposit(int balance, int amount)
public static int withdraw(int balance, int amount)
public static void printBalance(int balance)
規則：

初始餘額為 1000。
存款金額必須大於 0。
提款金額必須大於 0。
提款金額不能大於目前餘額。
選單可重複操作直到輸入 0。
 */