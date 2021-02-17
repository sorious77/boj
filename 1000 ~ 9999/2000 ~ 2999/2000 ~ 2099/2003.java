import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0;
		while (start < N) {
			int sum = 0;

			while (end < N) {
				sum += num[end];
				
				if (sum == M) {
					answer++;
					break;
				} else if (sum > M) {
					break;
				}

				end++;
			}
			start++;
			end = start;
		}

		System.out.println(answer);
	}

}