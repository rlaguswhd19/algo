package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class level3_여행경로 {
	static String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
//	static String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
	static ArrayList<String> result;
	static boolean isOk;
	static boolean[] visit;
	public static void main(String[] args) {
		result = new ArrayList<>();
		result.add("ICN");
		visit = new boolean[tickets.length];
		dfs("ICN");
	}
	static void dfs(String start) {
		if(isOk) {
			return;
		}
		if(result.size() == tickets.length+1) {
			System.out.println(result);
			isOk = true;
			return;
		}
		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++) {
			if(!visit[i]) {
				if(tickets[i][0].equals(start)) {
					arr.add(new Point(tickets[i][1], i));
				}
			}
		}
		if(arr.size() == 0) {
			return;
		}
		Collections.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.to.compareTo(o2.to);
			}
		});
		for (int i = 0; i < arr.size(); i++) {
			Point p = arr.get(i);
			result.add(p.to);
			visit[p.index] = true; 
			dfs(p.to);
			result.remove(result.size()-1);
			visit[p.index] = false;
		}
	}
	static class Point{
		String to;
		int index;
		public Point(String to, int index) {
			super();
			this.to = to;
			this.index = index;
		}
		@Override
		public String toString() {
			return "Point [to=" + to + ", index=" + index + "]";
		}
	}
}
