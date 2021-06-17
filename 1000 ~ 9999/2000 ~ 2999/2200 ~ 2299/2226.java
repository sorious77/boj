import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[1001];

		for (int i = 0; i <= 1000; i++) {
			dp[i] = new BigInteger("0");
		}

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1].multiply(new BigInteger("2"));
			if(i % 2 == 0) {
				dp[i] = dp[i].add(new BigInteger("1"));
			} else {
				dp[i] = dp[i].add(new BigInteger("-1"));
			}
		}
		
		System.out.println(dp[N]);
	}
}
