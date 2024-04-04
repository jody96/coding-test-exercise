import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int t = Integer.parseInt(input);
		int sum = 0;
		for(int i=0; i<t; i++){
			StringTokenizer tst = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(tst.nextToken());
			String f = tst.nextToken();
			int b = Integer.parseInt(tst.nextToken());
			
			if(f.equals("+")){
				sum += (a + b);
			} else if(f.equals("-")) {
				sum += (a - b);
			} else if(f.equals("*")) {
				sum += (a * b);
			} else if(f.equals("/")) {
				sum += (a / b);
			}
		}
		System.out.println(sum);
		return;
	}
}
