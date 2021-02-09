import java.util.Scanner;

public class Main {
	public static boolean isPalin(int n) {
		String s = Integer.toString(n);
		int len = s.length();

		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		final int MAX_RANGE = 1004000;
		boolean[] prime = new boolean[MAX_RANGE];

		prime[1] = true;
		for (int i = 2; i * i < MAX_RANGE; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j < MAX_RANGE; j++) {
					prime[i * j] = true;
				}
			}
		}

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int answer = 0;

		for (int i = N; i < MAX_RANGE; i++) {
			if (isPalin(i) && !prime[i]) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
