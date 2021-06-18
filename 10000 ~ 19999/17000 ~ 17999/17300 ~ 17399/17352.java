import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] p;

	static int find(int x) {
		if (p[x] == x)
			return x;

		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		
		p[y] = x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int N = Integer.parseInt(br.readLine());

		p = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			union(x, y);
		}


		for (int i = 2; i <= N; i++) {
			if (find(1) != find(i)) {
				System.out.println(1 + " " + i);
				break;
			}
		}
	}
}