import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i=0; i<n; i++){
			String[] inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int t = Integer.parseInt(inputs[1]);
			
			ArrayList<Integer> tmp_arr = map.get(t);
			if(tmp_arr == null){
				tmp_arr = new ArrayList<Integer>();
			}
			tmp_arr.add(a);
			map.put(t, tmp_arr);	
		}
		
		Collection<ArrayList<Integer>> arrays = map.values();
		for(ArrayList<Integer> arr : arrays){
			if(arr.size() > 2){
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}
}
