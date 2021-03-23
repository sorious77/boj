import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] RGB;
	static int[][] dp;

	static class Reader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();

		N = sc.nextInt();
		RGB = new int[3];
		dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], 9999999);
			for (int j = 0; j < 3; j++) {
				RGB[j] = sc.nextInt();
			}

			for (int j = 0; j < 3; j++) {
				for(int k=0;k<3;k++) {
					if(j != k) {
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + RGB[j]);
					}
				}
			}
		}
		
		int answer = 9999999;
		
		for(int i=0;i<3;i++) {
			answer = answer > dp[N][i] ? dp[N][i] : answer;
		}
		System.out.println(answer);
	}
}
