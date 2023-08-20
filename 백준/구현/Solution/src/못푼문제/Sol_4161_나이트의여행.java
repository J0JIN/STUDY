package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_4161_나이트의여행 {

    static int ans, X, Y;

    static int ansMap[][] = {
            {0, 3, 2, 3, 2},
            {3, 4, 1, 2, 3},
            {2, 1, 4, 3, 2},
            {3, 2, 3, 2, 3},
            {2, 3, 2, 3, 4}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            ans = 0;
            String[] input = br.readLine().split(" ");

            if (input[0].equals("END")) {
                break;
            } else {
                X = Math.abs(Integer.parseInt(input[0]));
                Y = Math.abs(Integer.parseInt(input[1]));
            }

            if (X >= 5 || Y >= 5) {
                int Big = Math.max(X, Y) - 5;
                int Small = Math.min(X, Y);

                if (Big % 4 == 0) {
                    ans = 3 + 2 * (Big / 4);
                } else if (Big % 4 == 1) {
                    ans = 3 + 2 * (Big / 4) + 1;
                } else if (Big % 4 == 2) {
                    ans = 3 + 2 * (Big / 4) + 2;
                } else if (Big % 4 == 3) {
                    ans = 3 + 2 * (Big / 4) + 1;
                }

                if (Big % 4 == 0) {
                    if (Small % 2 == 0) {
                        System.out.println(ans);
                    } else {
                        System.out.println(ans + 1);
                    }
                } else if (Big % 4 == 1) {
                    if (Small % 2 == 0) {
                        System.out.println(ans);
                    } else {
                        System.out.println(ans - 1);
                    }
                } else if (Big % 4 == 2) {
                    if (Small % 2 == 0) {
                        System.out.println(ans);
                    } else {
                        System.out.println(ans - 1);
                    }
                } else if (Big % 4 == 3) {
                    if (Small % 2 == 0) {
                        System.out.println(ans);
                    } else {
                        System.out.println(ans + 1);
                    }
                }

            } else {
                System.out.println(ansMap[X][Y]);
            }

        }
    }
}
