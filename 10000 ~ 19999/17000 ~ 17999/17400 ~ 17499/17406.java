import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N, M, K;
	static int[][] array;
	static int[][] rotate;
	static boolean[] visit;
	static int[] order;
	static int answer;
	static int[][] temp;

	public static void permutation(int count) {
		if (count >= K) {
			temp = new int[N][M];
			for(int i=0;i<N;i++) {
				System.arraycopy(array[i], 0, temp[i], 0, M);
			}

			for (int i = 0; i < K; i++) {
				rotateArray(order[i], temp);
			}

			// find sum
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += temp[i][j];
				}
				answer = Math.min(sum, answer);
			}

			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				order[count] = i;
				permutation(count + 1);
				visit[i] = false;
			}
		}
	}

	public static void rotateArray(int r, int[][] arr) {
		int minX = rotate[r][1] - rotate[r][2] - 1; // 1
		int minY = rotate[r][0] - rotate[r][2] - 1; // 0
		int maxX = rotate[r][1] + rotate[r][2] - 1; // 5
		int maxY = rotate[r][0] + rotate[r][2] - 1; // 4

		while (minX < maxX && minY < maxY) {
			int temp = arr[minY][minX];
			for (int i = minY; i < maxY; i++) {
				arr[i][minX] = arr[i + 1][minX];
			}
			for (int i = minX; i < maxX; i++) {
				arr[maxY][i] = arr[maxY][i + 1];
			}
			for (int i = maxY; i > minY; i--) {
				arr[i][maxX] = arr[i - 1][maxX];
			}
			for (int i = maxX; i > minX + 1; i--) {
				arr[minY][i] = arr[minY][i - 1];
			}
			arr[minY][minX + 1] = temp;

			minX++;
			minY++;
			maxX--;
			maxY--;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;

		array = new int[N][M];
		visit = new boolean[K];
		order = new int[K];
		rotate = new int[K][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(0);
		System.out.println(answer);
	}
}
