import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			dp[i] = num[i];
			for (int j = 1; j <= (i + 1) / 2; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
