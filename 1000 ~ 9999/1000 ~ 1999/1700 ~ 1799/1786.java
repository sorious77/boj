import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static char[] s, p;
	static int[] pi;
	static ArrayList<Integer> answer = new ArrayList<>();

	static void getPi() {
		int j = 0;

		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j])
				j = pi[j - 1];
			if (p[i] == p[j])
				pi[i] = ++j;
		}
	}

	static void kmp() {
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			while (j > 0 && s[i] != p[j]) {
				j = pi[j - 1];
			}
			if (s[i] == p[j]) {
				if (j == p.length - 1) {
					answer.add(i - p.length + 2);
					j = pi[j];
				} else
					j++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		s = br.readLine().toCharArray();
		p = br.readLine().toCharArray();

		pi = new int[p.length];

		getPi();
		kmp();

		sb.append(answer.size()).append("\n");

		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append(" ");
		}

		System.out.println(sb.toString());
	}
}