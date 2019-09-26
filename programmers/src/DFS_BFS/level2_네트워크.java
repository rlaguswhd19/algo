package DFS_BFS;

public class level2_네트워크{
	static int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
	static int n = 3;
	static int ans = 0;
	static boolean[] visit;
	public static void main(String[] args) {
		visit = new boolean[computers.length];
		for (int i = 0; i < computers.length; i++) {
			if(!visit[i]) {
				dfs(computers[i].length, i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int length, int i) {
		visit[i] = true;
		for (int j = 0; j < length; j++) {
			if(!visit[j]) {
				if(i != j && computers[i][j] == 1) {
					dfs(length, j);
				}
			}
		}
	}
}
