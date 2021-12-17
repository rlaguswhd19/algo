package programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {
        int n = 3;
        int[] works = {5, 5, 1, 1};
        System.out.println(solution(n, works));
    }

    static long solution(int n, int[] works) {

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        for (int i : works) {
            pq.add(i);
        }

        int temp;
        while (n > 0) {
            temp = pq.poll();

            if (temp == 0) {
                return 0;
            }

            temp--;
            pq.add(temp);
            n--;
        }

        while (!pq.isEmpty()) {
            temp = pq.poll();
            ans += Math.pow(temp, 2);
        }

        return ans;
    }
}
