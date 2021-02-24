import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int answer;

	static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	static class Point {
		int x, y;
		int d; // distance

		public Point() {
		}

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static void bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		
		for(int i=0;i<N;i++) {
			Arrays.fill(visit[i], false);
		}
		
		visit[p.y][p.x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int nextX, nextY;

			answer = answer > cur.d ? answer : cur.d;

			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dir[i][0];
				nextY = cur.y + dir[i][1];

				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && map[nextY][nextX] == 'L' && !visit[nextY][nextX]) {				
					q.offer(new Point(nextX, nextY, cur.d + 1));
					visit[nextY][nextX] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		answer = 0;
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(new Point(j, i, 0));
				}
			}
		}

		System.out.println(answer);
	}
}