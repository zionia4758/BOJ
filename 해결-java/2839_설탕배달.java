import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = -1;
		for(int i=0; i<5; i++) {
			if(n%5 == 0) {
				answer = i+n/5;
			}
			n -= 3;
			if(n<0)
				break;
		}
		System.out.println(answer);
	}

}
