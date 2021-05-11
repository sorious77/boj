import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 1000000; i++) {
			dp[i] = (((dp[i - 1] + dp[i - 2]) % 1000000009) + dp[i - 3]) % 1000000009;
		}

		for (int T = 0; T < test_case; T++) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
