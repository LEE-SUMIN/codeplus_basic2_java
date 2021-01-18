package bf12;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> num = new ArrayList<>();
	static boolean[] check;
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
			check = new boolean[N];
			answer = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num.add(Integer.parseInt(st.nextToken()));
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
		for(int i = 0; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				answer[idx] = num.get(i);
				calc(idx + 1);
				check[i] = false;
			}
		}
	}

}
