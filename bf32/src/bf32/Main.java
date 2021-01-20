package bf32;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int S = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			while(N --> 0) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				case "add":
					int k1 = Integer.parseInt(st.nextToken());
					add(k1);
					break;
				case "remove":
					int k2 = Integer.parseInt(st.nextToken());
					remove(k2);
					break;
				case "check":
					int k3 = Integer.parseInt(st.nextToken());
					check(k3);
					break;
				case "toggle":
					int k4 = Integer.parseInt(st.nextToken());
					toggle(k4);
					break;
				case "all":
					all();
					break;
				case "empty":
					empty();
					break;
				}
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void add(int k) {
		S |= (1 << (k - 1));
	}
	public static void remove(int k) {
		S &= ~(1 << (k - 1));
	}
	public static void check(int k) {
		int temp = S;
		temp = temp >> (k - 1);
		sb.append(temp & 1).append('\n');
	}
	public static void toggle(int k) {
		S ^= (1 << (k - 1));
	}
	public static void all() {
		S |= 0b11111111111111111111;
	}
	public static void empty() {
		S &= 0b00000000000000000000;
	}

}
