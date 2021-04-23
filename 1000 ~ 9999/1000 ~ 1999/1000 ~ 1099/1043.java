import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] person;
	static boolean[] party;
	static boolean[][] visit;
	static int N, M;

	static void changeParty(int n) {
		// 파티가 true로 바뀌면 -> 해당 파티 참가인원을 true로

		party[n] = true;
		for (int i = 1; i <= N; i++) {
			if (visit[i][n] && !person[i]) {
				changePerson(i);
			}
		}
	}

	static void changePerson(int n) {
		// 사람이 true로 바뀌면 -> 해당 사람 참가 파티를 true로

		person[n] = true;
		for (int i = 1; i <= M; i++) {
			if (visit[n][i] && !party[i]) {
				changeParty(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		person = new boolean[N + 1];
		party = new boolean[M + 1];
		visit = new boolean[N + 1][M + 1];

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());

		for (int i = 0; i < X; i++) {
			person[Integer.parseInt(st.nextToken())] = true;
		}

		int answer = 0;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			boolean flag = false;

			int num = Integer.parseInt(st.nextToken());
			int[] temp = new int[num];

			for (int j = 0; j < num; j++) {
				temp[j] = Integer.parseInt(st.nextToken());

				visit[temp[j]][i] = true;

				if (person[temp[j]]) {
					flag = true;
				}
			}

			if (flag) {
				changeParty(i);
			}
		}

		for (int i = 1; i <= M; i++) {
			if (!party[i])
				answer++;
		}

		System.out.println(answer);
	}
}