public class PriceMaxMin {
    public static void main(String[] args) {
        int a = 30 , b = 25 , c = 35 ,max = a , min = a ;
        if(b > max){
            max = b ;
        }
        if(c > max){
            max = c ;
        }
        if(b < min){
            min = b ;
        }
        if(c < min){
            min = c ;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
