import java.util.Scanner;
public class InputProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("姓名:");
        String name = sc.nextLine();

        System.out.println("年齡:");
        int age = sc.nextInt();

        System.out.println("Hello, " + name + ". You are " + age +"years old");
    }
}
/*
建立 GreetingInput.java，完成以下功能：

輸入姓名。
輸入年齡。
輸出 Hello, 姓名. You are 年齡 years old.
 */