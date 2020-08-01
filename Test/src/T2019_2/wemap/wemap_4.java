package T2019_2.wemap;
import java.util.Arrays;
import java.util.Scanner;

public class wemap_4 {
	static int[] arr;
	static int[][] map;
	static int max, n, result;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1]; // 0안씀
		visit = new boolean[n + 1]; // 0안씀
		map = new int[n + 1][n + 1]; // 0,0 안씀
		max = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		visit[1] = true; //출발점 갔던곳임
		for (int i = 1; i <= n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		dfs(1, arr[1]);
		System.out.println(result + " " +max);
	}

	static void dfs(int now, int sum) {
		System.out.println(Arrays.toString(visit));
		for (int i = 1; i <= n; i++) {
			if(!visit[i] && map[now][i] == 1) {
				visit[i] = true; //간곳은 갔다고 표시
				dfs(i, sum+arr[i]); // i로가고 i인원수 더하기
				visit[i] = false;
			}
		}
		System.out.println(sum);
		if(max < sum) {
			result = now;
			max = sum;
		}else if(max == sum){
			result = Math.max(result, now);
		}
	}
}
