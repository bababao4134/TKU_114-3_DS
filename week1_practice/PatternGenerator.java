import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {
        Scanner sc     = new Scanner(System.in);
        int     option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    printMultiplicationTable();
                    break;
                case 2:
                    int height1 = readPositiveInt(sc, "請輸入高度：");
                    printTriangle(height1);
                    break;
                case 3:
                    int height2 = readPositiveInt(sc, "請輸入高度：");
                    printReverseTriangle(height2);
                    break;
                case 4:
                    int rows = readPositiveInt(sc, "請輸入列數：");
                    int cols = readPositiveInt(sc, "請輸入欄數：");
                    printNumberGrid(rows, cols);
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("無效選項，請重新輸入。");
            }
        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Pattern Menu ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形");
        System.out.println("3. 倒三角形");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
    }

    public static int readPositiveInt(Scanner sc, String message) {
        System.out.print(message);
        int value = sc.nextInt();
        while (value <= 0) {
            System.out.print("必須大於 0，請重新輸入：");
            value = sc.nextInt();
        }
        return value;
    }

    public static void printMultiplicationTable() {
        System.out.println("\n=== 九九乘法表 ===");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d*%d=%-4d", i, j, i * j);
            }
            System.out.println();
        }
    }

    public static void printTriangle(int height) {
        System.out.println("\n=== 正三角形 ===");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printReverseTriangle(int height) {
        System.out.println("\n=== 倒三角形 ===");
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printNumberGrid(int rows, int cols) {
        System.out.println("\n=== 數字方格 ===");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}