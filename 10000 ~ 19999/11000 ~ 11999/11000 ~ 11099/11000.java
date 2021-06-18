import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Class implements Comparable<Class> {
		int s, e;

		Class() {
		}

		Class(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Class o) {
			return Integer.compare(this.s, o.s);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Class> classPQ = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			classPQ.offer(new Class(s, e));
		}

		PriorityQueue<Integer> inClass = new PriorityQueue<>();

		int size = 0;

		for (int i = 0; i < N; i++) {
			Class cur = classPQ.poll();

			if (!inClass.isEmpty()) {
				while (!inClass.isEmpty()) {
					if (inClass.peek() >= cur.s) {
						break;
					}
					inClass.poll();
				}
			}

			if (!inClass.isEmpty() && inClass.peek() == cur.s) {
				inClass.poll();
				inClass.offer(cur.e);
			} else {
				inClass.offer(cur.e);
			}

			size = Math.max(size, inClass.size());
		}
		System.out.println(size);
	}
}
