import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int s, e, w;

		Edge() {
		}

		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}

	static int[] p;

	static int find(int x) {
		if (p[x] == x)
			return x;

		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		p[y] = x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int answer = 0;

		p = new int[V + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i <= V; i++) {
			p[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(x, y, w));
			pq.offer(new Edge(y, x, w));
		}

		while (!pq.isEmpty()) {
			Edge temp = pq.poll();

			int x = temp.s;
			int y = temp.e;

			if (find(x) != find(y)) {
				union(x, y);
				answer += temp.w;
			}
		}

		System.out.println(answer);
	}
}
