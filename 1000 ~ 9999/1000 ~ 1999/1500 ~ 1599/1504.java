import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static int N, E;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		N = nextInt();
		E = nextInt();

		graph = new int[N][N];

		int MAX_DIST = 999999;

		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], MAX_DIST);
			graph[i][i] = 0;
		}

		for (int i = 0; i < E; i++) {
			int e1 = nextInt() - 1;
			int e2 = nextInt() - 1;
			int w = nextInt();

			graph[e1][e2] = w;
			graph[e2][e1] = w;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		int v1 = nextInt() - 1;
		int v2 = nextInt() - 1;

		int path1 = graph[0][v1] + graph[v1][v2] + graph[v2][N - 1];
		int path2 = graph[0][v2] + graph[v2][v1] + graph[v1][N - 1];

		int answer = Math.min(path1, path2);

		if (answer >= MAX_DIST)
			answer = -1;

		System.out.println(answer);
	}
}
