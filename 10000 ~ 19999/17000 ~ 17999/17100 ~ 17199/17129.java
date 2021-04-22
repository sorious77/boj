import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];

		int x = 0, y = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';

				if (map[i][j] == 2) {
					x = j;
					y = i;
				}
			}
		}

		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();

		xQ.offer(x);
		yQ.offer(y);
		dist[y][x] = 0;

		int answer = -1;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!xQ.isEmpty()) {
			x = xQ.poll();
			y = yQ.poll();

			if (map[y][x] >= 3) {
				answer = dist[y][x];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = x + dir[i][0];
				int nextY = y + dir[i][1];

				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
					if (map[nextY][nextX] != 1 && dist[nextY][nextX] == Integer.MAX_VALUE) {
						dist[nextY][nextX] = dist[y][x] + 1;

						xQ.offer(nextX);
						yQ.offer(nextY);
					}
				}
			}
		}

		if (answer == -1) {
			System.out.println("NIE");
		} else {
			System.out.println("TAK");
			System.out.println(answer);
		}
	}
}
