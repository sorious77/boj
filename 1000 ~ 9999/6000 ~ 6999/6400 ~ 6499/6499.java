import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point> {
		int s, e, w;

		Point() {
		}

		Point(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
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
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(M == 0 && N == 0)
				break;

			int sum = 0;

			p = new int[M];

			for (int i = 0; i < M; i++) {
				p[i] = i;
			}

			PriorityQueue<Point> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				pq.offer(new Point(s, e, w));
				sum += w;
			}

			int reduce = 0;
			while (!pq.isEmpty()) {
				Point cur = pq.poll();

				int findS = find(cur.s);
				int findE = find(cur.e);

				if (findS != findE) {
					union(cur.s, cur.e);
					reduce += cur.w;
				}
			}

			sb.append(sum - reduce).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
