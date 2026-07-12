import java.util.Scanner;

public class DrinkOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option        = -1;
        int totalItems    = 0;
        int totalAmount   = 0;
        int blackTeaCount = 0;
        int greenTeaCount = 0;
        int milkTeaCount  = 0;
        int coffeeCount   = 0;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    int qty1 = readValidQuantity(sc);
                    blackTeaCount += qty1;
                    totalItems    += qty1;
                    totalAmount   += calculateSubtotal(getPrice(1), qty1);
                    System.out.println(getItemName(1) + " x " + qty1);
                    System.out.println("Subtotal: " + totalAmount);
                    break;
                case 2:
                    int qty2 = readValidQuantity(sc);
                    greenTeaCount += qty2;
                    totalItems    += qty2;
                    totalAmount   += calculateSubtotal(getPrice(2), qty2);
                    System.out.println(getItemName(2) + " x " + qty2);
                    System.out.println("Subtotal: " + totalAmount);
                    break;
                case 3:
                    int qty3 = readValidQuantity(sc);
                    milkTeaCount += qty3;
                    totalItems   += qty3;
                    totalAmount  += calculateSubtotal(getPrice(3), qty3);
                    System.out.println(getItemName(3) + " x " + qty3);
                    System.out.println("Subtotal: " + totalAmount);
                    break;
                case 4:
                    int qty4 = readValidQuantity(sc);
                    coffeeCount += qty4;
                    totalItems  += qty4;
                    totalAmount += calculateSubtotal(getPrice(4), qty4);
                    System.out.println(getItemName(4) + " x " + qty4);
                    System.out.println("Subtotal: " + totalAmount);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("無效選項，請重新輸入。");
            }
        }

        int finalAmount = calculateDiscountedTotal(totalAmount);
        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount, coffeeCount, totalItems, totalAmount, finalAmount);
        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Drink Menu ===");
        System.out.println("1. Black tea $30");
        System.out.println("2. Green tea $35");
        System.out.println("3. Milk tea $45");
        System.out.println("4. Coffee $50");
        System.out.println("0. Checkout");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 45;
            case 4: return 50;
            default: return 0;
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Milk tea";
            case 4: return "Coffee";
            default: return "Unknown";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        System.out.print("請輸入數量：");
        int quantity = sc.nextInt();
        while (quantity <= 0) {
            System.out.print("數量必須大於0，請重新輸入：");
            quantity = sc.nextInt();
        }
        return quantity;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) return (int)(totalAmount * 0.9);
        return totalAmount;
    }

    public static void printReceipt(int blackTeaCount, int greenTeaCount,
            int milkTeaCount, int coffeeCount,
            int totalItems, int totalAmount, int finalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);
        System.out.println("Discount: " + (totalAmount >= 300 ? "Yes (10% off)" : "No"));
        System.out.println("Final amount: " + finalAmount);
    }
}