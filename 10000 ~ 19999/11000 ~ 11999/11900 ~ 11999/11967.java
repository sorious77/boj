import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

	static class Switch {
		ArrayList<Point> light = new ArrayList<>();

		Switch() {
		}

		void addLight(int x, int y) {
			light.add(new Point(x, y));
		}
	}

	static boolean[][] map;
	static boolean[][] visit;
	static Switch[][] s;
	static ArrayList<Point> list; // 현재까지 방문한 모든 장소를 저장
	static int N, M;
	static int x, y, a, b;
	static int answer = 0;

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		s = new Switch[N + 1][N + 1];
		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			s[i] = new Switch[N + 1];
			for (int j = 0; j <= N; j++) {
				s[i][j] = new Switch();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			s[y][x].addLight(a, b);
		}

		map[1][1] = true;
		visit[1][1] = true;
		answer = 1;
		list.add(new Point(1, 1));

		for (int i = 0; i < s[1][1].light.size(); i++) {
			int x = s[1][1].light.get(i).x;
			int y = s[1][1].light.get(i).y;

			if(!map[y][x]) {
				answer++;
			}
			map[y][x] = true;
		}

		while (true) {
			boolean flag = false;

			// 새로운 곳을 방문하거나 불을 키면 flag는 true로
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Point cur = list.get(i);

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + dir[j][0];
					int nextY = cur.y + dir[j][1];

					if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= N && !visit[nextY][nextX]
							&& map[nextY][nextX]) {
						visit[nextY][nextX] = true;
						map[nextY][nextX] = true;
						list.add(new Point(nextX, nextY));
						flag = true;

						ArrayList<Point> temp = s[nextY][nextX].light;

						for (int k = 0; k < temp.size(); k++) {
							int x = temp.get(k).x;
							int y = temp.get(k).y;

							if (!map[y][x]) {
								answer++;
								map[y][x] = true;
							}
						}
					}
				}
			}

			if (!flag)
				break;
		}

		System.out.println(answer);
	}
}
