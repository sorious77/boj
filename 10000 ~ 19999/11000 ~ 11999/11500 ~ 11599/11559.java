import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

		int N = 12;
		int M = 6;

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = 0;
		while (true) {
			boolean flag = false;

			boolean[][] visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != '.' && !visit[i][j]) {
						char ch = map[i][j];

						int count = 1;
						visit[i][j] = true;
						Queue<Point> q = new LinkedList<>();
						ArrayList<Point> list = new ArrayList<>();

						q.offer(new Point(j, i));
						list.add(new Point(j, i));

						while (!q.isEmpty()) {
							Point cur = q.poll();

							for (int k = 0; k < 4; k++) {
								int nextX = cur.x + dir[k][0];
								int nextY = cur.y + dir[k][1];

								if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
									if (!visit[nextY][nextX] && map[nextY][nextX] == ch) {
										q.offer(new Point(nextX, nextY));
										visit[nextY][nextX] = true;
										list.add(new Point(nextX, nextY));
										count++;
									}
								}
							}
						}

						if (count >= 4) {
							for (int k = 0; k < count; k++) {
								Point cur = list.get(k);

								map[cur.y][cur.x] = '.';
							}

							flag = true;
						}
					}
				}
			}

			if (!flag)
				break;
			else {
				answer++;
				for (int i = 0; i < M; i++) {
					Stack<Character> st = new Stack<>();
					for (int j = 0; j < N; j++) {
						if (map[j][i] != '.') {
							st.push(map[j][i]);
							map[j][i] = '.';
						}
					}

					for (int j = N - 1; j >= 0 && !st.isEmpty(); j--) {
						map[j][i] = st.pop();
					}
				}
			}
		}

		System.out.println(answer);
	}
}
