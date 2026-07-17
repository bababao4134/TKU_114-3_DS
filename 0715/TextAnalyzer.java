import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入一行文字：");
        String input = sc.nextLine();

        while (input.trim().isEmpty()) {
            System.out.print("不可為空白，請重新輸入：");
            input = sc.nextLine();
        }

        System.out.println("原始字元數：" + countRaw(input));
        System.out.println("有效字元數：" + countTrimmed(input));
        System.out.println("單字數量：" + countWords(input));
        System.out.println("母音數量：" + countVowels(input));
        System.out.println("最長單字：" + findLongestWord(input));

        System.out.print("請輸入關鍵字：");
        String keyword = sc.nextLine();
        System.out.println("出現次數：" + countKeyword(input, keyword));

        sc.close();
    }

    public static int countRaw(String text) {
        return text.length();
    }

    public static int countTrimmed(String text) {
        return text.trim().length();
    }

    public static int countWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) return 0;
        String[] words = trimmed.split("\\s+");
        return words.length;
    }

    public static int countVowels(String text) {
        int count = 0;
        String lower = text.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    // 找最長單字
    public static String findLongestWord(String text) {
        String[] words = text.trim().split("\\s+");
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static int countKeyword(String text, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return 0;
        String lowerText    = text.toLowerCase();
        String lowerKeyword = keyword.trim().toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = lowerText.indexOf(lowerKeyword, index)) != -1) {
            count++;
            index += lowerKeyword.length();
        }
        return count;
    }
}