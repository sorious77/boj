import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] num = new int[n];
		int[] dp = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = num[i];
			
			for(int j=0;j<i;j++) {
				if(num[i] > num[j] && dp[j] + num[i] > dp[i]) {
					dp[i] = dp[j] + num[i];
				}
			}
			
			answer = answer < dp[i] ? dp[i] : answer;
		}
		
		System.out.println(answer);
	}
}
