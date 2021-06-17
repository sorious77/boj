import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Bridge implements Comparable<Bridge> {
		int s, e, w;

		Bridge() {
		}

		Bridge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(o.w, this.w);
		}
	}

	static int[] p;
	static int[] rank;

	static int find(int x) {
		if (p[x] == x)
			return x;

		return p[x] = find(p[x]);
	}

	static void union(int x, int y, int w) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return;

		// System.out.println("union : " + x + " " + y);

		x = px;
		y = py;

		if (rank[x] < rank[y]) {
			p[x] = y;
		} else {
			p[y] = x;

			if (rank[x] == rank[y])
				rank[x]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Bridge> pq = new PriorityQueue<>();

		p = new int[N + 1];
		rank = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			p[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.offer(new Bridge(s, e, w));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		// union-find 알고리즘 수행
		while (!pq.isEmpty()) {
			Bridge cur = pq.poll();
			union(cur.s, cur.e, cur.w);

			if (find(s) == find(e)) {
				System.out.println(cur.w);
				break;
			}
		}
	}
}