public class SubtotalCalculator {
    public static void main(String[] args) {
        int result = calculateSubtotal(25, 5);
        System.out.println("Result:" + result);
    }

    public static int calculateSubtotal(int price , int quantity) {
        return price * quantity ;
    }
}
/*
課堂實作題
建立 SubtotalCalculator.java，寫一個方法：

public static int calculateSubtotal(int price, int quantity)
回傳商品小計。
 */