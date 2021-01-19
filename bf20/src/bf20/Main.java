package bf20;
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
	StringBuilder sb2 = new StringBuilder();
	
	Permutation(int[] num, int N){
		this.N = N;
		this.num = num;
		this.left = N - 1;
		this.right = N - 1;
	}
	
	public void find_left() {
		if(left < 1)
			return;
		while(num[left] < num[left - 1]) {
			left--;
			if(left < 1) {
				return;
			}
		}
	}
	
	public void swap() {
		if(left == 0) {
			return;
		}
		int idx = N - 1;
		int min = 10000;
		while(idx > left - 1) {
			if(num[idx] > num[left - 1] && num[idx] < min) {
				min = num[idx];
				right = idx;
			}
			idx--;
		}
		int temp = num[left - 1];
		num[left - 1] = num[right];
		num[right] = temp;
	}
	
	public void reverse() {
		if(left == 0) {
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
		if(left == 0) {
			sb2.append(-1);
		}
		else {
			for(int i = 0; i < N; i++) {
				sb2.append(num[i]).append(' ');
			}
		}
		return sb2;
		
	}
	
	
}
