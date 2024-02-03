package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		int n,m,s,e;
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		int[] nums = new int[n+1];
		token = new StringTokenizer(bf.readLine());
		nums[1] = Integer.parseInt(token.nextToken());
		for(int i=1; i<n; i++) {
			nums[i+1] = Integer.parseInt(token.nextToken()) + nums[i];
		}
		for(int i=0; i<m; i++) {
			token = new StringTokenizer(bf.readLine());
			s = Integer.parseInt(token.nextToken());
			e = Integer.parseInt(token.nextToken());
			System.out.println(nums[e]-nums[s-1]);
		}
		
		
	}

}
