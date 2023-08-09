import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2618_경찰차 {

    static int total;
    public static class Point {
        int x, y;

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int tc = Integer.parseInt(br.readLine());

        Point car1 = new Point(1, 1);
        Point car2 = new Point(N, N);
        total = 0;

        for(int t = 0; t < tc; t++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Point np = new Point(x, y);

            sb.append(choice(car1, car2, np)).append("\n");
        }

        System.out.println(total);
        System.out.println(sb.toString());

    }

    public static int choice(Point car1, Point car2, Point point) {
        int dist1 = Math.abs(car1.x - point.x) + Math.abs(car1.y - point.y);
        int dist2 = Math.abs(car2.x - point.x) + Math.abs(car2.y - point.y);

        if(dist1>dist2){
            car2.setXY(point.x, point.y);
            total += dist2;
            return 2;
        }else {
            car1.setXY(point.x, point.y);
            total += dist1;
            return 1;
        }
    }
}
