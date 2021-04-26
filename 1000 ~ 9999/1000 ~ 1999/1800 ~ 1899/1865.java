import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(map[i], 987654321);
				map[i][i] = 0;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				map[s][e] = Math.min(map[s][e], w);
				map[e][s] = Math.min(map[e][s], w);
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken()) * -1;

				map[s][e] = Math.min(map[s][e], w);
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			boolean answer = false;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] + map[j][i] < 0) {
						answer = true;
					}
				}
			}

			sb.append(answer ? "YES\n" : "NO\n");
		}

		System.out.println(sb.toString());
	}
}
