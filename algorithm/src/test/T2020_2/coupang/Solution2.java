package test.T2020_2.coupang;

public class Solution2 {
	static int[] dayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };
		solution(3, customers);
	}

	static int solution(int n, String[] customers) {
		int[] kiosk = new int[n + 1];
		int[] cnt = new int[n + 1];

		String[] temp = customers[0].split(" ");
		int pmonth = Integer.parseInt(temp[0].substring(0, 2));
		int pday = Integer.parseInt(temp[0].substring(3, 5));
		int phour = Integer.parseInt(temp[1].substring(0, 2));
		int pminute = Integer.parseInt(temp[1].substring(3, 5));
		int psecond = Integer.parseInt(temp[1].substring(6, 8));

		int task = Integer.parseInt(temp[2]);

		kiosk[0] = task; // 첫 손님의 일 시간
		cnt[0] = 1; // 손님 받음

		for (int i = 1; i < customers.length; i++) { // 처음 시간을 만든다.
			temp = customers[i].split(" ");

			int nmonth = Integer.parseInt(temp[0].substring(0, 2));
			int nday = Integer.parseInt(temp[0].substring(3, 5));
			int nhour = Integer.parseInt(temp[1].substring(0, 2));
			int nminute = Integer.parseInt(temp[1].substring(3, 5));
			int nsecond = Integer.parseInt(temp[1].substring(6, 8));

			// 지난 시간을 구해야 한다.
			// 날짜 먼저
			int day = 0;
			if (pmonth != nmonth) { // 달이 다르면
				day += dayOfMonth[pmonth] - pday;
				
				for (int j = pmonth + 1; j < nmonth; j++) {
					day += dayOfMonth[j];
				}
				
				day += nday;
			} else { // 달이 같으면
				day = nday - pday;
			}
			
			System.out.println(day);
			
			int t1 = 24 * 60 - (phour * 60 + pminute); // 전시간
			int t2 = nhour * 60 + nminute; // 지금시간
			int min = t1 + t2;
			System.out.println(t1);
			System.out.println(t2);
			if(nsecond < psecond) {
				min--;
			}
			
			System.out.println(min);
			
			if(min < 1440) {
				day--;
			}else {
				min -= 1440;
			}
			
			System.out.println(min);
			System.out.println(day);
			
			min += day * 1440;
			
			System.out.println(min);
			
			pmonth = nmonth;
			pday = nday;
			phour = nhour;
			pminute = nminute;
			psecond = nsecond;
		}

		return 1;
	}
}
