import java.util.ArrayList;
public class SingleNonDuplicate
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
        int n = arr.size();
        int start = 0;
        int end = n-1;

        while(start < end){
            int mid = start + (end - start)/2;
            int a = arr.get(mid);
            if(mid % 2 == 1){    
                int b = arr.get(mid - 1);

                if(a==b){
                    start = mid+1;
                }
                else{
                    end = mid;
                }
            }else if(mid %2 == 0){
                int b = arr.get(mid + 1);
                if(a == b){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
        }
        return arr.get(start);
    }
}