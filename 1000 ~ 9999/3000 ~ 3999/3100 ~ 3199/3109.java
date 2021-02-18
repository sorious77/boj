import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	final static int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int R, C;
	static char[][] map;
	static int answer;
	static boolean flag;

	static class Pos {
		int x, y;

		Pos() {
		}

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int x, int y) {
		Stack<Pos> s = new Stack<>();
		s.add(new Pos(x, y));

		int curX, curY, nextX, nextY;

		while (!s.isEmpty()) {
			flag = false;
			curX = s.peek().x;
			curY = s.peek().y;

			if (curX == C - 1 && map[curY][curX] == '.') {
				answer++;

				while (!s.isEmpty()) {
					Pos temp = s.pop();
					map[temp.y][temp.x] = 'x';
				}

				break;
			}
			
			map[curY][curX] = 'x';

			for (int i = 0; i < 3; i++) {
				nextX = curX + dir[i][0];
				nextY = curY + dir[i][1];

				if (nextX < C && 0 <= nextY && nextY < R && map[nextY][nextX] == '.') {
					s.add(new Pos(nextX, nextY));
					flag = true;
					break;
				}
			}

			if (!flag) {
				s.pop();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			dfs(0, i);
		}
		
		System.out.println(answer);
	}
}