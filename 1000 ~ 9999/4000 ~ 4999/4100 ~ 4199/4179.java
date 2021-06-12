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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<Point> jihoon = new LinkedList<>();
		Queue<Point> fire = new LinkedList<>();

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'J') {
					jihoon.offer(new Point(j, i));
					visit[i][j] = true;
					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					fire.offer(new Point(j, i));
				}
			}
		}

		int answer = -1;
		int time = 0;

		while (true) {
			int size = jihoon.size();
			time++;
			
			if(size == 0)
				break;

			for (int i = 0; i < size; i++) {
				Point cur = jihoon.poll();

				if (map[cur.y][cur.x] == 'F')
					continue;

				if (cur.x == 0 || cur.x == (M - 1) || cur.y == 0 || cur.y == (N - 1)) {
					answer = time;
					break;
				}

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dir[j][0];
					int nextY = cur.y + dir[j][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && map[nextY][nextX] == '.' && !visit[nextY][nextX]) {
						jihoon.offer(new Point(nextX, nextY));
						visit[nextY][nextX] = true;
					}
				}
			}

			if (answer != -1)
				break;

			size = fire.size();

			for (int i = 0; i < size; i++) {
				Point cur = fire.poll();

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dir[j][0];
					int nextY = cur.y + dir[j][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
						if ((map[nextY][nextX] == '.') || (map[nextY][nextX] == 'J')) {
							fire.offer(new Point(nextX, nextY));
							map[nextY][nextX] = 'F';
						}
					}
				}
			}
		}

		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
	}
}
