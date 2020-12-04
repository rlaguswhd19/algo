package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) {
//		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
//				{ "ATL", "SFO" } };
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" } };
		solution(tickets);
	}

	static String[] solution(String[][] tickets) {
		visit = new boolean[tickets.length];
		sb.append("ICN,");
		dfs(tickets, "ICN", 0);
		
		System.out.println(list);
		Collections.sort(list);
		return list.get(0).split(",");
	}

	static void dfs(String[][] tickets, String now, int cnt) {
		if(cnt == tickets.length) {
			list.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String end = tickets[i][1];

			if (start.equals(now) && !visit[i]) {
				visit[i] = true;
				sb.append(end + ",");
				dfs(tickets, end, cnt + 1);
				sb.delete(sb.length() - 4, sb.length());
				visit[i] = false;
			}
		}
	}
}
