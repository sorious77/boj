import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[3];
		int[][] max = new int[2][3];
		int[][] min = new int[2][3];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			max[0][i] = num[i];
			min[0][i] = num[i];
		}

		Arrays.fill(min[1], 987654321);

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = (i + 1) % 2;
			int to = i % 2;

			for (int j = 0; j < 3; j++) {
				num[j] = Integer.parseInt(st.nextToken());

				if (j - 1 >= 0) {
					max[to][j] = Math.max(max[to][j], max[from][j - 1] + num[j]);
					min[to][j] = Math.min(min[to][j], min[from][j - 1] + num[j]);
				}
				if (j + 1 < 3) {
					max[to][j] = Math.max(max[to][j], max[from][j + 1] + num[j]);
					min[to][j] = Math.min(min[to][j], min[from][j + 1] + num[j]);
				}

				max[to][j] = Math.max(max[to][j], max[from][j] + num[j]);
				min[to][j] = Math.min(min[to][j], min[from][j] + num[j]);

			}
			
			Arrays.fill(min[from], 987654321);
		}

		int row = (N + 1) % 2;
		int maxAns = -1;
		int minAns = 987654321;

		for (int i = 0; i < 3; i++) {
			maxAns = Math.max(maxAns, max[row][i]);
			minAns = Math.min(minAns, min[row][i]);
		}

		System.out.println(maxAns + " " + minAns);
	}
}
