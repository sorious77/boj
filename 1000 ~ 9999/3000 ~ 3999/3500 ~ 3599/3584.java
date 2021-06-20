import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());

				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				parent[c] = p;
			}

			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Stack<Integer> parentX = new Stack<>();
			Stack<Integer> parentY = new Stack<>();

			parentX.push(x);
			parentY.push(y);

			while (true) {
				int top = parentX.peek();

				if (parent[top] == top)
					break;

				parentX.push(parent[top]);
			}

			while (true) {
				int top = parentY.peek();

				if (parent[top] == top)
					break;

				parentY.push(parent[top]);
			}

			int answer = -1;

			while (!parentX.isEmpty() && !parentY.isEmpty()) {
				int pX = parentX.pop();
				int pY = parentY.pop();

				if (pX == pY) {
					answer = pX;
				} else {
					break;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
