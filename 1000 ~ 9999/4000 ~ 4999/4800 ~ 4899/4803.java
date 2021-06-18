import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int[] rank;
	static int[] edge;

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			edge[x]++;
			return;
		}

		if (rank[x] < rank[y]) {
			p[x] = y;
			rank[y] += rank[x];
			edge[y] += edge[x] + 1;
		} else {
			p[y] = x;
			rank[x] += rank[y];
			edge[x] += edge[y] + 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();

		int test_case = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			p = new int[N + 1];
			rank = new int[N + 1];
			edge = new int[N + 1];

			Arrays.fill(rank, 1);

			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				union(x, y);
			}

			int count = 0;

			/*
			 * System.out.println("----------------------");
			 * System.out.println(Arrays.toString(p));
			 * System.out.println(Arrays.toString(rank));
			 * System.out.println(Arrays.toString(edge));
			 */

			for (int i = 1; i <= N; i++) {
				if (find(i) == i) {
					if (rank[i] - 1 == edge[i])
						count++;
				}
			}

			if (count == 0) {
				sb.append(String.format("Case %d: No trees.\n", test_case));
			} else if (count == 1) {
				sb.append(String.format("Case %d: There is one tree.\n", test_case));
			} else {
				sb.append(String.format("Case %d: A forest of %d trees.\n", test_case, count));
			}

			test_case++;
		}

		System.out.println(sb.toString());
	}
}
