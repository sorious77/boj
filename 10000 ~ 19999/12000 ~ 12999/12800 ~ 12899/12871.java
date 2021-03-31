import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		int lenS = s.length();
		int lenT = t.length();

		int LCM = lenS * lenT / findGCD(lenS, lenT);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < LCM / lenS; i++) {
			sb.append(s);
		}

		s = sb.toString();

		sb = new StringBuilder();
		for (int i = 0; i < LCM / lenT; i++) {
			sb.append(t);
		}

		t = sb.toString();

		boolean answer = true;

		for (int i = 0; i < LCM; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				answer = false;
				break;
			}
		}

		System.out.println(answer == true ? 1 : 0);
	}
}
