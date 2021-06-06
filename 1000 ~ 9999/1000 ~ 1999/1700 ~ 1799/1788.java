import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] fibo = new int[Math.abs(N) + 1];
		int MOD = 1000000000;

		if (N == 0) {
			System.out.println("0\n0");
			return;
		}

		fibo[1] = 1;
		int answer = 0;

		if (N < 0) {
			for (int i = 2; i <= N * -1; i++) {
				fibo[i] = (fibo[i - 2] - fibo[i - 1]) % MOD;
			}
			answer = fibo[N * -1];
		} else {
			for (int i = 2; i <= N; i++) {
				fibo[i] = (fibo[i - 2] + fibo[i - 1]) % MOD;
			}
			answer = fibo[N];
		}

		if(answer > 0) {
			System.out.println(1);
		} else if(answer == 0) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}
		
		System.out.println(Math.abs(answer));
	}
}
