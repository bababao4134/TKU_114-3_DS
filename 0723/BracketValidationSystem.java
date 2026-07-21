import java.util.ArrayDeque;
import java.util.Deque;

public class BracketValidationSystem {
    public static void main(String[] args) {
        String[] tests = {
            "([{}])",       // true  多層巢狀
            "([)]",         // false 順序錯誤
            "(((",           // false 缺右括號
            ")))",           // false 缺左括號
            "",              // true  空字串
            "{a + (b * c)}", // true  含非括號字元
            "[(])",          // false 交錯
            "{}[]() "        // true  多組並排
        };

        for (String test : tests) {
            System.out.printf("%-18s -> %s%n",
                    "\"" + test + "\"", isBalanced(test) ? "合法" : "不合法");
        }
    }

    public static boolean isBalanced(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (isLeft(ch)) {
                stack.push(ch);
            } else if (isRight(ch)) {
                if (stack.isEmpty()) return false;          // 缺左括號
                if (!matches(stack.pop(), ch)) return false; // 類型不符
            }
            // 非括號字元直接略過
        }
        return stack.isEmpty(); // 還有未配對的左括號
    }

    public static boolean isLeft(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isRight(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean matches(char left, char right) {
        return (left == '(' && right == ')')
            || (left == '[' && right == ']')
            || (left == '{' && right == '}');
    }
}