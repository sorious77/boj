import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[2000];
		Arrays.fill(dp, 9999999);
		
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());

			for (int j = people; j < 2000; j++) {
				dp[j] = Math.min(dp[j], dp[j - people] + cost);
			}
		}
		int answer = 9999999;

		for (int i = C; i < 2000; i++) {
			answer = Math.min(answer, dp[i]);

		}
		System.out.println(answer);
	}
}
