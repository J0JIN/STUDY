import java.util.Scanner;

public class Sol_1152_단어의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        int count = 0;

        if (!input.isEmpty()) {
            String[] words = input.split(" ");
            count = words.length;
        }

        System.out.println(count);
    }
}
