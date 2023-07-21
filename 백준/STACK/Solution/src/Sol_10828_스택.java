import java.util.Scanner;
import java.util.Stack;

public class Sol_10828_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    int input = sc.nextInt();
                    stack.push(input);
                    break;

                case "pop":
                    if (!stack.empty()) {
                        sb.append(stack.pop()).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    if (!stack.empty()) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;

                case "top":
                    if (!stack.empty()) {
                        sb.append(stack.peek()).append('\n');
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }

        }

        System.out.print(sb.toString());
    }
}