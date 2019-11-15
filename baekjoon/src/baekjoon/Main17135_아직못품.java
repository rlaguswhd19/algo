package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main17135_아직못품 {
	static int n, m, d;
	static int[] arr;
	static boolean[] visit;
	static int[] Com;
	static ArrayList<enemy> Enemy;
	static ArrayList<enemy> Enemycopy;
	static ArrayList<enemy> Archer;
	static ArrayList<enemy> remove;
	static int max, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		Enemycopy = new ArrayList<>();
		Com = new int[3];
		arr = new int[m];
		visit = new boolean[m];
		result = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

//		입력값 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int num = sc.nextInt();
				if (num == 1) {
					Enemycopy.add(new enemy(i, j));
				}
			}
		}
		place(0, 0);
//		Archer = new ArrayList<>();
//		Archer.add(new enemy(n,1));
//		Archer.add(new enemy(n,2));
//		Archer.add(new enemy(n,3));
//		remove_enemy();
//		System.out.println(Enemy);
		System.out.println(result);
	}

	static void remove_enemy() {
		// 아처 거리 안에 들어오는 애들임
		ArrayList<enemy> candidate = new ArrayList<>();
		remove = new ArrayList<>();
		for (int i = Enemy.size() - 1; i >= 0; i--) {
			enemy e = Enemy.get(i);
//			System.out.println(e.x);
//			System.out.println(n-d);
			if (e.x >= n - d) { // 아처의 사정거리 안에 들어올때
				candidate.add(e); // 추가
			}
		}

		// 후보임
//		System.out.println(candidate);

		// 후보에서 거리 계산할꺼야 제일 가까운애 뽑아야대 아처 3명 돌려서
		for (int i = 0; i < Archer.size(); i++) {
			enemy archer = Archer.get(i);
			distance(archer, candidate);
		}

		// 후보자 보기
//		System.out.println(candidate);
		// max에 더하기
		max += remove.size();

		// 죽일애들 보기
//		System.out.println("remove : " + remove);

		// 쏴죽여 가까운애들
		for (int i = 0; i < remove.size(); i++) {
			Enemy.remove(remove.get(i));
		}

		// 죽은후 애들 보기
//		System.out.println(Enemy);
	}

	static void distance(enemy archer, ArrayList<enemy> candidate) {
		int min = Integer.MAX_VALUE;
		enemy target = null;
		for (int i = 0; i < candidate.size(); i++) {
			enemy e = candidate.get(i);
			int dis = Math.abs(archer.y - e.y) + Math.abs(archer.x - e.x);
			// d에 맞춰서 넣어야됌
			// 최대한 죽일려면 안겹치게 3개 넣는게 최고임 그럼 여기서도 리스트를 만들어서 넣는게 좋음
			if (dis < min) {
				min = dis;
				if(min <= d) {
					target = e;
				}
			}
		}
		if(target != null) {
			if(!remove.contains(target)) {
				remove.add(target);
			}
		}
	}

	// 궁수 배치
	static void place(int target, int cnt) {
		if (cnt == 3) {
			max = 0;
			Enemy = new ArrayList<>();
//			복사
			for (int i = 0; i < Enemycopy.size(); i++) {
				enemy e = Enemycopy.get(i);
				Enemy.add(new enemy(e.x, e.y));
			}

//			궁수배치
			Archer = new ArrayList<>();
//			System.out.println(Arrays.toString(Com));
			for (int i = 0; i < Com.length; i++) {
				Archer.add(new enemy(n, Com[i]));
			}
//			System.out.println(Archer);
			while (!Enemy.isEmpty()) {
				remove_enemy();
				move();
			}
//			System.out.println("max : " +max);
//			System.out.println("Archer : "+Archer);
			result = Math.max(max, result);
//			System.out.println(result);
			return;
		} else if (target == arr.length) {
			return;
		} else {
			Com[cnt] = arr[target];
			place(target + 1, cnt + 1);
			place(target + 1, cnt);
		}
	}

	static void move() {
		// 벽에 부딫치면 사라지고
		ArrayList<enemy> crush = new ArrayList<>();

		for (int i = 0; i < Enemy.size(); i++) {
			enemy e = Enemy.get(i);
			e.x += 1; // 한칸이동
			if (e.x >= n) {
				crush.add(e);
			}
		}
		for (int i = 0; i < crush.size(); i++) {
			Enemy.remove(crush.get(i));
		}
	}

	static class enemy {
		int x, y;

		public enemy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "enemy [x=" + x + ", y=" + y + "]";
		}
	}
}
