import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		StringBuilder temp = new StringBuilder().append(T);
		int length = temp.length();
		boolean flag = false;

		for (int i = 0; i < T.length(); i++) {
			if (temp.toString().equals(S)) {
				flag = true;
				break;
			}

			char ch = temp.toString().charAt(length - 1);
			
			temp.deleteCharAt(length - 1);
			length--;
			
			if (ch == 'B') {
				temp = temp.reverse();
			}
		}

		System.out.println(flag ? 1 : 0);
	}
}