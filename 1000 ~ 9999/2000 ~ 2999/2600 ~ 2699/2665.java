import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		int[][] count = new int[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(count[i], 9999999);
		}

		count[0][0] = 0;
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dir[i][0];
				int nextY = cur.y + dir[i][1];

				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
					if (map[nextY][nextX] == '0') {
						if (count[cur.y][cur.x] + 1 < count[nextY][nextX]) {
							count[nextY][nextX] = count[cur.y][cur.x] + 1;
							q.offer(new Point(nextX, nextY));
						}
					} else {
						if (count[cur.y][cur.x] < count[nextY][nextX]) {
							count[nextY][nextX] = count[cur.y][cur.x];
							q.offer(new Point(nextX, nextY));
						}
					}
				}
			}
		}

		System.out.println(count[N - 1][N - 1]);
	}
}
