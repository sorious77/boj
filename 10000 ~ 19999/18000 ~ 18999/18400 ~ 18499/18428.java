import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] map;
	static boolean answer;
	static ArrayList<Point> teacher;
	static ArrayList<Point> block;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int x, int y, int count) {
		if (answer)
			return;

		if (count >= 3) {
			// 확인 후
			int size = teacher.size();
			boolean flag = true;

			for (int i = 0; i < size; i++) {
				// 네 방향으로 쭉 가면서 S가 있다면 그냥 리턴

				Point cur = teacher.get(i);

				for (int j = 0; j < 4; j++) {
					int nextX = cur.x;
					int nextY = cur.y;

					while (true) {
						if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N)
							break;

						if (map[nextY][nextX] == 'B')
							break;

						if (map[nextY][nextX] == 'S') {
							return;
						}

						nextX += dir[j][0];
						nextY += dir[j][1];
					}
				}
			}

			if (flag)
				answer = true;

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (answer)
					return;

				if (map[i][j] == 'X') {
					map[i][j] = 'B';
					dfs(j, i, count + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		answer = false;
		teacher = new ArrayList<>();
		block = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);

				if (map[i][j] == 'T') {
					teacher.add(new Point(j, i));
				}
			}
		}

		dfs(0, 0, 0);

		if (answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
