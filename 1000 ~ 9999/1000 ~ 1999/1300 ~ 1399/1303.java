import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int white, blue;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static boolean canMove(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && !visit[y][x])
			return true;

		return false;
	}

	public static void main(String[] args) throws Exception {
		N = nextInt();
		M = nextInt();

		map = new char[M][N];
		visit = new boolean[M][N];
		white = 0;
		blue = 0;

		for (int i = 0; i < M; i++) {
			map[i] = next().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					Queue<Point> q = new LinkedList<>();
					int count = 1;
					q.offer(new Point(j, i));
					visit[i][j] = true;

					while (!q.isEmpty()) {
						Point cur = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = cur.x + dir[k][0];
							int nextY = cur.y + dir[k][1];

							if (canMove(nextX, nextY) && map[nextY][nextX] == map[i][j]) {
								q.offer(new Point(nextX, nextY));
								visit[nextY][nextX] = true;
								count++;
							}
						}
					}
					
					if(map[i][j] == 'W') {
						white += count * count;
					}
					else
						blue += count * count;
				}
			}
		}
		
		System.out.println(white + " " + blue);
	}
}