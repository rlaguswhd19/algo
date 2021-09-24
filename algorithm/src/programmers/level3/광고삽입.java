package programmers.level3;

public class 광고삽입 {
    static int[] arr;

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        solution(play_time, adv_time, logs);
    }

    static String solution(String play_time, String adv_time, String[] logs) {
        String ans = new String();
        int play = timeToInt(play_time);
        int adv = timeToInt(adv_time);
        arr = new int[360000];
        int start, end;
        long cal_time = 0, view = 0, max = 0;

        for (int i = 0; i < logs.length; i++) {
            String[] temp = logs[i].split("-");
            start = timeToInt(temp[0]);
            end = timeToInt(temp[1]);
            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        for (int i = 0; i < adv; i++) {
            view += arr[i];
        }

        start = 0;
        end = adv;
        max = view;

        while (end <= play) {
            view -= arr[start++];
            view += arr[end++];

            if (max < view) {
                cal_time = start;
                max = view;
            }
        }

        ans = timeToString(cal_time);
        return ans;
    }

    static int timeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 3600 + Integer.parseInt(temp[1]) * 60 + Integer.parseInt(temp[2]);
    }

    static String timeToString(long time) {
        long hour = time / 3600;
        time %= 3600;
        long minute = time / 60;
        long second = time % 60;

        StringBuilder sb = new StringBuilder();
        sb.append((hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second));
        return sb.toString();
    }
}
