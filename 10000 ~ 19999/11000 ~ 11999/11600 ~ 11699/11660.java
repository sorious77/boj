import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int findSum(int[][] sum, int x1, int y1, int x2, int y2) {
		if (x1 == 1 && y1 == 1) {
			return sum[y2][x2];
		} else if (x1 == 1) {
			return sum[y2][x2] - sum[y1 - 1][x2];
		} else if (y1 == 1) {
			return sum[y2][x2] - sum[y2][x1 - 1];
		}

		return sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] num = new int[N + 1][N + 1];
		int[][] sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());

				if (i == 1 && j == 1) {
					sum[1][1] = num[1][1];
				}

				if (i == 1 && j > 1) {
					sum[i][j] = sum[i][j - 1] + num[i][j];
				}

				if (i > 1 && j == 1) {
					sum[i][j] = sum[i - 1][j] + num[i][j];
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			sb.append(Integer.toString(findSum(sum, x1, y1, x2, y2))).append("\n");
		}

		System.out.println(sb.toString());
	}
}
