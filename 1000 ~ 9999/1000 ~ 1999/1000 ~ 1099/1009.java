import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1009 {
	static class Reader {
		BufferedReader br;
		StringTokenizer st;

		Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int test_case = reader.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= 9; i++) {
			list.add(new ArrayList<Integer>());
			list.get(i).add(i);
			int last = i;

			while (true) {
				last = last * i % 10;

				if (last == i)
					break;

				list.get(i).add(last);
			}
		}

		for (int i = 0; i < test_case; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();

			a = a % 10;

			if (a == 0) {
				sb.append("10\n");
			}

			else {
				b = (b - 1) % list.get(a).size();

				sb.append(Integer.toString(list.get(a).get(b))).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
