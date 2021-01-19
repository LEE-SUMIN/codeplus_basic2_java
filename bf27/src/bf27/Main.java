package bf27;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] sched;
	static int max = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			sched = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				sched[i][0] = Integer.parseInt(st.nextToken());
				sched[i][1] = Integer.parseInt(st.nextToken());
			}
			
			calc(0, 0);
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(int day, int cost) {
		if(day > N) {
			return;
		}
		if(day == N) {
			if(cost > max) {
				max = cost;
			}
			return;
		}
		calc(day + sched[day][0], cost + sched[day][1]);
		calc(day + 1, cost);
	}
}
