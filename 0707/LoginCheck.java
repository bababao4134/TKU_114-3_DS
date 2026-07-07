import java.util.Scanner;
public class LoginCheck{
    public static void main(String[] args) {
        String username = "admin" ;
        String password = "1234" ;
        
        Scanner sc = new Scanner(System.in) ;
        System.out.println("String inputUsername =");
        String name = sc.nextLine() ;
        System.out.println("String inputPassword =");
        String pass = sc.nextLine() ;

        boolean account = name.equals(username) && pass.equals(password) ; 
        System.out.println("Account:"+account);
    }
}
/*
課堂實作題
建立 LoginCheck.java，設定：

String username = "admin";
String password = "1234";
再設定兩個輸入結果變數：

String inputUsername = "admin";
String inputPassword = "1234";
判斷帳號與密碼是否都正確。

提示：字串比較使用 .equals()。
 */