public class Swap012 {
    public static void swap(int[] arr, int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
    public static void sort012(int[] arr){
        //Write your code here
        int i = 0, mid = 0, j = arr.length-1;

        while(mid <= j){
            if(arr[mid] == 0){
                swap(arr, mid, i);
                i++;
                mid++;
            }else if(arr[mid] == 2){
                swap(arr, mid, j);
                j--;
            }else if(arr[mid] == 1){
                mid++;
            }
        }
    }
}