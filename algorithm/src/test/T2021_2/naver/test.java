package test.T2021_2.naver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class test {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		pq.add(1);
		pq.add(10);
		
		
		HashMap<Integer, String> map = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		String s = new String();
		
		s.charAt(1);
		s.toCharArray();
		
		while(!pq.isEmpty()) {
			
		}
	}
}
