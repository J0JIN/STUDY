package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_17386_선분교차1 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] a = new Point[2];
        Point[] b = new Point[2];

        st = new StringTokenizer(br.readLine());
        a[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        a[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        b[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        b[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        Point[] a0a1b0 = {a[0], a[1], b[0], a[0]};
        Point[] a0a1b1 = {a[0], a[1], b[1], a[0]};
        Point[] b0b1a0 = {b[0], b[1], a[0], b[0]};
        Point[] b0b1a1 = {b[0], b[1], a[1], b[0]};

        long CCW_a0a1b0 = CCW(a0a1b0);
        long CCW_a0a1b1 = CCW(a0a1b1);
        long CCW_b0b1a0 = CCW(b0b1a0);
        long CCW_b0b1a1 = CCW(b0b1a1);

        if (CCW_a0a1b0 * CCW_a0a1b1 < 0 && CCW_b0b1a0 * CCW_b0b1a1 < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static long CCW(Point[] points) {
        long xy = 0;
        long yx = 0;

        for (int i = 0; i < 3; i++) {
            xy += (long) points[i].x * (long) points[i + 1].y;
            yx += (long) points[i].y * (long) points[i + 1].x;
        }

        if (xy - yx > 0) {
            return 1;
        } else if (xy - yx == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
