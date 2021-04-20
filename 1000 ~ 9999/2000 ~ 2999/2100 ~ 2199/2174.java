import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int N, M;
	static int[][] map;
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	static class Robot {
		int x, y, d;

		Robot() {
		}

		Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int toInt(char c) {
		if (c == 'N')
			return 0;
		else if (c == 'E')
			return 1;
		else if (c == 'S')
			return 2;
		else
			return 3;
	}

	static int findDir(int cur, int count, char d) {
		// 현재 방향에서 d 방향으로 count만큼 회전

		// 4번돌면 원래대로 돌아가기 때문에 돌아가는 횟수를 줄여줌
		count %= 4;

		if (d == 'L') {
			return ((cur + 4) - count) % 4;
		} else {
			return (cur + count) % 4;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Robot[] robot = new Robot[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);

			robot[i + 1] = new Robot(x, R - y + 1, toInt(d));
			map[R - y + 1][x] = i + 1;
		}
		
		String answer = "";
		boolean flag = false;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			char op = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());

			if(flag)
				continue;
			
			if (op == 'L') {
				robot[r].d = findDir(robot[r].d, num, op);
			} else if (op == 'R') {
				robot[r].d = findDir(robot[r].d, num, op);
			} else {
				int curX = robot[r].x;
				int curY = robot[r].y;
				int d = robot[r].d;

				for (int j = 0; j < num; j++) {
					int nextX = curX + dir[d][0];
					int nextY = curY + dir[d][1];

					if (0 < nextX && nextX <= C && 0 < nextY && nextY <= R) {
						if (map[nextY][nextX] == 0) {
							map[nextY][nextX] = r;
							map[curY][curX] = 0;
							curX = nextX;
							curY = nextY;
						} else {
							answer = String.format("Robot %d crashes into robot %d", r, map[nextY][nextX]);
							flag = true;
						}
					} else {
						answer = String.format("Robot %d crashes into the wall", r);
						flag = true;
					}
				}
				
				robot[r].x = curX;
				robot[r].y = curY;
			}
			
			//System.out.println(robot[r].x + " " + robot[r].y + " " + robot[r].d);
		}

		if(!flag)
			System.out.println("OK");
		else {
			System.out.println(answer);
		}
	}
}