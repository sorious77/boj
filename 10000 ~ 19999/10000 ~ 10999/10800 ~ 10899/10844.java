import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long mod = 1000000000;

		long[][] num = new long[N + 1][10];

		Arrays.fill(num[1], 1);
		num[1][0] = 0;

		for (int i = 2; i <= N; i++) {
			num[i][0] = num[i - 1][1];
			for (int j = 1; j < 9; j++) {
				num[i][j] = (num[i - 1][j - 1] + num[i - 1][j + 1]) % mod;
			}
			num[i][9] = num[i - 1][8];
		}

		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + num[N][i]) % mod;
		}
		System.out.println(answer);
	}
}