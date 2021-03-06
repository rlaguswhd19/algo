package baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main15782 {
	static int[] arr;
	static ArrayList<Integer> result;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int k = sc.nextInt();
			if(k == 0) {
				break;
			}
			result = new ArrayList<Integer>();
			arr = new int[k];
			visit = new boolean[k];
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			per();
			System.out.println();
		}
	}
	static void per() {
		if(result.size() == 6) {
			for (int i = 0; i < result.size(); i++) {
				if(i == result.size()-1) {
					System.out.print(result.get(i));
				}else {
					System.out.print(result.get(i)+" ");
				}
			}System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(result.size() == 0) {
				if(!visit[i]) {
					visit[i] = true;
					result.add(arr[i]);
					per();
					result.remove(result.size()-1);
					visit[i] = false;
				}
			}else {
				if(!visit[i] && result.get(result.size()-1) < arr[i]) {
					visit[i] = true;
					result.add(arr[i]);
					per();
					result.remove(result.size()-1);
					visit[i] = false;
				}
			}
		}
	}
}
