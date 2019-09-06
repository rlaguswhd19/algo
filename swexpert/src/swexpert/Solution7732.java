package swexpert;

import java.util.Scanner;

public class Solution7732 {
	static int[] arr1;
	static int[] arr2;
	static int[] result;
	static String[] Sresult;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			arr1 = new int[3];
			arr2 = new int[3];
			result = new int[3];

			String s1 = sc.nextLine();
			String s2 = sc.nextLine();

			changeInt(s1, arr1);
			changeInt(s2, arr2);
			System.out.println("#" + tc + " " + cal(arr1, arr2));

		}
	}

	static void changeInt(String s, int[] arr) {
		int H = Integer.parseInt(s.substring(0, 2));
		int M = Integer.parseInt(s.substring(3, 5));
		int S = Integer.parseInt(s.substring(6, 8));
		arr[0] = H;
		arr[1] = M;
		arr[2] = S;
	}

	// ó�� �ð� arr1 ��ӽð� arr2
	static String cal(int[] arr1, int[] arr2) {
		String s = "";
		int time = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i] <= arr2[i]) {
				result[i] = arr2[i] - arr1[i];
			} else {
//				System.out.println(i);
				int index = 0; 
				while (true) {
					if (i - index < 0) {
						break;
					}

					if (i - index == 0) {
						time = 24;
					} else {
						time = 60;
					}
					if (index == 0) {
						result[i - index] = time - arr1[i - index] + arr2[i - index];
					} else {
						if (result[i - index] == 0) {
							result[i - index] = time - 1;
						} else {
							result[i - index]--;
							break;
						}
					}
					index++;
				}

			}
//			System.out.println(Arrays.toString(result));
		}
		Sresult = new String[3];
		for (int i = 0; i < result.length; i++) {
			if (result[i] < 10) {
				Sresult[i] = "0" + result[i];
			} else {
				Sresult[i] = "" + result[i];
			}
		}
		s = Sresult[0] + ":" + Sresult[1] + ":" + Sresult[2];
		return s;
	}
}
