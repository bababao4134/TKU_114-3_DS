// CourseRegistrationSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼："); String code = sc.nextLine();
                    System.out.print("名稱："); String name = sc.nextLine();
                    System.out.print("容量："); int cap     = sc.nextInt();
                    sc.nextLine();
                    addCourse(courses, code, name, cap);
                    break;
                case 2:
                    System.out.print("請輸入課程代碼：");
                    enrollCourse(courses, sc.nextLine());
                    break;
                case 3:
                    System.out.print("請輸入課程代碼：");
                    dropCourse(courses, sc.nextLine());
                    break;
                case 4:
                    System.out.print("請輸入課程代碼：");
                    removeCourse(courses, sc.nextLine());
                    break;
                case 5:
                    System.out.print("請輸入代碼或名稱：");
                    searchCourse(courses, sc.nextLine());
                    break;
                case 6:
                    printAll(courses);
                    break;
                case 7:
                    printSummary(courses);
                    break;
                case 0:
                    System.out.println("結束。");
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 選課系統 ===");
        System.out.println("1. 新增課程");
        System.out.println("2. 選課");
        System.out.println("3. 退選");
        System.out.println("4. 刪除課程");
        System.out.println("5. 搜尋課程");
        System.out.println("6. 列出全部");
        System.out.println("7. 統計摘要");
        System.out.println("0. 結束");
    }

    static void addCourse(ArrayList<Course> courses,String code, String name, int cap) {
        if (findByCode(courses, code) != null) {
            System.out.println("代碼「" + code + "」已存在。"); return;
        }
        if (name.trim().isEmpty()) {
            System.out.println("課程名稱不可為空白。"); return;
        }
        courses.add(new Course(code.trim(), name.trim(), cap));
        System.out.println("已新增課程：" + name.trim());
    }

    static void enrollCourse(ArrayList<Course> courses, String code) {
        Course found = findByCode(courses, code);
        if (found == null) {
            System.out.println("找不到課程「" + code + "」。");
        } else if (found.enroll()) {
            System.out.println("選課成功：" + found);
        } else {
            System.out.println("課程已額滿，無法選課。");
        }
    }

    static void dropCourse(ArrayList<Course> courses, String code) {
        Course found = findByCode(courses, code);
        if (found == null) {
            System.out.println("找不到課程「" + code + "」。");
        } else if (found.drop()) {
            System.out.println("退選成功：" + found);
        } else {
            System.out.println("此課程目前沒有選課人數。");
        }
    }

    static void removeCourse(ArrayList<Course> courses, String code) {
        Course found = findByCode(courses, code);
        if (found == null) {
            System.out.println("找不到課程「" + code + "」。");
        } else {
            courses.remove(found);
            System.out.println("已刪除課程：" + found.getName());
        }
    }

    static void searchCourse(ArrayList<Course> courses, String keyword) {
        String kw = keyword.trim();
        boolean found = false;
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(kw) || c.getName().toLowerCase().contains(kw.toLowerCase())) {
                System.out.println(c); found = true;
            }
        }
        if (!found) System.out.println("找不到「" + kw + "」。");
    }

    static void printAll(ArrayList<Course> courses) {
        if (courses.isEmpty()) { System.out.println("目前沒有課程。"); return; }
        for (int i = 0; i < courses.size(); i++)
            System.out.println((i + 1) + ". " + courses.get(i));
    }

    static void printSummary(ArrayList<Course> courses) {
        int totalCourses  = courses.size();
        int totalEnrolled = 0;
        int fullCount     = 0;

        System.out.println("\n=== 額滿課程 ===");
        for (Course c : courses) {
            totalEnrolled += c.getEnrolled();
            if (c.isFull()) { System.out.println(c); fullCount++; }
        }
        if (fullCount == 0) System.out.println("目前無額滿課程。");

        System.out.println("\n=== 統計摘要 ===");
        System.out.println("總課程數：" + totalCourses);
        System.out.println("總選課人次：" + totalEnrolled);
        System.out.println("額滿課程數：" + fullCount);
    }

    static Course findByCode(ArrayList<Course> courses, String code) {
        for (Course c : courses)
            if (c.getCode().equalsIgnoreCase(code.trim())) return c;
        return null;
    }
}