package test.T2019_2.wemap;
import java.util.ArrayList;
import java.util.Scanner;

public class wemap_1 {
	static ArrayList<Integer> arr;
	static int n;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new ArrayList<>();
		n = sc.nextInt()-1;
		cnt = 0;
		dfs(0, arr);
		System.out.println("#"+cnt);
	}
	
	static void dfs(int sum, ArrayList<Integer> arr) {
		if(sum >= n) {
			if(sum == n) {
				System.out.println(sum+" " +arr);
				cnt++;
			}
			return;
		}
		arr.add(1);
		dfs(sum+1, arr);
		arr.remove(arr.size()-1);
		arr.add(2);
		dfs(sum+2, arr);
		arr.remove(arr.size()-1);
	}
}
