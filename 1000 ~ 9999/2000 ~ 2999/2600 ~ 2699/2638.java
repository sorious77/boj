import java.io.BufferedReader;
import java.io.InputStreamReader;
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

	static int N, M;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		Queue<Point> cheese = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					cheese.offer(new Point(j, i));
				}

				if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					q.offer(new Point(j, i));
					map[i][j] = -1;
				}
			}
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];

				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
					if (map[nextY][nextX] == 0) {
						map[nextY][nextX] = -1;
						q.offer(new Point(nextX, nextY));
					}
				}
			}
		}

		int answer = 0;
		while (true) {
			if (cheese.isEmpty())
				break;

			int size = cheese.size();
			for (int i = 0; i < size; i++) {
				Point cur = cheese.poll();

				int count = 0;

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dir[j][0];
					int nextY = cur.y + dir[j][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && map[nextY][nextX] == -1) {
						count++;
					}
				}

				if (count >= 2) {
					q.offer(cur);
				} else {
					cheese.offer(cur);
				}
			}

			while (!q.isEmpty()) {
				Point cur = q.poll();

				map[cur.y][cur.x] = -1;
				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dir[i][0];
					int nextY = cur.y + dir[i][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
						if (map[nextY][nextX] == 0) {
							map[nextY][nextX] = -1;
							q.offer(new Point(nextX, nextY));
						}
					}
				}
			}

			answer++;
		}

		System.out.println(answer);
	}
}
