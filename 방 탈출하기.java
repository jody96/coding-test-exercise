import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] n_array = br.readLine().split(" ");
		HashSet<String> set = new HashSet(Arrays.asList(n_array));
		
		int m = Integer.parseInt(br.readLine());
		
		String[] m_array = br.readLine().split(" ");
		for(int i=0; i<m; i++){
			if(set.contains(m_array[i]))
				System.out.println("1");
			else
				System.out.println("0");
		}		
	}
}
