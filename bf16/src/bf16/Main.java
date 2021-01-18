package bf16;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> num = new ArrayList<>();
	static int[] check = new int[10001];
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(!num.contains(n)) {
					num.add(n);
				}
				check[n]++;
			}
			num.sort(null);
			
			calc(0);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void calc(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append('\n');
			return;
		}
		for(int i = 0; i < num.size(); i++) {
			int k = num.get(i);
			if(check[k] > 0) {
				check[k]--;
				answer[idx] = k;
				calc(idx + 1);
				check[k]++;
			}
		}
	}

}
