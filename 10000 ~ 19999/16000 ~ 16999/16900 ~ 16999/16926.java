import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] array = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minX = 0;
		int maxX = M;
		int minY = 0;
		int maxY = N;
		int tempR = 0, init = 0;

		while (minX < maxX && minY < maxY) {
			tempR = R % ((maxX - minX) * 2 + (maxY - minY - 2) * 2);
			for (int k = 0; k < tempR; k++) {
				init = array[minY][minX];
				for (int i = minX; i < maxX - 1; i++) {
					array[minY][i] = array[minY][i + 1];
				}

				for (int i = minY; i < maxY - 1; i++) {
					array[i][maxX - 1] = array[i + 1][maxX - 1];
				}

				for (int i = maxX - 1; i > minX; i--) {
					array[maxY - 1][i] = array[maxY - 1][i - 1];
				}

				for (int i = maxY - 1; i > minY + 1; i--) {
					array[i][minX] = array[i - 1][minX];
				}

				array[minY + 1][minX] = init;
			}

			minX++;
			maxX--;
			minY++;
			maxY--;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(Integer.toString(array[i][j])).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
