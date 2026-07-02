import java.util.Scanner;
public class UserInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("姓名:");
        String userName = sc.nextLine();

        System.out.println("ID:");
        int userId = sc.nextInt();

        System.out.println("Department:");
        String department = sc.next();

        System.out.println("Except Score:");
        int expectedScore = sc.nextInt();

        System.out.println("Name:"+userName);
        System.out.println("ID:"+userId);
        System.out.println("Depertment:"+department);
        System.out.println("Except score:"+expectedScore);
    }
}
/*
建立 UserInfo.java，宣告以下變數並輸出：

userName
userId
department
expectedScore
輸出格式：

Name: Amy
ID: 412345678
Department: Information Management
Expected Score: 90
 */