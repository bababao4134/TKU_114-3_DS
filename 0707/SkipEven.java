public class SkipEven {
    public static void main(String[] args) {
        for(int i = 1 ; i <= 10 ; i ++ ){
            if(i % 2 == 0 ){
                continue;
            }
            System.out.println(i);
        }
    }
}
/*
課堂實作題
建立 SkipEven.java，使用 for 印出 1 到 10 的奇數。遇到偶數時使用 continue 跳過。
 */