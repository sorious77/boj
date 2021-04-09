import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 9999999;

		int MAX_DIST = 200001;

		int[] dist = new int[MAX_DIST];
		Arrays.fill(dist, 9999999);

		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == M && answer > dist[cur]) {
				answer = dist[cur];
			}

			// 최소 시간을 구하는것이기 때문에, 현재까지 구한 최소 시간보다 오래 걸리는 경우 연산 X
			if (dist[cur] >= answer)
				continue;

			int nextDist = dist[cur] + 1;

			if (cur - 1 >= 0 && dist[cur - 1] > nextDist) {
				q.offer(cur - 1);
				dist[cur - 1] = nextDist;
			}

			if (cur + 1 < MAX_DIST && dist[cur + 1] > nextDist) {
				q.offer(cur + 1);
				dist[cur + 1] = nextDist;
			}

			if (cur * 2 < MAX_DIST && dist[cur * 2] > dist[cur]) {
				q.offer(cur * 2);
				dist[cur * 2] = dist[cur];
			}
		}

		System.out.println(answer);
	}
}
