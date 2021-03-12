import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 1];

		int answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (i != 0) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}

			if (i + T[i] <= N) {
				dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);
			}
			
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(Math.max(answer, dp[N]));
	}
}
