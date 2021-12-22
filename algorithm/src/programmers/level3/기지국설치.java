package programmers.level3;

public class 기지국설치 {
    public static void main(String[] args) {
        int N = 11;
        int[] station = {4, 7, 11};
        int W = 1;

        System.out.println(solution(N, station, W));
    }

    static int solution(int n, int[] stations, int w) {
        int ans = 0;
        int len = 2 * w + 1;

        int next = 1;
        int distance;
        for (int station : stations) {
            if(station + w >= next && station - w <= next) {
                next = station + w + 1;
                continue;
            }

            distance = station - w - next;
            ans += distance / len;
            if (distance % len != 0) {
                ans++;
            }
            next = station + w + 1;
        }

        if (next <= n) {
            distance = n - next + 1;
            ans += distance / len;
            if (distance % len != 0) {
                ans++;
            }
        }

        return ans;
    }
}
