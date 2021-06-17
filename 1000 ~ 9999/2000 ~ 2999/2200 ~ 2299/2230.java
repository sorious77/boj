import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(num);

		int left = 0;
		int right = 1;

		int answer = Integer.MAX_VALUE;

		while (left < N && right < N) {
			if (num[right] - num[left] < M) {
				right++;
			} else {
				answer = Math.min(answer, num[right] - num[left]);
				left++;
			}
		}

		System.out.println(answer);
	}
}
