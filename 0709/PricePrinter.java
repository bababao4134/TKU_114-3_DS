public class PricePrinter {
    public static void main(String[] args) {
        printItem("Black tea", 30);
        printItem("Green tea", 25);
    }

    public static void printItem(String itemName , int price) {
        System.out.println(itemName + ":" + price);
    }
}
/*
課堂實作題
建立 PricePrinter.java，寫一個方法：

public static void printItem(String itemName, int price)
呼叫後輸出商品名稱與價格。
 */