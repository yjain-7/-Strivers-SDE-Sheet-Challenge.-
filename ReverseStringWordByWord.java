import java.lang.StringBuilder;
public class ReverseStringWordByWord 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		String[] words = str.split(" ");
		StringBuilder answer = new StringBuilder();
		for(int i = words.length-1 ; i >=0; i--){
			if(i != 0){
				answer  = answer.append(words[i]).append(" ");
			}else{
				answer = answer.append(words[i]);
			}
		}

		return answer.toString();
	}
}
/* 
import java.util.*;
public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		String[] words = str.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
	}
}
*/