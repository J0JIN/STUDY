import java.io.*;
import java.util.Scanner;

public class Sol_11723_집합 {
    static boolean[] S = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            String command = str[0];
//            System.out.println(command);
            int num = 0;

            if (str.length == 2) {
                num = Integer.parseInt(str[1]);
            }
//            System.out.println(num);

            switch (command) {
                case "add":
                    add(num);
                    break;
                case "remove":
                    remove(num);
                    break;
                case "check":
                    sb.append(check(num)).append('\n');
                    break;
                case "toggle":
                    toggle(num);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }

        }

        System.out.println(sb.toString());

    }

    public static void add(int x) {
        S[x] = true;
    }

    public static void remove(int x) {
        S[x] = false;
    }

    public static int check(int x) {
        if (S[x] == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void toggle(int x) {
        S[x] = !S[x];
    }

    public static void all() {
        for (int i = 0; i < S.length; i++) {
            S[i] = true;
        }
    }

    public static void empty() {
        for (int i = 0; i < S.length; i++) {
            S[i] = false;
        }
    }
}
