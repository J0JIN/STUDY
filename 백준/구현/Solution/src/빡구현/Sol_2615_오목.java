package 빡구현;

import java.util.Scanner;

public class Sol_2615_오목 {

    public static int[][] map;

    public static int[][][] win =
            {{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {-1, 0}},
                    {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {-1, -1}},
                    {{1, -1}, {2, -2}, {3, -3}, {4, -4}, {5, -5}, {-1, 1}},
                    {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, -1}}};

    public static void check() {

        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {

                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int n1x = i + win[k][0][0];
                        int n1y = j + win[k][0][1];
                        int n2x = i + win[k][1][0];
                        int n2y = j + win[k][1][1];
                        int n3x = i + win[k][2][0];
                        int n3y = j + win[k][2][1];
                        int n4x = i + win[k][3][0];
                        int n4y = j + win[k][3][1];
                        int n5x = i + win[k][4][0];
                        int n5y = j + win[k][4][1];
                        int n6x = i + win[k][5][0];
                        int n6y = j + win[k][5][1];

                        if (map[n1x][n1y] == 1 && map[n2x][n2y] == 1 && map[n3x][n3y] == 1 && map[n4x][n4y] == 1) {
                            if (map[n5x][n5y] != 1 && map[n6x][n6y] != 1) {
                                System.out.println("1");
                                System.out.println(j + " " + i);
                                return;
                            }
                        }
                    }
                }

                if (map[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int n1x = i + win[k][0][0];
                        int n1y = j + win[k][0][1];
                        int n2x = i + win[k][1][0];
                        int n2y = j + win[k][1][1];
                        int n3x = i + win[k][2][0];
                        int n3y = j + win[k][2][1];
                        int n4x = i + win[k][3][0];
                        int n4y = j + win[k][3][1];
                        int n5x = i + win[k][4][0];
                        int n5y = j + win[k][4][1];
                        int n6x = i + win[k][5][0];
                        int n6y = j + win[k][5][1];

                        if (map[n1x][n1y] == 2 && map[n2x][n2y] == 2 && map[n3x][n3y] == 2 && map[n4x][n4y] == 2) {
                            if (map[n5x][n5y] != 2 && map[n6x][n6y] != 2) {
                                System.out.println("2");
                                System.out.println(j + " " + i);
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("0");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[21][21];

        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                map[i][j] = sc.nextInt();
            }
        }
        check();
    }
}
