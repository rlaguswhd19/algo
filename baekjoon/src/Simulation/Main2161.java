package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2161 {
	static int n;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(q.size() > 1) {
			System.out.print(q.poll()+" ");
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
