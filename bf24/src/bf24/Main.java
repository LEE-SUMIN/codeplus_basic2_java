package bf24;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int min = 10000000;
	static int N;
	static int[][] cost;
	static boolean[] check;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			cost = new int[N][N];
			check = new boolean[N];
			check[0] = true;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(0, 0, 0);
			
			System.out.println(min);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void move(int j, int sum, int idx) {
		if(sum > min) {
			return;
		}
		if(idx == N - 1) {
			if(cost[j][0] == 0) {
				return;
			}
			sum += cost[j][0];
			if(sum > min) {
				return;
			}
			min = sum;
			return;
		}
		for(int k = 1; k < N; k++) {
			if(!check[k] && cost[j][k] != 0) {
				check[k] = true;
				move(k, sum + cost[j][k], idx + 1);
				check[k] = false;
			}		
		}
	}
}