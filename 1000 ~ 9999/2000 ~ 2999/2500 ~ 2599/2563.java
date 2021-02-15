import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		boolean[][] paper = new boolean[100][100];

		int minX = 999, minY = 999, maxX = 0, maxY = 0;
		int x, y;
		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			maxX = Math.max(maxX, x + 10);
			maxY = Math.max(maxY, y + 10);

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					paper[i][j] = true;
				}
			}
		}

		int answer = 0;

		for (int i = minY; i < maxY; i++) {
			for (int j = minX; j < maxX; j++) {
				if(paper[i][j]) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}