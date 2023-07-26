
public class MinimumCharacterToInsetToMakePalindrome {

    public static int minCharsforPalindrome(String str) {
        //Write your code here
        int n = str.length();
        int i = 0;
        int j = n-1;
        int k = j;

        while(j >= i){
            if(str.charAt(i) != str.charAt(j)){
                i = 0;
                k--;
                j = k;
            }else{
                j--;
                i++;
            }
        }
        return n-1-k;
    }

}