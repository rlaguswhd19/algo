package baekjoon.BinerySerch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String s;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			map.put(s, 1);
		}

		for (int i = 0; i < m; i++) {
			s = br.readLine();
			if (map.containsKey(s)) {
				map.put(s, 2);
			} else {
				map.put(s, 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		int size = 0;
		for (String key : list) {
			int cnt = map.get(key);
			if (cnt == 2) {
				sb.append(key + "\n");
				size++;
			}
		}
		sb.insert(0, size+"\n");
		
		System.out.println(sb.toString());
	}
}
