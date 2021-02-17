import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2960 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[N + 1];
		int count = 0;

		for (int i = 2; i <= N; i++) {
			if (!prime[i]) {
				count++;

				if (count == K) {
					System.out.println(i);
					return;
				}

				for (int j = 2; i * j <= N; j++) {
					if (!prime[i * j]) {
						prime[i * j] = true;

						count++;

						if (count == K) {
							System.out.println(i * j);
							return;
						}
					}
				}
			}
		}
	}
}