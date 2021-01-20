package bf34;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static int[][] paper;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			paper = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					paper[i][j] = input.charAt(j) - '0';
				}
			}
			
			int max = get_total();
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int get_total() {
		int max = 0;
		for(int s = 0; s < (1 << (N * M)); s++) {
			int sum = 0;
			sum += get_hori(s);
			sum += get_vert(s);
			if(sum > max) {
				max = sum;
			}
		}
		return max;		
	}
	
	public static int get_hori(int s) {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int temp = 0;
			for(int j = 0; j < M; j++) {
				if((s & (1 << i * M + j)) != 0) {
					temp *= 10;
					temp += paper[i][j];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp; //여기 조심!
		}
		return sum;
	}
	
	public static int get_vert(int s) {
		int sum = 0;
		for(int i = 0; i < M; i++) {
			int temp = 0;
			for(int j = 0; j < N; j++) {
				if((~s & (1 << j * M + i)) != 0) {
					temp *= 10;
					temp += paper[j][i];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		return sum;
	}

}
