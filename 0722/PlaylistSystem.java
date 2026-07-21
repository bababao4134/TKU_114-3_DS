import java.util.Scanner;

public class PlaylistSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlaylistLinkedList playlist = new PlaylistLinkedList();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("歌曲代碼："); String code = sc.nextLine();
                    System.out.print("歌曲名稱："); String name = sc.nextLine();
                    if (playlist.addLast(code, name))
                        System.out.println("已加入：" + name);
                    break;
                case 2:
                    System.out.print("請輸入代碼：");
                    PlaylistNode found = playlist.findByCode(sc.nextLine());
                    System.out.println(found != null ? "找到：" + found : "找不到。");
                    break;
                case 3:
                    System.out.print("請輸入代碼：");
                    String del = sc.nextLine();
                    System.out.println(playlist.removeByCode(del)
                            ? "已刪除「" + del + "」" : "找不到「" + del + "」。");
                    break;
                case 4:
                    System.out.println("=== 播放清單 ===");
                    playlist.print();
                    System.out.println("共 " + playlist.size() + " 首");
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
        System.out.println("\n=== 播放清單系統 ===");
        System.out.println("1. 新增歌曲（尾端）");
        System.out.println("2. 搜尋歌曲");
        System.out.println("3. 刪除歌曲");
        System.out.println("4. 顯示播放順序");
        System.out.println("0. 結束");
    }
}