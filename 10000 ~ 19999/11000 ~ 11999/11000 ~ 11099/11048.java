import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] candy = new int[N][M];

		int[][] dir = { { -1, 0 }, { 0, -1 }, { -1, -1 } };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		candy[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 3; k++) {
					int prevX = j + dir[k][0];
					int prevY = i + dir[k][1];

					if (prevX >= 0 && prevY >= 0) {
						candy[i][j] = Math.max(candy[i][j], candy[prevY][prevX] + map[i][j]);
					}
				}
			}
		}

		System.out.println(candy[N - 1][M - 1]);
	}
}