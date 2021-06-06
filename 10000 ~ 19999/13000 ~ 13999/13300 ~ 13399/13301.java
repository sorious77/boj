import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] fibo = new long[N + 3];

		fibo[1] = 1;

		for (int i = 2; i <= N + 2; i++) {
			fibo[i] = fibo[i - 2] + fibo[i - 1];
		}

		long answer = fibo[N + 2] * 2;

		System.out.println(answer);
	}
}
