package bf29;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] power;
	static int min = 2000;
	static int sp = 0;
	static int lp = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			power = new int[N][N];
			int[] check = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					power [i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			calc(0, check, 0, 0);
			
			System.out.println(min);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(int idx, int[] check, int start, int link) {
		if(idx == N) {
			if(start >= 1 && link >= 1) {
				int diff = get_diff(check);
				if(min > diff) {
					min = diff;
				}
			}
			return;
		}
		check[idx] = 1;
		calc(idx + 1, check, start + 1, link);
		check[idx] = 2;
		calc(idx + 1, check, start, link + 1);
	}
	
	public static int get_diff(int[] check) {
		sp = 0;
		lp = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(check[i] == 1 && check[j] == 1) {
					sp += power[i][j];
				}
				else if(check[i] == 2 && check[j] == 2) {
					lp += power[i][j];
				}
			}
		}
		return Math.abs(sp - lp);
	}
}