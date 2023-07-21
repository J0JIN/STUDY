import java.util.Scanner;
import java.util.Stack;

public class Sol_10773_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        int total = 0;

        for(int i = 0; i < N ; i++){
            int a = sc.nextInt();
            if(a != 0){
                stack.push(a);
            }

            if(a == 0){
                stack.pop();
            }

        }

        while (!stack.isEmpty()){
            total += stack.pop();
        }

        System.out.println(total);

    }
}
