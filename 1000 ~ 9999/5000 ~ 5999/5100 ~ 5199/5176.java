import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());

			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[] chair = new boolean[M + 1];
			int answer = 0;

			for (int i = 0; i < P; i++) {
				int n = Integer.parseInt(br.readLine());

				if (chair[n])
					answer++;
				else {
					chair[n] = true;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
