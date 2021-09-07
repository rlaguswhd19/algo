package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11404 {
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        StringTokenizer st;
        int s, e, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            dist[s][e] = Integer.min(dist[s][e], d);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) {
                    sb.append(0+" ");
                }else{
                    sb.append(dist[i][j]+" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
