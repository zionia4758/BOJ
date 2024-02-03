
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B2023 {
	static int[] primes = new int[1500];
	static int[] pow2Prime = new int[1500];
	static int useSize = 1;
	public static void main(String[] args) throws IOException {
		primes[0] = 2;
		pow2Prime[0] = 4;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int under = 1;
		for(int i =1; i<n; i++) {
			under *= 10;
		}
		//prime set ����
		for(int num=3; num<(int)Math.sqrt(under*10)+1;num++) {
			if(isPrime(num)) {
				primes[useSize] = num;
				pow2Prime[useSize++] = num*num;
			}
		}
		LinkedList<Integer> nums = new LinkedList<>();
		nums.add(2);
		nums.add(3);
		nums.add(5);
		nums.add(7);
		while(nums.size()>0) {
			int num = nums.pop();
			if(num<under) {
				num*=10;
				for(int i=0; i<10; i++) {
					if(isPrime(num+i)) nums.addLast(num+i);
				}
			}else {
				sb.append(num).append('\n');
			}
		}
		System.out.println(sb);
	}
	static boolean isPrime(int num) {
		for(int i=0;i<useSize;i++) {
			if(num%primes[i]==0) return false;
			if(num<pow2Prime[i]) break;
		}
		return true;
	}

}
