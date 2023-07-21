import java.util.Scanner;
import java.util.Stack;

public class Sol_4949_균형잡힌세상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();

            if (str.equals(".")) {
                break;
            }

            boolean isValid = (check_1(str));

            if (isValid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean check_1(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char input = str.charAt(i);

            if (input == '(' || input == '[') {

                stack.push(input);

            }

            if (input == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }

            if (input == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }

}
