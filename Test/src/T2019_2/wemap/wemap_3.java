package T2019_2.wemap;
import java.util.*;

public class wemap_3 {
	static ArrayList<Integer> arr;
	static int cnt = 0;
	static int kg;
	static boolean isOk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		kg = sc.nextInt();
		int items = sc.nextInt();
		arr = new ArrayList<>();
		for (int i = 0; i < items; i++) {
			int n = sc.nextInt();
			if(n > kg) {
				isOk = true;
				break;
			}
			arr.add(n);
		}
		if(!isOk) {
			Collections.sort(arr);
			dfs();
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}

	static void dfs() {
		if (arr.size() == 0) {
			return;
		}
		int sum = 0;
		ArrayList<Integer> rm = new ArrayList<>();
		for (int i = arr.size() - 1; i >= 0; i--) {
			if (sum + arr.get(i) <= kg) {
				rm.add(i);
				sum += arr.get(i);
			}
		}
		for (int i = 0; i < rm.size(); i++) {
			int num = rm.get(i);
			arr.remove(num);
		}
		cnt++;
		dfs();
	}
}
