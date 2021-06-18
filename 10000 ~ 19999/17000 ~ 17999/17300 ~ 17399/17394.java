import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[2000001];
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= 2000000; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j <= 2000000; j++) {
					prime[i * j] = true;
				}
			}
		}

		for (int t = 0; t < test_case; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int answer = -1;

			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> count = new LinkedList<>();

			boolean[] visit = new boolean[2000001];
			q.offer(N);
			count.offer(0);
			visit[N] = true;

			boolean isPrime = false;
			for (int i = A; i <= B; i++) {
				if (!prime[i]) {
					isPrime = true;
					break;
				}
			}

			if (!isPrime) {
				sb.append("-1\n");
				continue;
			}

			while (!q.isEmpty()) {
				int cur = q.poll();
				int curCount = count.poll();

				if (A <= cur && cur <= B && !prime[cur]) {
					answer = curCount;
					break;
				}

				if (!visit[cur / 2]) {
					visit[cur / 2] = true;
					q.offer(cur / 2);
					count.offer(curCount + 1);
				}

				if (!visit[cur / 3]) {
					visit[cur / 3] = true;
					q.offer(cur / 3);
					count.offer(curCount + 1);
				}

				if (!visit[cur + 1]) {
					visit[cur + 1] = true;
					q.offer(cur + 1);
					count.offer(curCount + 1);
				}

				if (cur >= 1 && !visit[cur - 1]) {
					visit[cur - 1] = true;
					q.offer(cur - 1);
					count.offer(curCount + 1);
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}