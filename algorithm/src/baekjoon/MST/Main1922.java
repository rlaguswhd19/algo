package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1922 {
    static PriorityQueue<Point> pq;
    static int[] parent;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n +1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.d < p2.d) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        StringTokenizer st;
        int x, y, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            pq.add(new Point(x, y, d));
        }

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            union(p);
        }

        System.out.println(ans);
    }

    static int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        } else {
            return parent[idx] = find(parent[idx]);
        }
    }

    static void union(Point p) {
       p.x = find(p.x);
       p.y = find(p.y);

       if(p.x == p.y) {
            return;
       }

       parent[p.y] = p.x;
       ans += p.d;
    }


    static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
