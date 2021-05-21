import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int count = 1;
		int num = 1;
		int answer = 0;
		for (int i = 1; i <= b; i++, count++) {
			if (a <= i) {
				answer += num;
			}

			if (count == num) {
				count = 0;
				num += 1;
			}
		}

		System.out.println(answer);
	}
}
