import java.util.ArrayList;

public class PascalTriangle {
	public static ArrayList<Long> getNthRow(int row){
		ArrayList<Long> temp = new ArrayList<>();
		long result = 1;
		temp.add(result);
		for(int i = 0; i < row; i++){
			result = result * (row - i);
			result = result/(i+1);
			temp.add(result);
		}

		return temp;
	}
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
		ArrayList<ArrayList<Long>> answer = new ArrayList<>();
		for(int i = 0; i < n; i++){
			answer.add(getNthRow(i));
		}
		return answer;
	}
}
