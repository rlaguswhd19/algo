package programmers.level3;

public class N_Queen {
    static int[][] map;
    static int ans = 0;
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        map = new int[n][n];
        dfs(0, n);
        return ans;
    }

    static void dfs(int x, int n) {
        if (x == n) { // 끝까지 도달하면 return
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[x][i] != 0) {
                continue;
            }

            map[x][i] = x + 1;
            fill(x, i, x + 1, x + 1);
            dfs(x + 1, n);
            map[x][i] = 0;
            fill(x, i, x + 1, 0);
        }
    }

    static void fill(int x, int y, int idx, int mark) { // 체스가 놓이면 표시한다.
        boolean[] visit = new boolean[8]; // 8방향 검사
        int nx, ny;
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (visit[j]) {
                    continue;
                }

                nx = x + (dx[j] * i);
                ny = y + (dy[j] * i);

                if (!isOk(nx, ny)) {
                    visit[j] = true;
                    continue;
                }

                if (mark == 0) { // 지우는 경우
                    if (map[nx][ny] == idx) {
                        map[nx][ny] = mark; // 지우기
                    }
                } else {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = mark; // 표시하기
                    }
                }
            }
        }
    }

    static boolean isOk(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
            return true;
        }

        return false;
    }
}
