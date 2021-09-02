package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2638 {
    static int n, m;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q;
    static ArrayList<Point> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        arr = new ArrayList<>();
        map = new int[n][m];
        int num = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 1) {
                    arr.add(new Point(i, j));
                }
            }
        }

        bfs();
    }

    // 치즈 없애기
    static void bfs() {
        for (int i = 0; i < m; i++) {
            if(map[0][i] == 1) {
                continue;
            }
            q.add(new Point(0, i));

            if(map[n-1][i] == 1) {
                continue;
            }

            q.add(new Point(n-1, i));
        }

        for (int i = 0; i < n; i++) {
            if(map[i][0] == 1) {
                continue;
            }
            q.add(new Point(i, 0));

            if(map[i][m-1] == 1) {
                continue;
            }

            q.add(new Point(i, m-1));
        }

        check();

        int time = 0;
        while(arr.size() != 0) {
            remove();
            check();
            time++;
        }

        System.out.println(time);
    }

    // 가장자리 체크하기
    static void check() {

        int nx, ny;
        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.x][p.y] = 2;

            for (int i = 0; i < 4; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];

                if (!isOk(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == 1 || map[nx][ny] == 2) {
                    continue;
                }

                q.add(new Point(nx, ny));
            }
        }
    }

    // 치즈 없애기
    static void remove() {
        int nx, ny, cnt;
        for (int i = 0; i < arr.size(); i++) {
            Point p = arr.get(i);
            cnt = 0;

            for (int j = 0; j < 4; j++) {
                nx = p.x + dx[j];
                ny = p.y + dy[j];

                if(!isOk(nx, ny)) {
                    continue;
                }

                if(map[nx][ny] == 2) {
                    cnt++;
                }
            }


            if(cnt >= 2) {
                q.add(arr.get(i));
                arr.remove(i);
                i--;
            }
        }
    }


    static boolean isOk(int nx, int ny) {
        if (nx < n && nx >= 0 && ny < m && ny >= 0) {
            return true;
        } else {
            return false;
        }
    }


    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
