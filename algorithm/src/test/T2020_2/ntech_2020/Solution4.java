package test.T2020_2.ntech_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
	static int[] arr1, arr2;
	static ArrayList<Integer> end_list;
	static boolean[] visit1, visit2;
	static int end, ans;

	public static void main(String[] args) {
		int[][] t1 = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[][] t2 = {{-1, 1}, {-1, -1}};
		solution(t1, t2);
	}

	static int solution(int[][] t1, int[][] t2) {
		ans = 0;
		arr1 = new int[t1.length]; // 노드 갯수 부모 배열
		arr2 = new int[t2.length]; // 노드 갯수 부모 배열
		end_list = new ArrayList<>();

		parent(t1, t2);
		end(0, t2);

		System.out.println(end);
		System.out.println(end_list);
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr1));

		for (int i = 0; i < end_list.size(); i++) {
			check(end_list.get(i), t1, t2);
		}
		
		System.out.println(ans);
		return ans;
	}

	static void check(int endIdx, int[][] t1, int[][] t2) {
		visit1 = new boolean[arr1.length]; // 뒤에서 부터 올라가기
		visit2 = new boolean[arr2.length];

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		q1.add(endIdx);
		visit1[endIdx] = true;
		q2.add(end);
		visit2[end] = true;
		System.out.println();
		
		while (!q2.isEmpty()) {
			// 둘이 다르면 끝내기
			int size = q1.size();
			System.out.println(q1);
			System.out.println(q2);
			if (q1.size() != q2.size()) {
				return;
			}
			for (int i = 0; i < size; i++) {
				// 부모를 찾아
				int now1 = q1.poll();
				int p1 = arr1[now1]; // 부모
				
				if (!visit1[p1]) {
					visit1[p1] = true;
					q1.add(p1);
				}
				
				// 부모의 자식들 양쪽 다있는지 확인
				int left1 = t1[p1][0];
				int right1 = t1[p1][1];
				
				int now2 = q2.poll();
				int p2 = arr2[now2];
				
				if (!visit2[p2]) {
					visit2[p2] = true;
					q2.add(p2);
				}
				
				int left2 = t2[p2][0];
				int right2 = t2[p2][1];
				
				if (left1 != -1) {
					if (!visit1[left1]) {
						visit1[left1] = true;
						q1.add(left1);
					}
					
				}
				if(left2 != -1) {
					if (!visit2[left2]) {
						visit2[left2] = true;
						q2.add(left2);
					}
				}
				
				
				if (right1 != -1) {
					if (!visit1[right1]) {
						visit1[right1] = true;
						q1.add(right1);
					}
					
				}
				if(right2 != -1) {
					if (!visit2[right2]) {
						visit2[right2] = true;
						q2.add(right2);
					}
				}
			}

		}
		
		ans++;
	}

	static void parent(int[][] t1, int[][] t2) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		while (!q.isEmpty()) {
			int num = q.poll();

			int left = t1[num][0];
			int right = t1[num][1];

			if (left != -1) {
				arr1[left] = num;
				q.add(left);
			}

			if (right != -1) {
				arr1[right] = num;
				q.add(right);
				
				// 오른쪽에 모든 -1 -1을 구해보자
				if(t1[right][0] == -1 && t1[right][1] == -1) {
					end_list.add(right);
				}
			}
			
		}

		q.add(0);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();

				int left = t2[num][0];
				int right = t2[num][1];

				if (left != -1) {
					arr2[left] = num;
					q.add(left);
				}

				if (right != -1) {
					arr2[right] = num;
					q.add(right);
				}
			}
		}
	}
	
	static void end(int now, int[][] t2) {
		if(t2[now][1] == -1) {
			end = now;
			return;
		}
		
		end(t2[now][1], t2);
	}
}
