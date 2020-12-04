package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1076 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, OMG> map = new HashMap<String, OMG>();
		map.put("black", new OMG(0, 1));
		map.put("brown", new OMG(1, 10));
		map.put("red", new OMG(2, 100));
		map.put("orange", new OMG(3, 1000));
		map.put("yellow", new OMG(4, 10000));
		map.put("green", new OMG(5, 100000));
		map.put("blue", new OMG(6, 1000000));
		map.put("violet", new OMG(7, 10000000));
		map.put("grey", new OMG(8, 100000000));
		map.put("white", new OMG(9, 1000000000));
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(map.get(br.readLine()).val);
		sb.append(map.get(br.readLine()).val);
		
		long ans = Integer.parseInt(sb.toString());
		
		System.out.println(ans * map.get(br.readLine()).mul);
	}
	
	static class OMG{
		int val, mul;

		public OMG(int val, int mul) {
			super();
			this.val = val;
			this.mul = mul;
		}

		@Override
		public String toString() {
			return "OMG [val=" + val + ", mul=" + mul + "]";
		}
	}
}
