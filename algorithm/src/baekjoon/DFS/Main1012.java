package baekjoon.DFS;

import java.util.Scanner;

public class Main1012 {
    static int[][] array;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            array = new int[m][n];
            visit = new boolean[m][n];
            count = 0;
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                array[x][y] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && array[i][j] == 1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int i, int j) {
        visit[i][j] = true;
        for (int index = 0; index < 4; index++) {
            if (i + dx[index] >= 0 && i + dx[index] < m && j + dy[index] >= 0 && j + dy[index] < n) {
                if (!visit[i + dx[index]][j + dy[index]] && array[i + dx[index]][j + dy[index]] == 1) {
                    DFS(i + dx[index], j + dy[index]);
                }
            }
        }
    }
}
