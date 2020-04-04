package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main2164 {
	static int n;
	static Deque<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		bfs();
	}

	static void bfs() {
		q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() > 1) {
			q.poll();
			int num = q.poll();
			q.add(num);
		}
		
		System.out.println(q.peek());
	}
}
