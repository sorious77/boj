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
		StringTokenizer st = new StringTokenizer("");

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int N = Integer.parseInt(br.readLine());

		int[][] input = new int[N][N];
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] == 1 && map[i][j] == 0) {
					map[i][j] = count;

					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(j, i));

					while (!q.isEmpty()) {
						Point cur = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = cur.x + dir[k][0];
							int nextY = cur.y + dir[k][1];

							if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
								if (input[nextY][nextX] == 1 && map[nextY][nextX] == 0) {
									map[nextY][nextX] = count;
									q.offer(new Point(nextX, nextY));
								}
							}
						}
					}

					count++;
				}
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					Queue<Point> q = new LinkedList<>();
					int[][] dist = new int[N][N];

					for (int k = 0; k < 4; k++) {
						int nextX = j + dir[k][0];
						int nextY = i + dir[k][1];

						if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && map[nextY][nextX] == 0) {
							q.offer(new Point(nextX, nextY));
							dist[nextY][nextX] = 1;
						}
					}

					while (!q.isEmpty()) {
						Point cur = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = cur.x + dir[k][0];
							int nextY = cur.y + dir[k][1];

							if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
								if (map[nextY][nextX] != map[i][j] && map[nextY][nextX] != 0
										&& dist[nextY][nextX] == 0) {
									answer = Math.min(answer, dist[cur.y][cur.x]);
								} else if (map[nextY][nextX] == 0 && dist[nextY][nextX] == 0) {
									q.offer(new Point(nextX, nextY));
									dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
								}
							}
						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}
