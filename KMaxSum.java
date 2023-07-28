import java.util.* ;
import java.io.*; 
public class KMaxSum{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
		Collections.sort(a);
		Collections.sort(b);
		ArrayList<Integer> ans = new ArrayList<>();
		int flag = 0;
		int x = 0;
		if(a.get(n-1) > b.get(n-1)){
			x = a.get(n-1);
		}else{
			x = b.get(n-1);
			flag = 1;
		}
		if(flag == 0){
			for(int i = 0; i < k; i++){
				ans.add(x + b.get(n-k-1));
			}
		}else{
			for(int i = 0; i < k; i++){
				ans.add(x + a.get(n-i-1));
			}
		}

		return ans;
	}
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        // a.add(1);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(1);
        // b.add(6);
        System.out.println(kMaxSumCombination(a, b, 2, 1));
    }
}