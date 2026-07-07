public class DrinkMenu {
    public static void main(String[] args) {
        int option = 0 ;
        
        switch (option){
            case 1:
                System.out.println("Black tea");
                break;
            case 2:
                System.out.println("Green tea");
                break;
            case 3:
                System.out.println("Coffee");
                break;
            default:
                System.out.println("Unknown option");
        }
    }
}
/*
課堂實作題
建立 DrinkMenu.java，設定一個整數 option：

1：輸出 Black tea
2：輸出 Green tea
3：輸出 Coffee
其他：輸出 Unknown option
 */