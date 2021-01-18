package bf8;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static boolean[] check;
	static int[] answer;
	static int N;
	static int M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			check = new boolean[N + 1];
			answer = new int[M];
			
			calc(0);
			
			bw.append(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(int idx) {
		if(idx == M) {
			for(int i = 0; i < idx; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				answer[idx] = i + 1;
				calc(idx + 1);
				check[i] = false;
			}
		}
	}
}
