public class PassCounter {
    public static void main(String[] args) {
        int pass = 0;
        int score1 = 80;
        int score2 = 55;
        int score3 = 70;

        if (score1 >= 60) {
            pass++;
        }
        if (score2 >= 60) {
            pass++;
        }
        if (score3 >= 60) {
            pass++;
        }

        System.out.println("Pass count: " + pass);
    }
}
/*
課堂實作題
建立 PassCounter.java，設定三個成績：

80
55
70
計算有幾個成績及格。

預期輸出：

Pass count: 2
 */