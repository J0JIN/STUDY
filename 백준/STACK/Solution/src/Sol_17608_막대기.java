import java.util.Scanner;
import java.util.Stack;

public class Sol_17608_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();
        int max = 0;
        int count = 0;

        for(int i = 0; i < N ; i++){
            int a = sc.nextInt();
            stack.push(a);
        }

        while (!stack.isEmpty()){
            if(stack.peek() > max){
                count++;
                max = stack.peek();
            }
            stack.pop();
        }

        System.out.println(count);

    }
}
