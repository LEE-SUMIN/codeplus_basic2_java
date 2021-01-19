package bf26;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
	
	static int L, C;
	static ArrayList<Character> alpha = new ArrayList<Character>();;
	static boolean[] check;
	static char[] answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			check = new boolean[C];
			answer = new char[L];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < C; i++) {
				alpha.add(st.nextToken().charAt(0));
			}
			
			alpha.sort(null);
			
			calc(0);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void calc(int idx) {
		if(idx == L) {
			int cnt_ja = 0;
			int cnt_mo = 0;
			for(int i = 0; i < L; i++) {
				if(answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u') {
					cnt_ja++;
				}
				else {
					cnt_mo++;
				}
			}
			if(cnt_ja >= 1 && cnt_mo >= 2) {
				sb.append(answer).append('\n');
			}
			return;
		}
		for(int i = 0; i < C; i++) {
			if(!check[i] && (idx == 0 || answer[idx - 1] < alpha.get(i))) {
				check[i] = true;
				answer[idx] = alpha.get(i);
				calc(idx + 1);
				check[i] = false;
			}
		}
	}

}
