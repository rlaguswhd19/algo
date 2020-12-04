package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2820 {
	static int n, m;
	static Node[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new Node[n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			if (i == 1) {
				list[i] = new Node(Integer.parseInt(st.nextToken()), 0);
			} else {
				int money = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				list[i] = new Node(money, parent);
				list[parent].children.add(i);
			}
		}
		
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			String[] word = s.split(" ");
			String pu = word[0];
			if(pu.equals("p")) {
				bfs(Integer.parseInt(word[1]), Integer.parseInt(word[2]));
			}else {
				int num = Integer.parseInt(word[1]);
				System.out.println(list[num].value);
			}
		}
//		System.out.println(Arrays.toString(list));
	}

	static void bfs(int root, int plus) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				ArrayList<Integer> children = list[num].children;

				if (children.isEmpty()) {
					continue;
				}

				for (int j = 0; j < children.size(); j++) {
					int child = children.get(j);
					list[child].value += plus;
					q.add(child);
				}
			}
		}
	}

	static class Node {
		int value, parent;
		ArrayList<Integer> children;

		public Node(int value, int parent) {
			super();
			this.value = value;
			this.parent = parent;
			this.children = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", parent=" + parent + ", children=" + children + "]";
		}
	}
}
