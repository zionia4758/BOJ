
import java.util.Arrays;
import java.util.Scanner;

public class B15650 {

	static int n,m;
	static int[] answer;
	static boolean[] used;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		answer = new int[m];
		used = new boolean[n];
		comb(0,0);
	}
	static void comb(int idx, int start) {
		if(idx == m) {
			for(int num: answer) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for(int num=start; num<n;num++) {
			if(used[num]) continue;
			used[num] = true;
			answer[idx] = num+1;
			comb(idx+1,num+1);
			used[num] = false;
		}
		
	}
}
