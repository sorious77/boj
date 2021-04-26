import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int MAX = 1000000;
		int[] pNum = new int[MAX + 1];
		int[] nNum = new int[MAX + 1];

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp >= 0) {
				pNum[temp]++;
			} else {
				nNum[temp * -1]++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = MAX; i > 0; i--) {
			if (nNum[i] > 0) {
				for (int j = 0; j < nNum[i]; j++) {
					sb.append(i * -1).append("\n");
				}
			}
		}

		for (int i = 0; i <= MAX; i++) {
			if (pNum[i] > 0) {
				for (int j = 0; j < pNum[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
