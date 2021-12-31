package test.T2021_2.ebay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        int[] stones = {1, 3, 2};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    static String solution(int[] stones, int k) {
        return bfs(stones, k);
    }

    static String bfs(int[] stones, int k) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(stones, stones.length, new String()));

        int cnt;
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println(q);
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                StringBuilder sb = new StringBuilder(p.idx);
                if(p.cnt == p.arr.length - 1) {
                    for (int j = 0; j < p.arr.length; j++) {
                        if(p.arr[j] == k) {
                            return sb.toString();
                        }
                    }
                }

                for (int j = 0; j < p.arr.length; j++) {
                    sb = new StringBuilder(p.idx);
                    if (!check(p.arr, j)) {
                        continue;
                    }

                    int[] copy = add(p.arr, j);
                    sb.append(j);
                    cnt = 0;
                    for (int a = 0; a < copy.length; a++) {
                        if (copy[a] == 0) {
                            cnt++;
                        }
                    }

                    q.add(new Point(copy, cnt, sb.toString()));
                }
            }
        }

        return "-1";
    }

    static boolean check(int[] arr, int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) {
                continue;
            }

            if (arr[i] == 0) {
                return false;
            }
        }

        return true;
    }

    static int[] add(int[] stones, int idx) {
        int[] copy = new int[stones.length];

        for (int i = 0; i < stones.length; i++) {
            if (i == idx) {
                continue;
            }
            copy[i] = stones[i] - 1;
        }

        copy[idx] = stones[idx] + 1;
        return copy;
    }

    static class Point {
        int[] arr; // 돌무더기
        int cnt; // 돌무더기 갯수
        String idx; // 진행

        public Point(int[] arr, int cnt, String idx) {
            this.arr = arr;
            this.cnt = cnt;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "arr=" + Arrays.toString(arr) +
                    ", cnt=" + cnt +
                    ", idx='" + idx + '\'' +
                    '}';
        }
    }
}
