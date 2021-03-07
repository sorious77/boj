import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int cost;
	static Vertex[] graph;
	static int[] parent;

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

	static class Vertex implements Comparable<Vertex> {
		int s, e, w;

		Vertex() {
		}

		Vertex(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return w - o.w;
		}
	}

	static int findP(int x) {
		if(parent[x] == x) {
			return x;
		}
		else {
			return parent[x] = findP(parent[x]);
		}
	}
	
	static void union(int x, int y) {
		x = parent[x];
		y = parent[y];
		
		parent[y] = x;
	}
	
	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();

		N = sc.nextInt();
		M = sc.nextInt();

		parent = new int[N + 1];
		graph = new Vertex[M];

		for (int i = 0; i < M; i++) {
			int s, e, w;
			s = sc.nextInt();
			e = sc.nextInt();
			w = sc.nextInt();

			graph[i] = new Vertex(s, e, w);
		}

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Arrays.sort(graph);

		for (int i = 0; i < M; i++) {
			Vertex temp = graph[i];
			
			if(temp.s != temp.e) {
				if(findP(temp.s) != findP(temp.e)) {
					union(temp.s, temp.e);
					cost += temp.w;
				}
			}
		}
		System.out.println(cost);
	}
}
