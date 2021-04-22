import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			sb.append("Case #").append(i).append(": ");

			Stack<String> stk = new Stack<>();
			
			while(st.hasMoreTokens()) {
				stk.push(st.nextToken());
			}
			
			while(!stk.isEmpty()) {
				sb.append(stk.pop()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}