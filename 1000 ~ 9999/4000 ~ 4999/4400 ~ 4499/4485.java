import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int test_case = 1;
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		while (true) {
			int size = Integer.parseInt(br.readLine());

			if (size == 0)
				break;

			int answer = 0;

			int[][] map = new int[size][size];
			int[][] dist = new int[size][size];

			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}

			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(0, 0));

			dist[0][0] = map[0][0];

			while (!q.isEmpty()) {
				Point cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dir[i][0];
					int nextY = cur.y + dir[i][1];

					if (0 <= nextX && nextX < size && 0 <= nextY && nextY < size
							&& (dist[nextY][nextX] > dist[cur.y][cur.x] + map[nextY][nextX])) {
						dist[nextY][nextX] = dist[cur.y][cur.x] + map[nextY][nextX];
						q.offer(new Point(nextX, nextY));
					}
				}
			}

			answer = dist[size - 1][size - 1];
			sb.append(String.format("Problem %d: %d\n", test_case, answer));
			test_case++;
		}

		System.out.println(sb.toString());
	}
}