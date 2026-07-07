public class TemperatureLevel {
    public static void main(String[] args) {
        int tem = 28 ;
        if(tem < 15){
            System.out.println("Cold");
        }else if(tem >= 15 && tem <28){
            System.out.println("Comfortable");
        }else
            System.out.println("Hot");
    }
}
/*
課堂實作題
建立 TemperatureLevel.java，設定一個溫度 temperature，並輸出：

小於 15：Cold
15 到未滿 28：Comfortable
28 以上：Hot
 */