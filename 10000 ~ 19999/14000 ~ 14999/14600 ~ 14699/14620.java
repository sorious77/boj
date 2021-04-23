import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;

	static void dfs(int N, int sum, int count, boolean[][] visit) {
		if (count >= 3) {
			if (answer > sum) {
				answer = sum;
			}
			return;
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (!visit[i][j]) {
					boolean flag = true;
					int temp = map[i][j];

					for (int k = 0; k < 4; k++) {
						int nextX = j + dir[k][0];
						int nextY = i + dir[k][1];

						if (visit[nextY][nextX]) {
							flag = false;
							break;
						}

						temp += map[nextY][nextX];
					}

					if (flag) {
						visit[i][j] = true;
						for (int k = 0; k < 4; k++) {
							int nextX = j + dir[k][0];
							int nextY = i + dir[k][1];

							visit[nextY][nextX] = true;
						}

						dfs(N, sum + temp, count + 1, visit);

						visit[i][j] = false;
						for (int k = 0; k < 4; k++) {
							int nextX = j + dir[k][0];
							int nextY = i + dir[k][1];

							visit[nextY][nextX] = false;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(N, 0, 0, new boolean[N][N]);

		System.out.println(answer);
	}
}
