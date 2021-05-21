import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();
		long answer = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			while (!st.isEmpty() && st.peek() <= num) {
				st.pop();
			}

			st.add(num);
			answer += st.size() - 1;
		}

		System.out.println(answer);
	}
}
