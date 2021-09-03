package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    static int[] ans = new int[5];
    static char[][] map = new char[5][5];
    static boolean[][] visit;
    static Queue<Point> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    static int[] solution(String[][] places) {
        for (int i = 0; i < 5; i++) {
            String[] arr = places[i];

            for (int j = 0; j < 5; j++) {
                String s = arr[j];
                map[j] = s.toCharArray();
            }

            check(i);
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }

    static void check(int idx) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 응시자가 앉아있으면 BFS한다.
                if (map[i][j] == 'P') {
                    if(!bfs(i, j)) {
                        ans[idx] = 0;
                        return;
                    }
                }
            }
        }

        ans[idx] = 1;
    }

    static boolean bfs(int x, int y) {
        visit = new boolean[5][5];
        q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;

        int cnt = 0, size = 0;
        int nx, ny;
        while (cnt < 2) {
            size = q.size();

            for (int i = 0; i < size; i++) {
                Point p = q.poll();

                for (int j = 0; j < 4; j++) {
                    nx = p.x + dx[j];
                    ny = p.y + dy[j];

                    if(!isOk(nx, ny)) {
                        continue;
                    }

                    if(visit[nx][ny]) {
                       continue;
                    }

                    if(map[nx][ny] == 'X') {
                        continue;
                    }

                    if(map[nx][ny] == 'P') {
                        return false;
                    }

                    q.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }

            cnt++;
        }

        return true;
    }

    static boolean isOk(int nx, int ny) {
        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
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
    }
}
