import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[][] room = new char[N][N];

		for (int i = 0; i < N; i++) {
			room[i] = br.readLine().toCharArray();
		}

		boolean[][] visit = new boolean[N][N];
		int width = 0, height = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && room[i][j] == '.') {
					if (j + 1 < N && room[i][j + 1] == '.') {
						j++;
						width++;
						while (j + 1 < N && room[i][j + 1] == '.') {
							visit[i][j] = true;
							j++;
						}
					}
				}
			}
		}

		for(int i=0;i<N;i++) {
			Arrays.fill(visit[i], false);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[j][i] && room[j][i] == '.') {
					if (j + 1 < N && room[j + 1][i] == '.') {
						j++;
						height++;
						while (j + 1 < N && room[j + 1][i] == '.') {
							visit[j][i] = true;
							j++;
						}
					}
				}
			}
		}
		
		System.out.println(width + " " + height);
	}

}
