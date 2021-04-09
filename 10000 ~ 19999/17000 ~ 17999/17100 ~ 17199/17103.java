import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int MAX_IDX = 1000000;
		boolean[] check = new boolean[MAX_IDX + 1];
		ArrayList<Integer> prime = new ArrayList<>();

		int test_case = Integer.parseInt(br.readLine());

		for (int i = 2; i <= MAX_IDX; i++) {
			if (!check[i]) {
				prime.add(i);

				for (int j = 2; i * j <= MAX_IDX; j++) {
					check[i * j] = true;
				}
			}
		}

		for (int t = 0; t < test_case; t++) {
			int num = Integer.parseInt(br.readLine());

			int count = 0;

			int size = prime.size();
			for (int i = 0; i < size; i++) {
				int cur = prime.get(i);

				if (cur > num / 2)
					break;

				if (num - cur >= 0 && !check[num - cur]) {
					count++;
				}
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}