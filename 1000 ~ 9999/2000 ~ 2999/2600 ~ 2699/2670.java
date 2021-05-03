import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		double[] num = new double[N];
		double[] dp = new double[N];
		double answer = -1;

		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());

			answer = Math.max(answer, num[i]);
		}

		for (int i = 1; i < N; i++) {
			dp[i] = num[i];
			for (int j = i + 1; j < N; j++) {
				dp[i] *= num[j];
				answer = Math.max(answer, dp[i]);
			}
		}

		System.out.printf("%.3f", answer);
	}
}
