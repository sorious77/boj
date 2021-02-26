import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Reader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

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
		Reader sc = new Reader();

		int L = sc.nextInt();
		int N = sc.nextInt();

		int[] cake = new int[L + 1];
		int[][] people = new int[N + 1][2];

		int exVal = 0, realVal = 0;
		int exP = 0, realP = 0, count = 0;

		for (int i = 1; i <= N; i++) {
			people[i][0] = sc.nextInt();
			people[i][1] = sc.nextInt();
			count = 0;
			
			if(exVal < people[i][1] - people[i][0]) {
				exVal = people[i][1] - people[i][0];
				exP = i;
			}
			
			for(int j=people[i][0];j<=people[i][1];j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					count++;
				}
			}
			
			if(count > realVal) {
				realVal = count;
				realP = i;
			}
		}
		System.out.println(exP + "\n" + realP);
	}
}