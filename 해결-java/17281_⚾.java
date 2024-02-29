

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ining = Integer.parseInt(br.readLine());
		int[][] iningResult = new int[ining][9];
		for(int i=0; i<ining; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				iningResult[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int[] playerArr= {0,1,2,3,4,5,6,7,8};
		int answer=  0;
		do {
			//미리 뺴둔 1번 선수를 4번으로 옮긴다.
			swap(playerArr,0,3);
			int playerIdx = 0;
			int score = 0;
			for(int i=0; i<ining; i++) {
				boolean[] runner = new boolean[3];
				int out = 0;
				while(out<3) {
					int player = playerArr[playerIdx];
					playerIdx = (playerIdx+1)%9;
					int result = iningResult[i][player];
					if(result==0) {
						out++;
					}
					else {
						score += hit(runner,result);
					}
				}
			}
			if(score > answer) {
				answer= score;
			}
			//4번타자로 간 1번 선수를 다시 뺴둔다.
			swap(playerArr,0,3);
		}while(nextPermutation(playerArr));
		System.out.println(answer);
	}
	static int hit(boolean[]arr, int range) {
		int score = 0;
		for(int i=2; i>=0; i--) {
			if(i+range >= 3) {
				if(arr[i])
					score += 1;
			}else {
				arr[i+range] = arr[i];
			}
			arr[i] = false;
			
		}
		if(range==4) score ++;
		else arr[range-1] = true;
		
		return score;
	}
	
	static boolean nextPermutation(int[] arr) {
		int l = arr.length;
		int i = l-1;
		while(i>1 && arr[i-1] > arr[i]) i--;
		
		if(i==1) return false;
		
		int j = l-1;
		while(arr[i-1]>arr[j]) j--;
		swap(arr,j,i-1);
		int k = l-1;
		while(i<k) {
			swap(arr,i,k);
			i++;
			k--;
		}
		
		return true;
	}
	static void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

