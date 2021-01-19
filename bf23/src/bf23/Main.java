package bf23;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> num = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			num.sort(null);
			
			Permutation p = new Permutation(num, N);
			
			int max = p.calc();		
			while(p.find_next()) {
				int sum = p.calc();
				if(max < sum) {
					max = sum;
				}
			}
			
			sb.append(max);
			
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
	ArrayList<Integer> num;
	int N;
	
	Permutation(ArrayList<Integer> num, int N){
		this.num = num;
		this.N = N;
	}
	
	public int find_left() {
		int left = N - 1;
		if(left == 0) {
			return -1;
		}
		while(num.get(left) <= num.get(left - 1)) {
			left--;
			if(left == 0) {
				return -1;
			}
		}
		return left;
	}
	
	public void swap(int left) {
		int right = N - 1;
		int min = 10000;
		for(int i = left; i < N; i++) {
			if(num.get(left - 1) < num.get(i) && min > num.get(i)) {
				right = i;
				min = num.get(i);
			}
		}
		
		int temp = num.get(left - 1);
		num.set(left - 1, num.get(right));
		num.set(right, temp);
	}
	
	public void reverse(int left) {
		int start = left;
		int end = N - 1;
		for(int i = start; i < (end + start + 1) / 2; i++) {
			int temp = num.get(i);
			num.set(i, num.get(end + start - i));
			num.set(end + start - i, temp);
		}
	}
	
	public boolean find_next() {
		int left = find_left();
		if(left == -1) {
			return false;
		}
		swap(left);
		reverse(left);
		return true;
	}
	
	public int calc() {
		int sum = 0;
		for(int i = 0; i < N - 1; i++) {
			sum += Math.abs(num.get(i) - num.get(i + 1));
		}
		return sum;
	}
	
	
}
