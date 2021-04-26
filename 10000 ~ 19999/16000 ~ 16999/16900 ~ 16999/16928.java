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

		int[] ladder = new int[101];
		int[] snake = new int[101];
		int[] map = new int[101];

		Arrays.fill(map, 987654321);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			ladder[s] = e;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			snake[s] = e;
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		map[1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= 6; i++) {
				int next = cur + i;

				if (next <= 100 && ladder[next] != 0 && map[ladder[next]] > map[cur] + 1) {
					q.offer(ladder[next]);
					map[ladder[next]] = map[cur] + 1;
				} else if (next <= 100 && snake[next] != 0 && map[snake[next]] > map[cur] + 1) {
					q.offer(snake[next]);
					map[snake[next]] = map[cur] + 1;
				} else if (next <= 100 && map[next] > map[cur] + 1 && snake[next] == 0 && ladder[next] == 0) {
					q.offer(next);
					map[next] = map[cur] + 1;
				}
			}
		}

		System.out.println(map[100]);
	}
}
