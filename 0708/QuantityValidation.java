import java.util.Scanner;
public class QuantityValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入數量（大於0）：");
        int quantity = sc.nextInt();

        while(quantity <= 0) {
            System.out.println("請重新輸入（大於0）：");
            quantity = sc.nextInt();
        }
        System.out.println("Quantity: " + quantity);
        sc.close();
    }
}
