import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num = br.readLine();

		int left = num.length() % 3;
		int sum = 0;

		if (left != 0) {
			String temp = num.substring(0, left);

			for (int i = 0; i < temp.length(); i++) {
				sum += Math.pow(2, temp.length() - 1 - i) * (temp.charAt(i) - '0');
			}

			sb.append(sum);
		}

		for (int i = left; i < num.length(); i += 3) {
			sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += Math.pow(2, 2 - j) * (num.charAt(i + j) - '0');
			}
			sb.append(sum);
		}
		System.out.println(sb);
	}
}
