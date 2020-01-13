package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main5719_4 {
	
	static int n, m, start, end;
	static ArrayList<edge>[] arr;
	static boolean[] visit;
	static ArrayList<ans> result;
	static int Min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
			}

			arr = new ArrayList[n];
			visit = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = new ArrayList<>();
			}
			if (n == 0 && m == 0) {
				break;
			}

			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				while (st.hasMoreTokens()) {
					int u = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					int p = Integer.parseInt(st.nextToken());
					arr[u].add(new edge(v, p));
				}
			}

			ArrayList<Integer> list = new ArrayList<>();
			list.add(start);
			result = new ArrayList<>();
			dfs(start, list, 0);
			Collections.sort(result, new Comparator<ans>() {

				@Override
				public int compare(ans o1, ans o2) {
					if(o1.sum < o2.sum) {
						return -1;
					}else {
						return 1;
					}
				}
			});
			int min = result.get(0).sum;
			for (int i = 0; i < result.size(); i++) {
				ans a = result.get(i);
				if(a.sum > min) {
					break;
				}
				for (int j = 0; j < a.list.size()-1; j++) {
					for (int j2 = 0; j2 < arr[a.list.get(j)].size(); j2++) {
						if(arr[a.list.get(j)].get(j2).end == a.list.get(j+1)) {
							arr[a.list.get(j)].remove(j2);
							break;
						}
					}
				}
			}
			
			visit = new boolean[n];
			
			dfs2(start, 0);
			
			if(Min != Integer.MAX_VALUE) {
				System.out.println(Min);
			}else {
				System.out.println(-1);
			}
		}
	}

	static void dfs(int now, ArrayList<Integer> list, int sum) {
		visit[now] = true;
		
		if(now == end) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				temp.add(list.get(i));
			}
			result.add(new ans(sum, temp));
			
		}
		for (int i = 0; i < arr[now].size(); i++) {
			edge edge = arr[now].get(i);
			if(!visit[edge.end]) {
				
				list.add(edge.end);
				dfs(edge.end, list, sum+edge.cost);
				list.remove(list.size()-1);
				
				visit[edge.end] = false;
			}
		}
	}
	
	static void dfs2(int now, int sum) {
		visit[now] = true;
		
		if(now == end) {
			Min = Math.min(Min, sum);
		}
		
		for (int i = 0; i < arr[now].size(); i++) {
			edge edge = arr[now].get(i);
			if(!visit[edge.end]) {
				dfs2(edge.end, sum+edge.cost);
				visit[edge.end] = false;
			}
		}
	}
	static class ans {
		int sum;
		ArrayList<Integer> list;
		
		public ans(int sum, ArrayList<Integer> list) {
			super();
			this.sum = sum;
			this.list = list;
		}
		
		@Override
		public String toString() {
			return "ans [sum=" + sum + ", list=" + list + "]";
		}
	}
	static class edge {
		int end;
		int cost;

		public edge(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "edge [end=" + end + ", cost=" + cost + "]";
		}
	}
}
