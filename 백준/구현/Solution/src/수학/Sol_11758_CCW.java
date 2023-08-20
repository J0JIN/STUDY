package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_11758_CCW {

    private static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] points = new Point[4];
        for(int i = 0; i <3; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        points[3] = points[0];

        int ans = CCW(points);

        if(ans > 0){
            System.out.println(1);
        }else if(ans < 0){
            System.out.println(-1);
        }else{
            System.out.println(0);
        }
    }

    private static int CCW(Point[] points) {
        int xy = 0;
        int yx = 0;

        for(int i = 0; i < 3; i++){
            xy += points[i].x * points[i+1].y;
            yx += points[i].y * points[i+1].x;
        }

        return xy - yx;
    }
}
