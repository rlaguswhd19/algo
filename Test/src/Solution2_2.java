

public class Solution2_2 {
	static int n = 6;
	static String[] plates = {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"};
	static int[] odo = {20,16,18,20,24,19};
	static int k = 8;
	static int[] drives = {3,7,5,8,6,5,10,2};
	public static void main(String[] args) {
		int cnt = 0;
		while(cnt < k+1) {
			int index = 0;
			int min = Integer.MAX_VALUE;
			String name = "";
			for (int i = 0; i < odo.length; i++) {
				if(odo[i] < min) {
					min = odo[i];
					index = i;
					name = plates[i];
				}else if(min == odo[i]) {
					int com = name.compareTo(plates[i]);
					if(com == -1) {
						min = odo[i];
						index = i;
						name = plates[i];
					}
				}
			}
			if(cnt == k) {
				System.out.println(name);
				break;
			}
			odo[index] += drives[cnt];
			cnt++;
		}
	}
}
