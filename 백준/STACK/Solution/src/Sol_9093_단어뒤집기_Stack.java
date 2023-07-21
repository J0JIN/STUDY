import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_9093_단어뒤집기_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= tc; t++) {
            String input = bf.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch != ' ') {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(" ");
                }
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}
