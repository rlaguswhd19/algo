package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class level2_가장큰수 {
	static int[] arr = {6,10,2};
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = "";
				String s2 = "";
				s1 = ""+o1+o2;
				s2 = ""+o2+o1;
				return Integer.parseInt(s2)-Integer.parseInt(s1);
			}
		});
		String ans = "";
		for(int i : list) {
			ans += i;
		}
		System.out.println(ans);
		
	}
}
