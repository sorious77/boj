import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		if (min > max) {
			int temp = max;
			max = min;
			min = temp;
		}

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		if (y > x) {
			System.out.println("Unknwon Number");
			return;
		}

		x = Math.abs(x);

		for (int i = min; i <= max; i++) {
			int r = (i % x + x) % x;

			if (r == y) {
				if (i + x <= max) {
					System.out.println("Unknwon Number");
				} else {
					System.out.println(i);
				}
				break;
			}
		}
	}
}
