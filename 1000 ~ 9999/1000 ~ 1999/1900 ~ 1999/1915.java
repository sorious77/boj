import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		int answer = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i - 1 < 0 || j - 1 < 0) {
					dp[i][j] = map[i][j];
				} else {
					if (map[i][j] == 1)
						dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
				}

				answer = Math.max(dp[i][j], answer);
			}
		}

		System.out.println(answer * answer);
	}
}
