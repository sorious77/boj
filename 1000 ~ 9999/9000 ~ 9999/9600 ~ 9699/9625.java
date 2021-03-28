import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] count = new int[46][2];
		count[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			count[i][0] = count[i - 1][1];
			count[i][1] = count[i - 1][0] + count[i - 1][1];
		}

		System.out.println(count[N][0] + " " + count[N][1]);
	}
}
