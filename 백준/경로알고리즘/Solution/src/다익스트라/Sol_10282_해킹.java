package 다익스트라;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_10282_해킹 {


    private static class Point implements Comparable<Point> {
        int node;
        int dist;

        public Point(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }

    private static ArrayList<ArrayList<Point>> list;
    private static int[] dist = new int[10001];
    private final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < dist.length; i++) {
                dist[i] = INF;
            }

            for (int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());//컴퓨터 a가
                int b = Integer.parseInt(st.nextToken());//컴퓨터 b를 의존
                int s = Integer.parseInt(st.nextToken());//b가 감염되면 s초후 a도 감염됨

                list.get(b).add(new Point(a, s));
            }

            dijkstra(c);

            int cnt = 0;
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    cnt++;
                    result = Math.max(result, dist[i]);
                }
            }

            System.out.println(cnt + " " + result);
        }

    }

    private static void dijkstra(int start) {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Point tmp = pq.poll();
            int cur_dist = tmp.dist;
            int cur_point = tmp.node;

            if (dist[cur_point] < cur_dist) {
                continue;
            }

            for (int i = 0; i < list.get(cur_point).size(); i++) {
                int cost = dist[cur_point] + list.get(cur_point).get(i).dist;

                if (cost < dist[list.get(cur_point).get(i).node]) {
                    dist[list.get(cur_point).get(i).node] = cost;
                    pq.add(new Point(list.get(cur_point).get(i).node, cost));
                }
            }

        }

    }

}
