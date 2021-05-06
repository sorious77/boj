import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		BigInteger[] fibo = new BigInteger[70];
		StringBuilder sb = new StringBuilder();

		fibo[0] = new BigInteger("1");
		fibo[1] = new BigInteger("1");
		fibo[2] = new BigInteger("2");
		fibo[3] = new BigInteger("4");

		for (int i = 4; i < 70; i++) {
			fibo[i] = fibo[i - 4].add(fibo[i - 3].add(fibo[i - 2]).add(fibo[i - 1]));
		}

		for (int t = 0; t < test_case; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(fibo[num]).append("\n");
		}

		System.out.println(sb.toString());
	}
}