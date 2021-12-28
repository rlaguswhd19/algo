package programmers.level3;

import java.util.*;

public class 하노이의탑 {
    static ArrayList<Move> list = new ArrayList<>();
    static Stack<Integer>[] tops = new Stack[3];

    public static void main(String[] args) {
        int n = 3;
        solution(n);
    }

    static int[][] solution(int n) {
        for (int i = 0; i < 3; i++) {
            tops[i] = new Stack<>();
        }
        for (int i = 0; i < n; i++) {
            tops[0].push(n - i);
        }

        hanoi(0, 2, n);

        Move m;
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            m = list.get(i);
            ans[i][0] = m.s + 1;
            ans[i][1] = m.e + 1;
        }
        return ans;
    }

    static void move(int s, int e) {
        tops[e].push(tops[s].pop()); // 옮긴다.
        list.add(new Move(s, e));
    }

    static void hanoi(int s, int e, int cnt) { // s -> e로 몇개 옮길건지
        boolean[] visit = new boolean[3];
        visit[s] = true;
        visit[e] = true;

        int temp = 0;
        for (int i = 0; i < 3; i++) {
            if (visit[i] == false) {
                temp = i;
                break;
            }
        }

        if (cnt == 1) {
            move(s, e);
        }else{
            hanoi(s, temp, cnt - 1);
            move(s, e);
            hanoi(temp, e, cnt - 1);
        }
    }


    static class Move {
        int s, e;

        public Move(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}

