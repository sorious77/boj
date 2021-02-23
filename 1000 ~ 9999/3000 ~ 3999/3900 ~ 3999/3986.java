import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			Stack<Character> st = new Stack<>();
			String s = br.readLine();
			boolean flag = true;

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (st.isEmpty()) {
					st.add(ch);
				} else {
					if (st.peek() == ch) {
						st.pop();
					} else {
						st.push(ch);
					}
				}
			}

			if (flag && st.isEmpty()) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}