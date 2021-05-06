import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		int[] dp = new int[100001];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coin);

		for (int i = 0; i < N; i++) {
			dp[coin[i]]++;
			for (int j = coin[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		System.out.println(dp[K]);
	}
}
