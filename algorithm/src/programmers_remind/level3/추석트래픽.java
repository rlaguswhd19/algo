package programmers_remind.level3;

import java.util.PriorityQueue;

public class 추석트래픽 {
    static PriorityQueue<Integer> spq = new PriorityQueue<>();
    static PriorityQueue<Integer> epq = new PriorityQueue<>();

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(lines));
    }

    static int solution(String[] lines) {
        int ans = 0;

        for (String line : lines) {
            dateToTime(line);
        }

        int cnt = 0, start, end = epq.poll();
        while (!spq.isEmpty()) {
            start = spq.peek();

            if (end + 999 < start) { // 끝날때마다 하나씩 빠진다.
                ans = Math.max(ans, cnt);
                cnt--;
                end = epq.poll();
            } else { // 끝나기전까지 start를 추가한다.
                cnt++;
                spq.poll();
            }
        }

        ans = Math.max(ans, cnt);

        return ans;
    }

    static void dateToTime(String line) {
        int hour, minute, time;
        double second, later;
        hour = Integer.parseInt(line.substring(11, 13)) * 60;
        minute = Integer.parseInt(line.substring(14, 16));
        minute += hour;
        time = minute * 60 * 1000;
        second = Double.parseDouble(line.substring(17, 23)) * 1000;
        time += (int) second;
        later = Double.parseDouble(line.substring(24, line.length() - 1)) * 1000;

        spq.add(time - (int) later + 1);
        epq.add(time);
    }
}
