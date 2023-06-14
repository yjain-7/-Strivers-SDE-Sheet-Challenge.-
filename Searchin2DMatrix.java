import java.util.ArrayList;
public class Searchin2DMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.

        int r = 0;
        int c = mat.get(r).size()-1;

        while(r < mat.size() && c >= 0){
            int val = mat.get(r).get(c);

            if(val == target){
                return true;
            }
            else if(val > target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
}
