package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금 {
    static ArrayList<Eadge>[] list;
    static int[][] dist;
    static int ans = Integer.MAX_VALUE;
    static PriorityQueue<Eadge> pq = new PriorityQueue<>(new Comparator<Eadge>() {
        @Override
        public int compare(Eadge e1, Eadge e2) {
            if (e1.cost < e2.cost) {
                return -1;
            } else {
                return 1;
            }
        }
    });

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        solution(n, s, a, b, fares);
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int[] fare;
        list = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int next, cost, now;

        for (int i = 0; i < fares.length; i++) {
            fare = fares[i];
            now = fare[0];
            next = fare[1];
            cost = fare[2];
            list[now].add(new Eadge(next, cost));
            list[next].add(new Eadge(now, cost));
        }

        for (int i = 1; i < n + 1; i++) {
            dijkstra(i, i);
        }

        int two, ryan, apeach;
        for (int i = 1; i < n+1; i++) {
            two = dist[s][i]; // 합승
            ryan = dist[i][a];
            apeach = dist[i][b];
            ans = Math.min(ans, two + ryan + apeach);
        }

        return ans;
    }

    static void dijkstra(int start, int idx) {
        dist[idx][start] = 0;
        pq.add(new Eadge(start, 0));
        Eadge e;
        ArrayList<Eadge> arr;
        while (!pq.isEmpty()) {
            e = pq.poll();

            if (dist[idx][e.next] < e.cost) {
                continue;
            }

            arr = list[e.next];

            for (int i = 0; i < arr.size(); i++) {
                Eadge ne = arr.get(i);

                if (dist[idx][ne.next] > dist[idx][e.next] + ne.cost) {
                    dist[idx][ne.next] = dist[idx][e.next] + ne.cost;
                    pq.add(new Eadge(ne.next, dist[idx][ne.next]));
                }
            }
        }
    }

    static class Eadge {
        int next, cost;

        public Eadge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
