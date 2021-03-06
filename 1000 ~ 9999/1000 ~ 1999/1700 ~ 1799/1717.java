import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] num;

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
	
	static int findP(int n) {
		if(num[n] == n)
			return n;
		else {
			return findP(num[n]);
		}
	}
	
	static void union(int a, int b) {
		a = findP(a);
		b = findP(b);
		
		num[b] = a;
	}

	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N + 1];
		
		for(int i=0;i<=N;i++) {
			num[i] = i;
		}
		
		int op, num1, num2;
		
		for(int i=0;i<M;i++) {
			op = sc.nextInt();
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			if(op == 0) {
				union(num1, num2);
			}
			else {
				if(findP(num1) != findP(num2)) {
					sb.append("NO\n");
				}
				else {
					sb.append("YES\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
