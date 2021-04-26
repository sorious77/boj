import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = " ".concat(br.readLine());
		String s2 = " ".concat(br.readLine());

		int len1 = s1.length();
		int len2 = s2.length();

		int[][] dp = new int[len2][len1];
		int MAX_VAL = -1;

		for (int i = 1; i < len2; i++) {
			char c = s2.charAt(i);

			for (int j = 1; j < len1; j++) {
				if (c == s1.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

				MAX_VAL = Math.max(dp[i][j], MAX_VAL);
			}
		}

		System.out.println(MAX_VAL);
	}
}
