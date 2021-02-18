import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int count = 0;

	static void hanoi(int num, int from, int temp, int to) {
		if (num == 0) {
			return;
		}

		count++;
		hanoi(num - 1, from, to, temp);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(num - 1, temp, from, to);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();

		hanoi(N, 1, 2, 3);

		System.out.println(count);
		System.out.println(sb.toString());
	}
}
