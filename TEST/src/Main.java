import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // 각 달의 날수를 배열로 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        YearMonth currentMonth = YearMonth.now();
        int daysInMonth = currentMonth.lengthOfMonth();



        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 현재 연도와 월을 얻음
        int year = Integer.parseInt(br.readLine());
        int month = Integer.parseInt(br.readLine());

        // 윤년 체크
        if (month == 2 && isLeapYear(year)) {
            daysInMonths[month] = 29;
        }

        // 현재 달의 날수 출력
        System.out.println("현재 달의 날수: " + daysInMonths[month-1]);
    }




    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
