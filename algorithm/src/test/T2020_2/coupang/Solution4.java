package test.T2020_2.coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
	public static void main(String[] args) {
		String depar = "SEOUL";
		String hub = "DAEGU";
		String dest = "YEOSU";
		String[][] roads = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
				{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
				{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
				{ "BUSAN", "YEOSU" } };
//		String depar = "ULSAN";
//		String hub = "SEOUL";
//		String dest = "BUSAN";
//		String[][] roads = {{"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"}};
		System.out.println(solution(depar, hub, dest, roads));
	}

	static int solution(String depar, String hub, String dest, String[][] roads) {
//		depar 출발지
//		hub 중간
//		dest 목적지
		int ans = 0;

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		ArrayList<String> list;
		for (int i = 0; i < roads.length; i++) {
			if (map.containsKey(roads[i][0])) { // 출발지가 이미 있다면
				list = map.get(roads[i][0]);
				list.add(roads[i][1]);

				map.put(roads[i][0], list);
			} else {
				list = new ArrayList<>();
				list.add(roads[i][1]);

				map.put(roads[i][0], list);
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(depar, 0));

		// 먼저 허브로 가기
		while (!q.isEmpty()) {
			Node node = q.poll();

			String now = node.now;
			int check = node.check;

			if (now.equals(hub)) { // 허브면 1로
				check = 1;
			}

			if (now.equals(dest)) {
				if(check == 1) {
					ans++;
				}
			} else {
				// 다음 갈곳이 있으면
				if(map.containsKey(now)) {
					list = map.get(now);
					
					for (String next : list) {
						q.add(new Node(next, check));
					}
				}
			}

		}

		return ans;
	}

	static class Node {
		String now;
		int check;

		public Node(String now, int check) {
			super();
			this.now = now;
			this.check = check;
		}

		@Override
		public String toString() {
			return "Node [now=" + now + ", check=" + check + "]";
		}
	}
}
