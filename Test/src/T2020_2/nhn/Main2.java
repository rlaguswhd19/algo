package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int day = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] blocks = new int[day][n];
		StringTokenizer st;
		for (int i = 0; i < blocks.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum = 0;

		solution(day, n, blocks);
	}

	static void solution(int day, int n, int[][] blocks) {
		int[] map = new int[n];

		int now = 0;
		while (now < day) {
//			System.out.println(now);

			// ����
			for (int i = 0; i < n; i++) {
				map[i] += blocks[now][i];
			}

			// �ø�Ʈ
			int h1 = map[0]; // ���� ����
			int idx1 = 0; // ���� �ε���

			while (idx1 < n - 1) { // ������ �����ϱ�
//			while (cnt < 2) {
				int h2 = 0; // �ι�° ����
				int idx2 = 0;
				boolean isOk = false;
				for (int i = idx1 + 1; i < n; i++) {
					// �ڱ� �ڽź��� ũ�ų� �������� ������
					if (h1 <= map[i]) {
						// �ø�Ʈ ä���
						for (int j = idx1 + 1; j < i; j++) {
							sum += h1 - map[j]; // ����� �ø�Ʈ ��
							map[j] = h1;
						}

						// ���̶� �ε��� ����
						h1 = map[i];
						idx1 = i;

						// �������� ����
						isOk = true;
						break;

					} else { // h1���� ������ ���߿��� ���� ū�Ÿ� �����ϱ�
						if (h2 < map[i]) {
							h2 = map[i];
							idx2 = i;
						}
					}
				}
				
				if (!isOk) { // ��ã������ �ι�°�� ū �ַ� ä���
					// ���غ��� �ι�°�� ū ��������
					for (int i = idx1 + 1; i < idx2; i++) {
						sum += h2 - map[i]; // ����� �ø�Ʈ ��
						map[i] = h2;
					}

					// ���̶� �ε��� ����
					h1 = h2;
					idx1 = idx2;
				}
			}
			
			now++;
			
//			System.out.println(Arrays.toString(map));
		}
		System.out.println(sum);
	}
}
