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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		int[][] dist = new int[H][W];

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < H; i++) {
			String input = br.readLine();

			for (int j = 0; j < W; j++) {
				map[i][j] = input.charAt(j) - '0';
			}

			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));

		dist[0][0] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			int nextX = 0, nextY = 0;

			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dir[i][0];
				nextY = cur.y + dir[i][1];

				if (0 <= nextX && nextX < W && 0 <= nextY && nextY < H) {
					if (map[nextY][nextX] == 1) {
						if (dist[cur.y][cur.x] + 1 < dist[nextY][nextX]) {
							dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
							q.offer(new Point(nextX, nextY));
						}
					} else {
						if (dist[cur.y][cur.x] < dist[nextY][nextX]) {
							dist[nextY][nextX] = dist[cur.y][cur.x];
							q.offer(new Point(nextX, nextY));
						}
					}
				}
			}
		}

		System.out.println(dist[H - 1][W - 1]);
	}
}
