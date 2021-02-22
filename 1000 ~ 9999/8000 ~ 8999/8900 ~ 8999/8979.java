import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Country implements Comparable<Country> {
		int num;
		int gold;
		int silver;
		int bronze;
		int rank;

		Country() {
		}

		public Country(int num, int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Country o) {
			if (gold == o.gold) {
				if (silver == o.silver) {
					return o.bronze - bronze;
				}
				return o.silver - silver;
			}
			return o.gold - gold;
		}

		public boolean compare(Country c) {
			if (gold == c.gold && silver == c.silver && bronze == c.bronze)
				return true;
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Country> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			list.add(new Country(num, gold, silver, bronze));
		}

		Collections.sort(list);
        
        if(list.get(0).num == K) {
			System.out.println(1);
			return;
		}
		
		list.get(0).rank = 1;
		int count = 0;

		for (int i = 1; i < N; i++) {
			if (list.get(i).compare(list.get(i - 1))) {
				list.get(i).rank = list.get(i - 1).rank;
				count++;
			} else {
				list.get(i).rank = list.get(i - 1).rank + count + 1;
				count = 0;
			}

			if (list.get(i).num == K) {
				System.out.println(list.get(i).rank);
				break;
			}
		}
	}
}