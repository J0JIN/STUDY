package date_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2580_½ºµµÄí {
    private static int[][] map = new int[9][9];
    static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 9; j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        insertNum(0);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void insertNum(int input) {

        if(find){
            return;
        }

        if (input == 81) {
            print();
            find = true;
            return;
        }

        int i = input % 9;
        int j = input / 9;

        if (map[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {

                if (test(i, j, k)) {
                    map[i][j] = k;
                    insertNum(input + 1);
                }
                map[i][j] = 0;
            }

        } else {
            insertNum(input + 1);
        }
    }

    private static boolean test(int row, int col, int num) {
        //row test
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num) {
                return false;
            }
        }

        //row test
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == num) {
                return false;
            }
        }

        //box test
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}