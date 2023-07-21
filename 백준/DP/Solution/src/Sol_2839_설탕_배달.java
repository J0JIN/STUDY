import java.util.Scanner;

public class Sol_2839_설탕_배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;
        boolean notfound = true;
        int total = sc.nextInt();

        loop1:
        for (int x = 0; x <= total / 3; x++) {
            loop2:
            for (int y = 0; y <= total / 5; y++) {
                if (3 * x + 5 * y == total) {
                    ans = x + y;
                    notfound = false;
                    System.out.println(ans);
                    break loop1;
                }
            }
        }

        if(notfound){
            System.out.println("-1");
        }
    }
}

