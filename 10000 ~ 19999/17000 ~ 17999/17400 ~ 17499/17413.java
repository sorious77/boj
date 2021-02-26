import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder print = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '<') {
				while (i < s.length()) {
					print.append(s.charAt(i));
					
					if(s.charAt(i) == '>')
						break;
					
					i++;
				}
			} else if (ch == ' ') {
				print.append(ch);
			} else {
				temp = new StringBuilder();
				while (i < s.length()) {					
					temp.append(s.charAt(i));
					
					if(i + 1 >= s.length() || s.charAt(i + 1) == ' ' || s.charAt(i + 1) == '<')
						break;
					
					i++;
				}
				print.append(temp.reverse().toString());
			}
		}
		System.out.println(print.toString());
	}
}