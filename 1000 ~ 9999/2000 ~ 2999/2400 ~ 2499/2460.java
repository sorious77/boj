import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int answer = -1;
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());

			sum += Integer.parseInt(st.nextToken()) * -1 + Integer.parseInt(st.nextToken());

			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}
