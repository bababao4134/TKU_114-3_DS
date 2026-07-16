public class Q08_ArrayRemove {
    public static void main(String[] args) {
        int[] values = {4, 7, 2, 7, 9, 7, 1};
        int target = 7;

        System.out.println("出現次數：" + countOccurrences(values, target));
        System.out.println("最後索引：" + findLastIndex(values, target));

        int[] result = removeAll(values, target);
        System.out.print("移除後：");
        printArray(result);
        System.out.print("原始陣列：");
        printArray(values);
    }

    public static int countOccurrences(int[] data, int target) {
        int count = 0;
        for (int v : data) {
            if (v == target) count++;
        }
        return count;
    }

    public static int findLastIndex(int[] data, int target) {
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) index = i;
        }
        return index;
    }

    public static int[] removeAll(int[] data, int target) {
        int count = countOccurrences(data, target);
        int[] result = new int[data.length - count];
        int idx = 0;
        for (int v : data) {
            if (v != target) result[idx++] = v;
        }
        return result;
    }

    private static void printArray(int[] data) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}