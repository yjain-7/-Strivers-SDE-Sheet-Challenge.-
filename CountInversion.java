import java.util.* ;
import java.io.*; 
public class CountInversion {

    public static void mergeSort(int low, int high, long[] arr, int[] count){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(low, mid, arr, count);
        mergeSort(mid+1, high, arr, count);
        merge(low, mid, high, arr, count);
    }
    //mergesort
    public static void merge(int low, int mid, int high, long[] arr, int[] count){
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                count[0] += mid - left + 1;
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }


        for(int i = low ; i <= high; i++){
            arr[i] = temp.get(i - low);
        }
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        int[] count = {0};
        mergeSort(0, n-1, arr, count);
        return count[0];
    }
}