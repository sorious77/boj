import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1025 {
	static int N, M;
	static int[][] num;
	static int answer = -1;

	static boolean isSqrt(int n) {
		int sqrt = (int) Math.sqrt(n);
		return sqrt * sqrt == n;
	}

	static void dfs(int x, int y, int dx, int dy, int n) {
		if (isSqrt(n)) {
			answer = Math.max(answer, n);
		}

		if (x + dx < 0 || x + dx >= M || y + dy < 0 || y + dy >= N)
			return;

		dfs(x + dx, y + dy, dx, dy, n * 10 + num[y + dy][x + dx]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < M; j++) {
				num[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = -N; k < N; k++) {
					for (int l = -M; l < M; l++) {
						if (k == 0 && l == 0)
							continue;

						dfs(j, i, l, k, num[i][j]);
					}
				}
			}
		}

		System.out.println(answer);
	}
}