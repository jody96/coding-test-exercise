import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split(" ");
		double w = Double.parseDouble(arr[0]);
		double r = Double.parseDouble(arr[1]);
		double result = w * (1 +  (r / 30));
		System.out.println((int)result);
	}
}
