import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int R = 0;
		int C = 0;

		for (int i = 1; i * i <= str.length(); i++) {
			if (str.length() % i == 0) {
				R = i;
			}
		}

		C = str.length() / R;

		for (int i = 0; i < R; i++) {
			for (int j = i; j < str.length(); j += R) {
				sb.append(str.charAt(j));
			}
		}
		System.out.println(sb.toString());
	}
}
