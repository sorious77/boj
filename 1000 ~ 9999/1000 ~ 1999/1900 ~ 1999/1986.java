import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

		boolean[][] map = new boolean[N + 1][M + 1];
		boolean[][] visit = new boolean[N + 1][M + 1];
		ArrayList<Point> queen = new ArrayList<>();

		int[][] kDir = { { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 } };
		int[][] qDir = { { 1, 0 }, { 1, -1 }, { 1, 1 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };
		
		// queen 입력
		st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = true;
			visit[y][x] = true;
			queen.add(new Point(x, y));
		}

		// knight 입력
		st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = true; // knight가 있으면 queen이 못 이동함
			visit[y][x] = true;

			// knight는 장애물 상관없이 움직일 수 있기 때문에 바로 이동
			for (int j = 0; j < 8; j++) {
				int nextX = x + kDir[j][0];
				int nextY = y + kDir[j][1];

				if (0 < nextX && nextX <= M && 0 < nextY && nextY <= N) {
					visit[nextY][nextX] = true;
				}
			}
		}

		// pawn 입력
		st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = true;
			visit[y][x] = true;
		}

		// queen 이동
		for (int i = 0; i < queen.size(); i++) {
			int x = queen.get(i).x;
			int y = queen.get(i).y;

			for (int j = 0; j < 8; j++) {
				int nextX = x + qDir[j][0];
				int nextY = y + qDir[j][1];

				while (0 < nextX && nextX <= M && 0 < nextY && nextY <= N && !map[nextY][nextX]) {
					visit[nextY][nextX] = true;
					nextX += qDir[j][0];
					nextY += qDir[j][1];
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visit[i][j])
					answer++;
			}
		}

		System.out.println(answer);
	}
}
