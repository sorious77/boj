import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char nextChar(char c) {
		if (c == 'B')
			return 'O';
		else if (c == 'O')
			return 'J';

		return 'B';
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		char[] street = new char[N];

		street = br.readLine().toCharArray();

		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		char cur = 'B';
		char next = nextChar(cur);

		for (int i = 0; i < N - 1; i++) {
			cur = street[i];
			next = nextChar(cur);

			for (int j = i + 1; j < N; j++) {
				if (street[j] == next) {
					int diff = j - i;
					dp[j] = Math.min(dp[j], dp[i] + diff * diff);
				}
			}
		}

		if (dp[N - 1] == 987654321)
			System.out.println(-1);
		else {
			System.out.println(dp[N - 1]);
		}
	}
}