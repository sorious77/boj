import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y, d;

		Point() {
		}

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int findDir(int d) {
		if (d == 1)
			return 1;
		else if (d == 2)
			return 3;
		else if (d == 3)
			return 2;
		else
			return 0;
	}

	static int findRotate(int cur, int next) {
		int diff = Math.abs(cur - next);
		if (diff <= 2)
			return diff;

		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

		int[][] map = new int[N][M];
		int[][][] dist = new int[N][M][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}

		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken()) - 1;
		int x = Integer.parseInt(st.nextToken()) - 1;
		int d = findDir(Integer.parseInt(st.nextToken()));

		Queue<Point> robot = new LinkedList<>();
		robot.offer(new Point(x, y, d));
		dist[y][x][d] = 0;

		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken()) - 1;
		x = Integer.parseInt(st.nextToken()) - 1;
		d = findDir(Integer.parseInt(st.nextToken()));

		Point finish = new Point(x, y, d);

		int answer = Integer.MAX_VALUE;

		while (!robot.isEmpty()) {
			Point cur = robot.poll();

			for (int i = 0; i < 4; i++) {
				// 다음칸으로 가기 위해서 회전하는 횟수
				int rotate = findRotate(cur.d, i);

				for (int j = 1; j <= 3; j++) {
					int nextX = cur.x + dir[i][0] * j;
					int nextY = cur.y + dir[i][1] * j;

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
						// 벽이라서 더 이상 가지 못하는 경우
						if (map[nextY][nextX] == 1)
							break;
						else if (dist[nextY][nextX][i] > dist[cur.y][cur.x][cur.d] + rotate + 1) {
							// 다음칸의 i방향으로 가는 최소 path를 찾음
							robot.offer(new Point(nextX, nextY, i));
							dist[nextY][nextX][i] = dist[cur.y][cur.x][cur.d] + rotate + 1;
						}

					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (dist[finish.y][finish.x][i] == Integer.MAX_VALUE)
				continue;
			answer = Math.min(answer, dist[finish.y][finish.x][i] + findRotate(finish.d, i));
		}

		System.out.println(answer);
	}
}
