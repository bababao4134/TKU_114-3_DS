import java.util.Scanner;

public class SalesMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);
        printTable(sales);
        printProductTotals(sales);
        printDayTotals(sales);
        printBestProduct(sales);

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        for (int r = 0; r < sales.length; r++) {
            for (int c = 0; c < sales[r].length; c++) {
                System.out.print("商品 " + (r + 1) + " 第 " + (c + 1) + " 天銷售量：");
                int value = sc.nextInt();
                while (value < 0) {
                    System.out.print("銷售量不得小於 0，請重新輸入：");
                    value = sc.nextInt();
                }
                sales[r][c] = value;
            }
        }
    }

    public static void printTable(int[][] sales) {
        System.out.println("\n=== 銷售矩陣 ===");
        System.out.println("       第1天  第2天  第3天  第4天");
        for (int r = 0; r < sales.length; r++) {
            System.out.print("商品 " + (r + 1) + "：");
            for (int c = 0; c < sales[r].length; c++) {
                System.out.printf("%6d", sales[r][c]);
            }
            System.out.println();
        }
    }

    public static int rowTotal(int[][] sales, int row) {
        int total = 0;
        for (int c = 0; c < sales[row].length; c++) {
            total += sales[row][c];
        }
        return total;
    }

    public static int colTotal(int[][] sales, int col) {
        int total = 0;
        for (int r = 0; r < sales.length; r++) {
            total += sales[r][col];
        }
        return total;
    }

    public static void printProductTotals(int[][] sales) {
        System.out.println("\n=== 各商品銷售總量 ===");
        for (int r = 0; r < sales.length; r++) {
            System.out.println("商品 " + (r + 1) + " 總銷售量：" + rowTotal(sales, r));
        }
    }

    public static void printDayTotals(int[][] sales) {
        System.out.println("\n=== 每天銷售總量 ===");
        for (int c = 0; c < sales[0].length; c++) {
            System.out.println("第 " + (c + 1) + " 天總銷售量：" + colTotal(sales, c));
        }
    }

    public static void printBestProduct(int[][] sales) {
        int bestIndex = 0;
        int bestTotal = rowTotal(sales, 0);
        for (int r = 1; r < sales.length; r++) {
            int total = rowTotal(sales, r);
            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = r;
            }
        }
        System.out.println("\n銷售總量最高：商品 " + (bestIndex + 1)
                + "（" + bestTotal + " 件）");
    }
}
/*
使用 3 列 4 欄的二維陣列，表示 3 項商品在 4 天內的銷售量。

程式必須：

輸入每一格銷售量，數值不得小於 0。
以表格形式顯示完整資料。
計算每項商品的銷售總量。
計算每天全部商品的銷售總量。
找出總銷售量最高的商品。
使用方法完成輸入、顯示與統計。
完成標準：

正確使用 int[][]。
走訪時沒有列、欄顛倒。
每列與每欄總和正確。
銷售量輸入具備驗證。
 */