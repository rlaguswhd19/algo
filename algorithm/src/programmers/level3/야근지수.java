package programmers.level3;

import java.util.Arrays;

public class 야근지수 {
    public static void main(String[] args) {
        int n = 1;
        int[] works = {2, 1, 2};
        System.out.println(solution(n, works));
    }

    static long solution(int n, int[] works) {

        long ans = 0;
        long sum = Arrays.stream(works).mapToLong(i -> i).sum(); // 합
        int len = works.length; // 길이
        long avg = (sum - n) / len; // 평균값
        long r = n - (avg * len); // 평균값을 제외한 나머지

        for (int i : works) {
            if (i < avg) { // 평균보다 크면
                r += avg - i; // 나머지 적립
            }
        }

        if(r >= avg * len) { // 나머지가 더 크면
            r -= avg * len;
            avg--;
        }

        for (int i : works) {
            if(i < avg) {
                ans += Math.pow(i, 2);
            }else {
                if(r > 0) {
                    ans += Math.pow(avg - 1, 2);
                    r--;

                }else{
                    ans += Math.pow(avg, 2);
                }
            }
        }

        return ans;
    }
}
