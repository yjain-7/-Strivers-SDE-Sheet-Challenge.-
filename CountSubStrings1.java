public class CountSubStrings1 {
    public static int countSubStrings(String str, int k) {
        // Write your code here.
        int n = str.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            int dist_count = 0;
            int[] cnt = new int[26];
            for(int j = i; j < n; j++){
                if(cnt[str.charAt(j) - 'a'] == 0){
                    dist_count++;
                }
                cnt[str.charAt(j) - 'a']++;
                if(dist_count == k){
                    res++;
                }
                if(dist_count > k) break;
            }
        }
        return res;
    }
    
}

