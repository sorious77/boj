import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
		StringBuilder sb = new StringBuilder();

		int test_case = sc.nextInt();

		long[][] combi = new long[31][31];

		for (int i = 1; i <= 30; i++) {
			combi[i][0] = 1;
			combi[i][i] = 1;

			for (int j = 1; j < i; j++) {
				combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
			}
		}

		for (int t = 1; t <= test_case; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			sb.append(combi[M][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}