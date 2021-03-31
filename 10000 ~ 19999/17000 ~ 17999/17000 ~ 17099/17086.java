import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

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
	static int[][] dist;
	static Queue<Point> sharks;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	static boolean canMove(int x, int y) {
		if (x >= 0 && x < M && y >= 0 && y < N && dist[y][x] != 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		N = nextInt();
		M = nextInt();

		map = new int[N][M];
		dist = new int[N][M];
		sharks = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], 9999);
			for (int j = 0; j < M; j++) {
				map[i][j] = nextInt();

				if (map[i][j] == 1) {
					dist[i][j] = 0;
					sharks.offer(new Point(j, i));
				}
			}
		}

		while (!sharks.isEmpty()) {
			Point p = sharks.poll();
			int nextX, nextY;

			for (int i = 0; i < 8; i++) {
				nextX = p.x + dir[i][0];
				nextY = p.y + dir[i][1];

				if (canMove(nextX, nextY)) {
					if (dist[p.y][p.x] + 1 < dist[nextY][nextX]) {
						dist[nextY][nextX] = dist[p.y][p.x] + 1;
						sharks.offer(new Point(nextX, nextY));
					}
				}
			}
		}

		int answer = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = answer > dist[i][j] ? answer : dist[i][j];
			}
		}

		System.out.println(answer);
	}
}