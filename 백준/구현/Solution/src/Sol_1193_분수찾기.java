import java.util.Scanner;

public class Sol_1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int a = 1;
        while (a * (a + 1) < 2 * N) {
            a++;
        }


        int b = (2 * N - a * (a - 1))/2;

        if(a%2 == 0) {
            System.out.print(b);
            System.out.print('/');
            System.out.print(a + 1 - b);
        }else{
            System.out.print(a + 1 - b);
            System.out.print('/');
            System.out.print(b);
        }

    }
}
