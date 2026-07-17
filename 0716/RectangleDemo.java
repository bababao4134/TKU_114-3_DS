public class RectangleDemo {

    public static void printResult(Rectangle r) {
        System.out.println(r);
        System.out.printf("面積：%.2f%n",   r.calculateArea());
        System.out.printf("周長：%.2f%n",   r.calculatePerimeter());
        System.out.println("正方形：" +      r.isSquare());
        System.out.println();
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3);
        Rectangle r2 = new Rectangle(4, 4);
        Rectangle r3 = new Rectangle(8.5, 2);

        printResult(r1);
        printResult(r2);
        printResult(r3);

        System.out.println("嘗試設定負數寬度：" + r1.setWidth(-1));
        System.out.println("嘗試設定合法寬度：" + r1.setWidth(6));
        System.out.println("修改後：" + r1);
    }
}