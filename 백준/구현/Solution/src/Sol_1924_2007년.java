import java.util.Scanner;

public class Sol_1924_2007년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] year = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int month = sc.nextInt();
        int day = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < month; i++) {
            sum += year[i];
        }

        sum += day;

        int week = sum % 7;

        switch (week){
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            case 0:
                System.out.println("SUN");
                break;
        }
    }
}
