public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20, 30, 31, 60, 61, 120, 121, 420};
        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車 " + minutes + " 分鐘，費用：" + fee + " 元");
        }
    }

    public static int calculateFee(int minutes) {
        if (minutes < 0) return -1;
        if (minutes <= 30) return 0;

        if (minutes <= 120) {
            int extra = minutes - 30;
            int blocks = (int) Math.ceil((double) extra / 30);
            return Math.min(blocks * 20, 180);
        }

        int fee = 60 + (int) Math.ceil((double)(minutes - 120) / 60) * 30;
        return Math.min(fee, 180);
    }
}