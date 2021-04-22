import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		if (num.length() == 1) {
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
			return;
		}

		boolean flag = true;
		int diff = num.charAt(1) - num.charAt(0);

		for (int i = 2; i < num.length(); i++) {
			if (num.charAt(i) - num.charAt(i - 1) != diff) {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
		}
		else {
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
		}
	}
}