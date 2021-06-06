import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			int[] sky = new int[W];
			
			Arrays.fill(sky, -1);

			for (int j = 0; j < W; j++) {
				if (input.charAt(j) == 'c') {
					sky[j] = 0;
				}
			}

			for (int j = 0; j < W; j++) {
				sb.append(sky[j]).append(" ");

				if (sky[j] == 0) {
					while (true) {
						if (j + 1 >= W || sky[j + 1] == 0) {
							break;
						}

						j++;
						sky[j] = sky[j - 1] + 1;
						sb.append(sky[j]).append(" ");
					}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}