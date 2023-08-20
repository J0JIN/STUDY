package 빡구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1013_Contact {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr = (input + "     ").toCharArray(); // 패딩을 추가하여 인덱스 오류 방지
            System.out.println(check(0) ? "YES" : "NO");
        }
    }

    private static boolean check(int i) {
        while (i < arr.length - 5) {
            if (arr[i] == '0') {
                if (arr[i + 1] == '1') {
                    i += 2;
                } else {
                    return false;
                }
            } else if (arr[i] == '1') {
                if (arr[i + 1] == '0') {
                    i += 2;
                    if (arr[i] == '0') {
                        while (arr[i] == '0') {
                            i++;
                        }
                        loop1:
                        if (arr[i] == '1') {
                            while (arr[i] == '1') {
                                i++;
                            }
                            if (arr[i - 2] == '1' && arr[i - 1] == '1') {
                                if(check(i-1)){
                                    return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}