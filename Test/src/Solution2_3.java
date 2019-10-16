import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution2_3 {
	static int n = 6;
	static String[] plates = {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"};
	static int[] odo = {20,16,18,20,24,19};
	static int k = 8;
	static int[] drives = {3,7,5,8,6,5,10,2};
	static ArrayList<car> arr;
	static int cnt = 0;
	public static void main(String[] args) {
		arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new car(plates[i], odo[i]));
		}
		sort(arr);
		System.out.println(arr);
		start();
	}
	static void start() {
		arr.get(0).o += drives[cnt];
		int num = arr.get(0).o;
		for (int i = 1; i < arr.size(); i++) {
			if(num < arr.get(i).o) {
				car c = arr.get(0);
				arr.get(0).o = arr.get(i).o;
				arr.get(0).id = arr.get(i).id;
				arr.get(i).id = c.id;
				arr.get(i).o = c.o;
				break;
			}else if(num == arr.get(i).o) {
				car c = arr.get(0);
				
			}
		}
		cnt++;
		start();
	}
	static void sort2(ArrayList<car> arr) {
		for (int i = 0; i < arr.size(); i++) {
			
		}
	}
	static void sort(ArrayList<car> arr){
		Collections.sort(arr, new Comparator<car>() {
			@Override
			public int compare(car o1, car o2) {
				if(o1.o < o2.o) {
					return -1;
				}else if(o1.o > o2.o){
					return 1;
				}else {
					return o1.id.compareTo(o2.id);
				}
			}
		});
	}
	static class car{
		String id;
		int o;
		public car(String id, int o) {
			super();
			this.id = id;
			this.o = o;
		}
		@Override
		public String toString() {
			return "car [id=" + id + ", o=" + o + "]";
		}
	}
}
