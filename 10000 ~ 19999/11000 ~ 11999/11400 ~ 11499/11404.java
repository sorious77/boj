import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;

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

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new int[N + 1][N + 1];

		int MAX_VAL = 10000001;

		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], MAX_VAL);
			graph[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			int s, e, w;
			s = sc.nextInt();
			e = sc.nextInt();
			w = sc.nextInt();

			graph[s][e] = Math.min(graph[s][e], w);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(graph[i][j] == MAX_VAL)
					graph[i][j] = 0;
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}