package baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197 {
    static int v, e, ans = 0;
    static int[] parent;
    static PriorityQueue<Eage> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>(new Comparator<Eage>() {
            @Override
            public int compare(Eage e1, Eage e2) {
                if(e1.d < e2.d){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        int x, y, d;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            pq.add(new Eage(x, y, d));
        }

        while(!pq.isEmpty()) {
            Eage eage = pq.poll();
            union(eage);
        }

        System.out.println(ans);
    }

    static int find(int child) {
        if (parent[child] == child) {
            return child;
        } else {
            return parent[child] = find(parent[child]);
        }
    }

    static void union(Eage eage) {
        int ps = find(eage.s);
        int pe = find(eage.e);

        if(ps == pe) {
            return;
        }

        ans+= eage.d;
        parent[ps] = pe;
    }

    static class Eage {
        int s, e, d;

        public Eage(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}
