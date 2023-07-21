public class NthRootOfM {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 0;
        int high = Math.max(n, m);

        while(low <= high){
            int mid = low + (high - low)/2;
            int x = (int)Math.pow(mid, n);
            if(x == m){
                return mid;
            }else if(x > m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
