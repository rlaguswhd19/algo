package swexpert.expert;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer> list;
	static int[] array;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= a; tc++) {
			String s = sc.nextLine();
			array = new int[s.length()];
			list = new ArrayList<>();

			for (int i = 0; i < s.length(); i++) {
				array[i] = s.charAt(i);
			}

			for (int j = 0; j < array.length; j++) {
				if (list.size() == 0) {
					list.add(array[j]);
				} else {
					n = 0;
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != array[j]) {
							n++;
						} else {
							break;
						}
					}
					if(n == list.size()) {
						list.add(array[j]);
					}
				}
			}
			System.out.println("#" + tc + " " + list.size());
		}
	}
}