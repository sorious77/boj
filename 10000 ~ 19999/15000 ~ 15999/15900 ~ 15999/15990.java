import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		int[][] dp = new int[100001][4];
		int MOD = 1000000009;

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		for (int T = 0; T < test_case; T++) {
			int N = Integer.parseInt(br.readLine());
			
			int answer = (((dp[N][1] + dp[N][2]) % MOD) + dp[N][3]) % MOD;

			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
