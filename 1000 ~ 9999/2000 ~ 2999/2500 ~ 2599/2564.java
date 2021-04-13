import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static String next() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	public static void main(String[] args) throws Exception {
		int w = nextInt();
		int h = nextInt();

		int store = nextInt();
		int[] s = new int[store];

		for (int i = 0; i < store; i++) {
			int dir = nextInt();
			int dist = nextInt();

			if (dir == 1) {
				s[i] = dist;
			} else if (dir == 2) {
				s[i] = w * 2 + h - dist;
			} else if (dir == 3) {
				s[i] = 2 * (w + h) - dist;
			} else {
				s[i] = w + dist;
			}
		}

		int dir = nextInt();
		int dist = nextInt();
		int x = 0;

		if (dir == 1) {
			x = dist;
		} else if (dir == 2) {
			x = 2 * w + h - dist;
		} else if (dir == 3) {
			x = 2 * (w + h) - dist;
		} else {
			x = w + dist;
		}

		int answer = 0;

		for (int i = 0; i < store; i++) {
			int diff = Math.abs(x - s[i]);

			if (diff > w + h) {
				diff = 2 * (w + h) - diff;
			}

			answer += diff;
		}

		System.out.println(answer);
	}
}
