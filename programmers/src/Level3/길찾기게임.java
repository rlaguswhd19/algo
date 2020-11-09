package Level3;

public class 길찾기게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		solution(nodeinfo);
	}

	static void solution(int[][] nodeinfo) {
		
	}

	static class Node {
		int r, l, min, max;

		public Node(int r, int l, int min, int max) {
			super();
			this.r = r;
			this.l = l;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", l=" + l + ", min=" + min + ", max=" + max + "]";
		}
	}
}
