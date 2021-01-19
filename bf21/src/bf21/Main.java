package bf21;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Permutation p = new Permutation(num, N);
			p.find_left();
			p.swap();
			p.reverse();
			sb = p.print();
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Permutation {
	int[] num;
	int N;
	int left;
	int right;
	
	Permutation(int[] num, int N){
		this.num = num;
		this.N = N;
		left = N - 1;
		right = N - 1;
	}
	
	public void find_left() {
		if(left == 0) {
			left = -1;
			return;
		}
		while(num[left] > num[left - 1]) {
			left--;
			if(left == 0) {
				left = -1;
				return;
			}
		}
	}
	
	public void swap() {
		if(left == -1) {
			return;
		}
		int max = 0;
		for(int i = left; i < N; i++) {
			if(num[i] < num[left - 1] && num[i] > max) {
				max = num[i];
				right = i;
			}
		}
		
		int temp = num[left - 1];
		num[left - 1] = num[right];
		num[right] = temp;
	}
	
	public void reverse() {
		if(left == -1) {
			return;
		}
		int start = left;
		int end = N - 1;
		for(int i = start; i < (end + start + 1) / 2; i++) {
			int temp = num[i];
			num[i] = num[end + start - i];
			num[end + start - i] = temp;
		}
	}
	
	public StringBuilder print() {
		StringBuilder sb2 = new StringBuilder();
		if(left == -1) {
			sb2.append(-1);
			return sb2;
		}
		for(int i = 0; i < N; i++) {
			sb2.append(num[i]).append(' ');
		}
		return sb2;
	}
}
