import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static int[][] castle;
	static int[] archer;
	static int answer;

	static class Pos {
		int x, y;

		Pos() {
		}

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Pos findMinDist(int[][] temp, int bow) {
		Pos pos = new Pos(-1, -1);
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if(temp[j][i] == 1) {
					int dist = Math.abs(bow - i) + Math.abs(N - j);
					if(min > dist && dist<= D) {
						min = dist;
						pos.x = i;
						pos.y = j;
					}
				}
			}
		}

		return pos;
	}

	static void dfs(int index, int count, boolean[] visit) {
		if (count >= 3) {
			int sum = 0;
			int[][] temp = new int[N][M];

			for (int i = 0; i < N; i++) {
				System.arraycopy(castle[i], 0, temp[i], 0, M);
			}

			for (int i = 0; i < N; i++) { // N 번만큼 내려옴
				Pos[] die = new Pos[3];

				for (int j = 0; j < 3; j++) {
					die[j] = findMinDist(temp, archer[j]);
				}

				for (int j = 0; j < 3; j++) {
					Pos cur = die[j];

					if (cur.x == -1)
						continue;

					if (temp[cur.y][cur.x] == 1) {
						temp[cur.y][cur.x] = 0;
						sum++;
					}
				}

				for (int j = N - 1; j > 0; j--) {
					for (int k = 0; k < M; k++) {
						temp[j][k] = temp[j - 1][k];
					}
				}

				for (int j = 0; j < M; j++) {
					temp[0][j] = 0;
				}
			}

			answer = Math.max(sum, answer);

			return;
		}

		for (int i = index; i < M; i++) {
			if (!visit[i]) {
				visit[i] = true;
				archer[count] = i;
				dfs(i + 1, count + 1, visit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		castle = new int[N][M];
		archer = new int[3];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, new boolean[M]);

		System.out.println(answer);
	}
}