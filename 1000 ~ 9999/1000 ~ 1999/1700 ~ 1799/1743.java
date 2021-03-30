import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");
	static int N, M, K;
	static boolean[] visit;
	static int answer = 0;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static ArrayList<Point> list = new ArrayList<>();

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static boolean canMove(int curX, int curY, int nextX, int nextY) {
		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			if (curX + dir[i][0] == nextX && curY + dir[i][1] == nextY) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	public static void main(String[] args) throws Exception {
		N = nextInt();
		M = nextInt();
		K = nextInt();

		for (int i = 0; i < K; i++) {
			int y = nextInt();
			int x = nextInt();
			list.add(new Point(x, y));
		}
		
		visit = new boolean[K];

		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				Point temp = list.get(i);
				Queue<Point> q = new LinkedList<>();
				q.offer(temp);
				visit[i] = true;
				int count = 1;

				while (!q.isEmpty()) {
					Point cur = q.poll();
					
					for (int j = i; j < K; j++) {
						if(!visit[j]) {
							Point p = list.get(j);
							
							if(canMove(cur.x, cur.y, p.x, p.y)) {
								visit[j] = true;
								count++;
								q.offer(p);
							}
						}
					}
				}
				
				answer = Math.max(answer, count);
			}
		}
		
		System.out.println(answer);
	}
}