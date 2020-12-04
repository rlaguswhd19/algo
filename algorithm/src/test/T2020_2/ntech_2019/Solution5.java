package test.T2020_2.ntech_2019;

public class Solution5 {
	public static void main(String[] args) {
		int n = 3;
		int m = 4;
		int[] x_axis = { 2 };
		int[] y_axis = { 1, 2 };
		solution(n, m, x_axis, y_axis);
	}

	static void solution(int n, int m, int[] x_axis, int[] y_axis) {
		int xmax = 0;
		int ymax = 0;

		for (int i = 0; i < x_axis.length - 1; i++) {
			xmax = Math.max(xmax, x_axis[i + 1] - x_axis[i]);
		}
		xmax = Math.max(xmax, x_axis[0]);
		xmax = Math.max(n - x_axis[x_axis.length - 1], xmax);

		for (int i = 0; i < y_axis.length - 1; i++) {
			ymax = Math.max(ymax, y_axis[i + 1] - y_axis[i]);
		}
		ymax = Math.max(ymax, y_axis[0]);
		ymax = Math.max(ymax, m - y_axis[y_axis.length - 1]);
		
		System.out.println(ymax * xmax);
	}
}
