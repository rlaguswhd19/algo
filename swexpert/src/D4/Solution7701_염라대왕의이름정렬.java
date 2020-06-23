package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution7701_염라대왕의이름정렬 {
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			set = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					if(s1.length() < s2.length()) {
						return -1;
					}else if(s1.length() > s2.length()){
						return 1;
					}else {
						return s1.compareTo(s2);
					}
				}
			});
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				set.add(s);
			}
			
			Iterator<String> it = set.iterator();
			
			System.out.println("#"+tc);
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < set.size(); i++) {
				if(i == set.size() -1) {
					sb.append(it.next());
				}else {
					sb.append(it.next()+"\n");
				}
			}
            
			System.out.println(sb.toString());
		}
	}
}
