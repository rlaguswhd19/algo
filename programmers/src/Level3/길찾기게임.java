package Level3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 길찾기게임 {
	static Queue<Node> q;
	static Node[] node_list;
	static int[][] ans;
	static int index;

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		solution(nodeinfo);
	}

	static int[][] solution(int[][] nodeinfo) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				if (nodeinfo[i1][1] < nodeinfo[i2][1]) {
					return 1;
				} else if (nodeinfo[i1][1] > nodeinfo[i2][1]) {
					return -1;
				} else {
					if (nodeinfo[i1][0] < nodeinfo[i2][0]) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		ans = new int[2][nodeinfo.length];
		node_list = new Node[nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++) {
			pq.add(i);
		}
		int min = 0;
		int max = 100000;
		Node root = new Node(pq.poll(), -1, -1, min, max);
		node_list[root.idx] = root;
		q = new LinkedList<>();
		q.add(root);
		while (!pq.isEmpty()) {
			Node n = q.poll();

			n.createLeft(nodeinfo, pq);

			if (pq.isEmpty()) {
				break;
			}

			n.createRight(nodeinfo, pq);
		}

		index = 0;
		preOrder(root);
		index = 0;
		postOrder(root);

		return ans;
	}

	static void preOrder(Node node) { // 전위순회
		ans[0][index++] = node.idx + 1;
		if (node.l != -1) {
			preOrder(node_list[node.l]);
		}

		if (node.r != -1) {
			preOrder(node_list[node.r]);
		}
	}

	static void postOrder(Node node) { // 후위순회
		if (node.l != -1) {
			postOrder(node_list[node.l]);
		}

		if (node.r != -1) {
			postOrder(node_list[node.r]);
		}

		ans[1][index++] = node.idx + 1;
	}

	static class Node {
		int idx, r, l, min, max;

		public Node(int idx, int r, int l, int min, int max) {
			super();
			this.idx = idx;
			this.r = r;
			this.l = l;
			this.min = min;
			this.max = max;
		}

		private void createLeft(int[][] nodeinfo, PriorityQueue<Integer> pq) {
			int idx = pq.peek();
			if (this.min <= nodeinfo[idx][0] && nodeinfo[idx][0] <= nodeinfo[this.idx][0]) {
				pq.poll(); // 뽑고
				this.l = idx; // left인덱스는 idx;
				Node left = new Node(idx, -1, -1, this.min, nodeinfo[this.idx][0]);
				node_list[idx] = left; // node_list에 Node 추가
				q.add(left); // 부모로서 넣어주기
			}
		}

		private void createRight(int[][] nodeinfo, PriorityQueue<Integer> pq) {
			int idx = pq.peek();
			if (nodeinfo[this.idx][0] <= nodeinfo[idx][0] && nodeinfo[idx][0] <= this.max) {
				pq.poll();
				this.r = idx;
				Node right = new Node(idx, -1, -1, nodeinfo[this.idx][0], this.max);
				node_list[idx] = right;
				q.add(right);
			}
		}
	}
}
