import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] item = new int[N + 1];
		int[][] map = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());

			Arrays.fill(map[i], 987654321);
			map[i][i] = 0;
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s][e] = w;
			map[e][s] = w;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}

		int answer = -1;

		for (int i = 1; i <= N; i++) {
			int sum = 0;

			for (int j = 1; j <= N; j++) {
				if (map[i][j] <= M) {
					sum += item[j];
				}
			}
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}