package programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 6, 9 }, { 6, 6 } };
		System.out.println(solution(jobs));
	}

	static int solution(int[][] jobs) {
		// job list
		PriorityQueue<Point> list = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.time < p2.time) {
					return -1;
				} else if (p1.time > p2.time) {
					return 1;
				} else {
					if (p1.cost < p2.cost) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});

		for (int i = 0; i < jobs.length; i++) {
			int time = jobs[i][0];
			int cost = jobs[i][1];
			Point p = new Point(time, cost);
			list.add(p);
		}

		Point first = list.poll();

		// disk cost 낮은것 먼저 처리
		PriorityQueue<Point> disk = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.cost < p2.cost) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		disk.add(first);
		int now = first.time; // 시간 = 첫일을 받은시간부터 시작
		int sum = 0; // 요청부터 종료까지 시간의 합
		while (!disk.isEmpty()) {
			Point job = disk.poll();
			
			// 현재시간 + cost
			now += job.cost;
			// 요청부터 종료까지 시간
			sum += now - job.time;
			
			select: while (!list.isEmpty()) { // 현재시간까지 할 수 있는 모든일을 disk에 넣기
				Point next = list.peek();

				if (next.time > now) {
					break select;
				}
				
				list.poll();
				disk.add(next);
			}
			
			// 시간이 지났는데 일거리가 없으면 그다음 일거리를 받아서 처리하자
			if(disk.isEmpty()) {
				if(!list.isEmpty()) {
					Point next = list.poll();
					now = next.time; // 일을 받은 시간으로 바꿔주기
					disk.add(next);
				}
			}
		}

		return sum / jobs.length;
	}

	static class Point {
		int time, cost;

		public Point(int time, int cost) {
			super();
			this.time = time;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Point [time=" + time + ", cost=" + cost + "]";
		}
	}
}
