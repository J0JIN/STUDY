import java.util.Scanner;
import java.util.Stack;

public class Sol_9012_괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= tc; t++) {
            String chr = sc.nextLine();
            boolean isValid = checkParentheses(chr);

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean checkParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char input = str.charAt(i);

            if (input == '(') {
                stack.push('(');
            } else if (input == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
