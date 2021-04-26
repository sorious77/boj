import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		int[][] num = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());

				if (i == 0 && j == 0)
					dp[i][j] = num[0][0];

				if (i != 0) {
					if (j == 0) {
						dp[i][j] = dp[i - 1][j] + num[i][j];
					} else if (j == i) {
						dp[i][j] = dp[i - 1][j - 1] + num[i][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
					}
				}
			}
		}

		int answer = -1;

		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[N - 1][i]);
		}
		
		System.out.println(answer);
	}
}