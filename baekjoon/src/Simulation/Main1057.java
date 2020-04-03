package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1057 {
	static int n, K, I;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		I = Integer.parseInt(st.nextToken());
		
		dfs();
	}

	static void dfs() {
		int cnt = 0;
		while(true) {
			if(I == K) {
				System.out.println(cnt);
				break;
			}
			
			I = (I+1)/2;
			K = (K+1)/2;
			cnt++;
		}
	}
}
