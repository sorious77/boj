import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		int[] sum = new int[N];

		int answer = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			if (i == 0)
				sum[i] = num[i];
			else {
				sum[i] = sum[i - 1] + num[i];
			}
		}
        
        answer = Math.max(sum[K - 1], answer);
		for (int i = 0; i < N - K; i++) {
			answer = Math.max(sum[i + K] - sum[i], answer);
		}

		System.out.println(answer);
	}
}
