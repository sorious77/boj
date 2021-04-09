import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dist;
	static int min, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int MAX_DIST = 200001;

		dist = new int[MAX_DIST];

		Arrays.fill(dist, 999999);
		min = 999999;
		count = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == M) {
				if (min == dist[cur]) {
					count++;
				} else if (dist[cur] < min) {
					min = dist[cur];
					count = 1;
				}
				
				continue;
			}
			
			if(dist[cur] > dist[M])
				continue;

			if (cur - 1 >= 0 && dist[cur - 1] >= dist[cur] + 1) {
				q.offer(cur - 1);
				dist[cur - 1] = dist[cur] + 1;
			}

			if (cur + 1 < MAX_DIST && dist[cur + 1] >= dist[cur] + 1) {
				q.offer(cur + 1);
				dist[cur + 1] = dist[cur] + 1;
			}

			if (cur * 2 < MAX_DIST && dist[cur * 2] >= dist[cur] + 1) {
				q.offer(cur * 2);
				dist[cur * 2] = dist[cur] + 1;
			}
			
		}
		
		System.out.println(min);
		System.out.println(count);
	}
}
