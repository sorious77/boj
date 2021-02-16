import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());
		int left = 1000 - money;

		int count = 0;

		while (left > 0) {
			int temp = 0;
			if (left >= 500) {
				left -= 500;
				count++;
			} else if (left >= 100) {
				temp = left / 100;
				left -= temp * 100;
				count += temp;
			} else if (left >= 50) {
				left -= 50;
				count++;
			} else if (left >= 10) {
				temp = left / 10;
				left -= temp * 10;
				count += temp;
			} else if (left >= 5) {
				left -= 5;
				count++;
			} else {
				count += left;
				left = 0;
			}
		}

		System.out.println(count);
	}
}
