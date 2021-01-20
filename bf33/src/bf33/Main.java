package bf33;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int[] num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for(int i = 1; i < (1 << N); i++) {
				int sum = 0;
				for(int k = 0; k < N; k++) {
					if((i & (1 << k)) != 0) { //== 1го╦И ╬х╣й..
						sum += num[k];
					}
				}
				if(sum == S) {
					count++;
				}
			}
			System.out.println(count);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
