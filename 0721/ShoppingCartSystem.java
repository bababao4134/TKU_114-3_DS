import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();
        int option = -1;

        while (option != 0) {
            printMenu();
            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("代碼：");   String code  = sc.nextLine();
                    System.out.print("名稱：");   String name  = sc.nextLine();
                    System.out.print("單價：");   int price    = sc.nextInt();
                    System.out.print("數量：");   int qty      = sc.nextInt();
                    sc.nextLine();
                    addItem(cart, code, name, price, qty);
                    break;
                case 2:
                    System.out.print("請輸入代碼："); String uCode = sc.nextLine();
                    System.out.print("請輸入新數量："); int uQty  = sc.nextInt();
                    sc.nextLine();
                    updateQuantity(cart, uCode, uQty);
                    break;
                case 3:
                    System.out.print("請輸入代碼：");
                    removeItem(cart, sc.nextLine());
                    break;
                case 4:
                    printCart(cart);
                    break;
                case 5:
                    System.out.println("總金額：$" + calculateTotal(cart));
                    break;
                case 0:
                    System.out.println("結帳結束，總金額：$"
                            + calculateTotal(cart));
                    break;
                default:
                    System.out.println("無效選項。");
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== 購物車 ===");
        System.out.println("1. 加入商品");
        System.out.println("2. 修改數量");
        System.out.println("3. 移除商品");
        System.out.println("4. 顯示購物車");
        System.out.println("5. 計算總額");
        System.out.println("0. 結帳");
    }

    static void addItem(ArrayList<CartItem> cart, String code, String name, int price, int qty) {
        CartItem found = findByCode(cart, code);
        if (found != null) {
            found.addQuantity(qty);
            System.out.println("數量已增加：" + found);
        } else {
            cart.add(new CartItem(code, name, price, qty));
            System.out.println("已加入：" + name);
        }
    }

    static void updateQuantity(ArrayList<CartItem> cart,
                                String code, int qty) {
        CartItem found = findByCode(cart, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else if (found.setQuantity(qty)) {
            System.out.println("已更新：" + found);
        } else {
            System.out.println("數量必須大於 0。");
        }
    }

    static void removeItem(ArrayList<CartItem> cart, String code) {
        CartItem found = findByCode(cart, code);
        if (found == null) {
            System.out.println("找不到代碼「" + code + "」。");
        } else {
            cart.remove(found);
            System.out.println("已移除：" + found.getName());
        }
    }

    static void printCart(ArrayList<CartItem> cart) {
        if (cart.isEmpty()) { System.out.println("購物車是空的。"); return; }
        for (int i = 0; i < cart.size(); i++)
            System.out.println((i + 1) + ". " + cart.get(i));
    }

    static int calculateTotal(ArrayList<CartItem> cart) {
        int total = 0;
        for (CartItem item : cart) total += item.getSubtotal();
        return total;
    }

    static CartItem findByCode(ArrayList<CartItem> cart, String code) {
        for (CartItem item : cart)
            if (item.getCode().equalsIgnoreCase(code.trim())) return item;
        return null;
    }
}