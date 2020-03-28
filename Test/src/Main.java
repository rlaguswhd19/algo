import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static String ans;
	static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ans = "";
		list = new int[k];
		String s = br.readLine();
		
		for (int i = 0; i <= n-k; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			boolean isOk = false;
			
			for (int j = 0; j < k; j++) {
				// 자릿수
				int num = s.charAt(i+j)-'0';
				
				// 숫자를 계속 넣는다.
				if(isOk) {
					temp.add(num);
					continue;
				}
				// 
				if(list[j] == num) {
					// 같으면 그냥 넣는다.
					temp.add(num);
				}else if(list[j] < num){
					// 큰게 나오면 이제부터 그냥 숫자 넣기
					isOk = true;
					temp.add(num);
					// 중간에 작은게 먼저 나오면 끝이야
				}else {
					break;
				}
			}
			System.out.println(temp);
			System.out.println(Arrays.toString(list));
			if(temp.size() == k) {
				for (int j = 0; j < temp.size(); j++) {
					int num = temp.get(j);
					list[j] = num;
				}
			}
		}
		
		boolean zero = false;
		for (int i = 0; i < list.length; i++) {
			if(list[i] != 0) {
				zero = true;
			}
			
			if(zero) {
				System.out.print(list[i]);
			}
		}
	}
}
