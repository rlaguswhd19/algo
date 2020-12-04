package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2930_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if(o1 < o2) {
						return 1;
					}else {
						return -1;
					}
				}
			});
			StringTokenizer st; 
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc);
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				if(st.countTokens() == 1) {
					if(pq.isEmpty()) {
						sb.append(" "+(-1));
					}else {
						sb.append(" "+pq.poll());
					}
				}else {
					st.nextToken();
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			
			System.out.println(sb.toString());
		}
	}
}
