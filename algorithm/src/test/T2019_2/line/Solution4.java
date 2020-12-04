package test.T2019_2.line;

import java.util.Iterator;
import java.util.TreeMap;

public class Solution4 {
	static String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
	static String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
			{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
			{ "3", "WITHDRAW", "ACCOUNT2", "30" } };
	static boolean[] idlist = new boolean[100000];

	public static void main(String[] args) {
		solution();
	}

	static String[][] solution() {
		TreeMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		for (int i = 0; i < transactions.length; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			if (idlist[id]) {
				continue;
			}

			idlist[id] = true;

			String key = transactions[i][2];
			int money = Integer.parseInt(transactions[i][3]);

			switch (transactions[i][1]) {
			case "SAVE":
				if (map.containsKey(key)) {
					map.put(key, money + map.get(key));
				} else {
					map.put(key, money);
				}
				break;
			case "WITHDRAW":
				map.put(key, map.get(key) - money);
				break;
			}
		}
		
		Iterator<String> it = map.keySet().iterator();
		String[][] answer = new String[map.size()][2];
		
		int index = 0;
		while(it.hasNext()) {
			String key = it.next();
			int money = map.get(key);
			
			answer[index][0] = key;
			answer[index][1] = ""+map.get(key);
			index++;
		}
		
		return answer;
	}
}
