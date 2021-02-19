import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alpha;
	static char[] pw;
	static boolean[] visit;
	static StringBuilder sb;

	static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;

		return false;
	}

	static void dfs(int vowel, int conso, int length, int index) {
		if (length == L) {
			if (vowel >= 1 && conso >= 2) {
				for (char c : pw) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = index; i < C; i++) {
			pw[length] = alpha[i];
			if (isVowel(alpha[i])) {
				dfs(vowel + 1, conso, length + 1, i + 1);
			} else {
				dfs(vowel, conso + 1, length + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new char[C];
		visit = new boolean[C];
		pw = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alpha);
		dfs(0, 0, 0, 0);
		System.out.println(sb.toString());
	}
}
