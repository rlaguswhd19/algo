package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17825 {
	static ArrayList<Node> map;
	static int max = 0;
	static int[] valueArr = { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 12, 14, 16, 18, 20, 22, 24, 22, 24, 26, 28, 30, 28, 27,
			26, 32, 34, 36, 38, 40, 30, 35, 0 };
	static int[] nextArr = { 1, 2, 3, 4, 5, 10, 7, 8, 9, 30, 11, 12, 13, 14, 17, 16, 9, 18, 19, 20, 21, 25, 23, 24, 9,
			26, 27, 28, 29, 32, 31, 29, 0 };
	static Queue<Game> q;
	static ArrayList<Integer> move;

	public static void main(String[] args) throws IOException {
		setMap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		move = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			move.add(Integer.parseInt(st.nextToken()));
		}

		bfs();
//		System.out.println(q);
		while (!q.isEmpty()) {
			int sum = 0;
			Game game = q.poll();
			for (int i = 0; i < game.arr.length; i++) {
				sum += game.arr[i].sum;
			}
			if (max < sum) {
				max = sum;
			}
		}
		System.out.println(max);
	}

	static void bfs() {

		q = new LinkedList<>();
		Horse[] arr = new Horse[4];

		// 말 4마리 넣기
		for (int i = 0; i < 4; i++) {
			arr[i] = new Horse(0, 0, false);
		}

		// game 넣기
		q.add(new Game(arr));

		int cnt = 0;

		while (cnt < 10) {
			int size = q.size();
			for (int s = 0; s < size; s++) {

				Game game = q.poll();
				Horse[] list = game.arr;
				ArrayList<Integer> visit = new ArrayList<>();
				for (int i = 0; i < list.length; i++) {
					visit.add(list[i].now);
				}
				int num = move.get(cnt);

				for (int i = 0; i < list.length; i++) {

					// 말이 없으면 지나가
					if (list[i].out) {
						continue;
					}

					// 말이있다
					Horse h = list[i];
					int now = h.now;
					int sum = h.sum;
					boolean out = false;
					boolean notEmpty = false;

					// 주사위만큼 가도록하자
					for (int j = 0; j < num; j++) {

						// 현재 위치의 Node
						Node n = map.get(now);

						// now = next 다음 자리로 이동
						if (j == 0 && n.jumpnext != 0) {
							now = n.jumpnext;
						} else {
							now = n.next;
						}

						// 자리가 32면 도착한거니까 말은 나가고 답에 +해줘
						if (now == 32) {
							out = true;
							break;
						}

						// 안나갔으면 말의 가중치에 더해주자.
						Node next = map.get(now);

						// 말이 있는지 없는지 마지막 가는곳을 확인하자
						if (j == num - 1) {
							// 갔던곳이면
							if (visit.contains(now)) {
								// 비어있지않아 이미 말이 있다구
								notEmpty = true;
							} else {
								sum += next.cost;
							}
						}
					}

					// q에 넣어주기
					if (out) {
						list[i] = new Horse(32, sum, out);
						q.add(new Game(list.clone()));
						list[i] = h;
					} else {
						if (!notEmpty) {
							list[i] = new Horse(now, sum, out);
							q.add(new Game(list.clone()));
							list[i] = h;
						}
					}
				}
			}
			// 다음 주사위 굴리기
			cnt++;
		}
	}

	static void setMap() {
		map = new ArrayList<>();

		for (int i = 0; i < 33; i++) {
			if (i == 5) {
				map.add(new Node(nextArr[i], valueArr[i], 6));
			} else if (i == 14) {
				map.add(new Node(nextArr[i], valueArr[i], 15));
			} else if (i == 21) {
				map.add(new Node(nextArr[i], valueArr[i], 22));
			} else {
				map.add(new Node(nextArr[i], valueArr[i], 0));
			}
		}
	}

	static class Horse {
		int now, sum;
		boolean out;

		public Horse(int now, int sum, boolean out) {
			super();
			this.now = now;
			this.sum = sum;
			this.out = out;
		}

		@Override
		public String toString() {
			return "Horse [now=" + now + ", sum=" + sum + ", out=" + out + "]";
		}
	}

	static class Game {
		Horse[] arr;

		public Game(Horse[] arr) {
			super();
			this.arr = arr;
		}

		@Override
		public String toString() {
			return "Game [arr=" + Arrays.toString(arr) + "]";
		}
	}

	static class Node {
		int next;
		int cost;
		int jumpnext;

		public Node(int next, int cost, int jumpnext) {
			super();
			this.next = next;
			this.cost = cost;
			this.jumpnext = jumpnext;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", cost=" + cost + ", jumpnext=" + jumpnext + "]";
		}
	}
}
