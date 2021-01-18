package bf9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] answer;
	static boolean[] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = new int[M + 1];
			check = new boolean[N];
			
			answer[0] = -1;
			calc(1);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void calc(int idx) {
		if(idx == M + 1) {
			for(int i = 1; i < M + 1; i++) {
				sb.append(answer[i] + 1).append(' ');
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(answer[idx - 1] < i && !check[i]) {
				check[i] = true;
				answer[idx] = i;
				calc(idx + 1);
				check[i] = false;
			}
		}
	}
}
