import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sol_1041_주사위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());
        long[] dice = new long[6];

        String[] input = br.readLine().split(" ");

        long max = 0;
        long min = 51;

        long total = 0;

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(input[i]);
            max = Math.max(max, dice[i]);
            min = Math.min(min, dice[i]);
            total += dice[i];
        }

        long x = Math.min(dice[0], dice[5]);
        long y = Math.min(dice[1], dice[4]);
        long z = Math.min(dice[2], dice[3]);

        long dice5 = total - max;
        long dice3 = x + y + z;
        long dice2 = Math.min(Math.min(x + y, x + z), y + z);
        long dice1 = min;

        if (N.equals(BigInteger.ONE)) {
            System.out.println(dice5);
        } else if (N.equals(BigInteger.valueOf(2))) {
            System.out.println(BigInteger.valueOf(4).multiply(BigInteger.valueOf(dice3)).add(BigInteger.valueOf(4).multiply(BigInteger.valueOf(dice2))));
        } else {
            BigInteger ans = BigInteger.ZERO;
            ans = ans.add(BigInteger.valueOf(4).multiply(N.subtract(BigInteger.ONE)).multiply(N.subtract(BigInteger.valueOf(2))).add((N.subtract(BigInteger.valueOf(2))).multiply(N.subtract(BigInteger.valueOf(2)))).multiply(BigInteger.valueOf(dice1)));
            ans = ans.add(BigInteger.valueOf(8).multiply(N).subtract(BigInteger.valueOf(12)).multiply(BigInteger.valueOf(dice2)));
            ans = ans.add(BigInteger.valueOf(4).multiply(BigInteger.valueOf(dice3)));
            System.out.println(ans);
        }
    }
}
