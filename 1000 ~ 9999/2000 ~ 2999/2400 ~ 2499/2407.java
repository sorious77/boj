import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		BigInteger[] fact = new BigInteger[N + 1];
		fact[1] = new BigInteger("1");

		for (int i = 2; i <= N; i++) {
			fact[i] = fact[i - 1].multiply(new BigInteger(Integer.toString(i)));
		}

		System.out.println(fact[N].divide(fact[N - M].multiply(fact[M])));
	}
}
