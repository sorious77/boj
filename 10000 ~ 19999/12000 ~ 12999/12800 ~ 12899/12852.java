import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int[] dp = new int[X + 1];
		int[] p = new int[X + 1];

		Arrays.fill(dp, 9999999);
		for (int i = 0; i <= X; i++) {
			p[i] = i;
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		p[X] = -1;
		dp[X] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur % 3 == 0 && cur / 3 >= 1) {
				if (dp[cur / 3] > dp[cur] + 1) {
					dp[cur / 3] = dp[cur] + 1;
					p[cur / 3] = cur;
					q.offer(cur / 3);
				}
			}

			if (cur % 2 == 0 && cur / 2 >= 1) {
				if (dp[cur / 2] > dp[cur] + 1) {
					dp[cur / 2] = dp[cur] + 1;
					p[cur / 2] = cur;
					q.offer(cur / 2);
				}
			}

			if (cur - 1 >= 1) {
				if (dp[cur - 1] > dp[cur] + 1) {
					dp[cur - 1] = dp[cur] + 1;
					p[cur - 1] = cur;
					q.offer(cur - 1);
				}
			}
		}

		Stack<Integer> stk = new Stack<>();
		int temp = p[1];
		
		while(true) {
			if(temp == -1)
				break;
			
			stk.add(temp);
			temp = p[temp];
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(dp[1]).append("\n");
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop()).append(" ");
		}
		
		sb.append("1");
		
		System.out.println(sb.toString());
	}
}