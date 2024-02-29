

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int d= Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		int c = Integer.parseInt(tk.nextToken());
		int[] arr = new int[2*n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr[i+n] = arr[i];
		}
		int result = 0;
		int[] cnt = new int[d+1];
		for(int i=0; i<k-1; i++) {
			int idx = arr[i];
			if(cnt[idx]++ == 0)
				result++;
		}
		if(cnt[c]++ ==0)
			result++;
		
		
		int start = 0;
		int end = k-1;
		int answer = 0;
		while(start<n) {
			int startKey = arr[start];
			int endKey = arr[end];
			if(cnt[endKey]++ == 0)
				result ++;
			if(result > answer)
				answer = result;
			if(cnt[startKey]-- == 1)
				result --;
			start++;
			end++;
			
		}
		
		System.out.println(answer);
		
	}

}
